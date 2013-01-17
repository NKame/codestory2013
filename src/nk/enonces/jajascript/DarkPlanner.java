package nk.enonces.jajascript;

import static nk.rdb.AerosolEvian.rehydrate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import nk.enonces.MultiCompteur;

import org.stringtree.json.JSONReader;

public class DarkPlanner {

	public Planning planifieLikeAWinner(final String jsonText) {
		final List<Trajet> trajetsBruts = chargeTexteJSON(jsonText);
		final List<Trajet> trajetsFiltres = filtre(trajetsBruts);
		return resoud(trajetsFiltres);
	}

	protected List<Trajet> chargeTexteJSON(final String jsonText) {
		JSONReader jr = new JSONReader();
		@SuppressWarnings("unchecked")
		final List<Map<String, Object>> dicos = (List<Map<String, Object>>) jr.read(jsonText);
		final List<Trajet> result = new ArrayList<Trajet>();
		for (Map<String, Object> dico : dicos) {
			result.add(rehydrate(dico, Trajet.class));
		}
		Collections.sort(result);
		return result;
	}

	protected List<Trajet> filtre(final List<Trajet> trajets) {
		final List<Trajet> result = new ArrayList<Trajet>(trajets.size());
		Trajet prev = null;
		for (Iterator<Trajet> it = trajets.iterator(); it.hasNext();) {
			final Trajet curr = it.next();
			if (curr.getPRIX() == null || curr.getDEPART() == null || curr.getDUREE() == null
					|| curr.getVOL() == null || BigInteger.ZERO.equals(curr.getPRIX())) {
				// poubelle
				continue;
			}
			if (prev != null) {
				if (curr.contenu(prev)) {
					// on est dans le précédent
					if (curr.plusRentable(prev)) {
						// on est meilleur, on dégage le plus gros
					} else if (!curr.memesHoraires(prev)) {
						// plus petit, y'a encore un espoir d'être utile
						result.add(prev);
					} else {
						// poubelle
						continue;
					}
				} else {
					// on n'est pas dans le précédent, on garde
					result.add(prev);
				}
			}
			prev = curr;
		}
		// et on ajoute le dernier
		result.add(prev);

		return result;
	}

	/**
	 * Trajets filtrés et triés.
	 * 
	 * @param trajets
	 * @return
	 */
	protected Planning resoud(final List<Trajet> trajets) {
		Planning result = new Planning();

		// il faut tester "toutes" les combinaisons de trajets entre eux...
		// approche naïve en première passe
		final int nbTrajets = trajets.size();
		if (nbTrajets == 1) {
			final Trajet leBigMac = trajets.get(0);
			result.setGain(leBigMac.getPRIX());
			result.getPath().add(leBigMac.getVOL());
		} else {
			// le MultiCompteur ! le MultiCompteur ! C'est un plébiscite !
			// en décrémentant le MultiCompteur, on va examiner toutes les combinaisons
			final BigInteger gainMax = BigInteger.ZERO;
			MultiCompteur compteur = new MultiCompteur((short) nbTrajets, (short) 1);
			for (short i = 0; i < nbTrajets; ++i) {
				compteur.setLimite(i, 1);
				compteur.set(i, 1);
			}

			List<String> path = new ArrayList<String>(trajets.size());
			magnifier: // le "magnifier" est une grosse loupe ^^;
			do {
				Trajet prev = null;
				int[] selectionnes = compteur.get();
				BigInteger gain = BigInteger.ZERO;

				path.clear();
				for (int i = 0; i < selectionnes.length; ++i) {
					if (selectionnes[i] > 0) {
						final Trajet t = trajets.get(i);
						if (prev != null) {
							if (!prev.avant(t)) {
								// perdu
								continue magnifier;
							}
							gain = gain.add(prev.getPRIX());
							path.add(prev.getVOL());
						}
						prev = t;
					}
				}
				if (prev != null) {
					gain = gain.add(prev.getPRIX());
					path.add(prev.getVOL());

					// on ne prend que strictement meilleur
					if (gain.compareTo(result.getGain()) > 0) {
						result.setGain(gain);
						result.getPath().clear();
						result.getPath().addAll(path);

						// on n'ira pas plus haut
						if (gain.equals(gainMax)) {
							break magnifier;
						}
					}
				}
			} while (compteur.dec());
		}

		return result;
	}
}
