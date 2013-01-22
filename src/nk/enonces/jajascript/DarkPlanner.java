package nk.enonces.jajascript;

import static nk.rdb.AerosolEvian.rehydrate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

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
		if (dicos != null) {
			for (Map<String, Object> dico : dicos) {
				result.add(rehydrate(dico, Trajet.class));
			}
			Collections.sort(result);
		}
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
	protected Planning resoudPourri(final List<Trajet> trajets) {
		int limiteCalcul = 10000;
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
				--limiteCalcul;
				if (limiteCalcul <= 0) {
					throw new IllegalArgumentException("Houlà trop compliqué, il va falloir y réfléchir");
				}
			} while (compteur.dec());
		}

		return result;
	}

	protected Planning resoud(final List<Trajet> trajets) {
		Planning result = new Planning();

		final SortedMap<Noeud, EtatNoeud> graphe = prepareGraphe(trajets);

		final Noeud debut = graphe.firstKey();
		debut.marquage = BigDecimal.ZERO;
		final Noeud fin = graphe.lastKey();

		final SortedSet<Noeud> q = new TreeSet<Noeud>(new Comparator<Noeud>() {
			@Override
			public int compare(Noeud o1, Noeud o2) {
				int result = o1.marquage.compareTo(o2.marquage);
				if (result == 0) {
					result = o1.compareTo(o2);
				}
				return result;
			}

		});
		q.addAll(graphe.keySet());

		while (!q.isEmpty()) {
			final Noeud proche = q.first();
			if (proche.equals(fin)) {
				// fini
				break;
			}
			if(!q.remove(proche)) {
				throw new IllegalArgumentException("C'est ça");
			}

			if(explore(proche, fin, graphe, q)) {
				// on exploré jusqu'au bout
				break;
			}
		}

		// normalement on a trouvé... on dépile
		final SortedSet<Noeud> pile = new TreeSet<Noeud>();
		Noeud courant = fin;
		do {
			pile.add(courant);
			courant = courant.prev;
		} while (courant != null);

		// et on recherche le chemin
		Noeud prev = null;
		outer: for (Iterator<Noeud> it = pile.iterator(); it.hasNext();) {
			if (prev == null) {
				prev = it.next();
				continue;
			}
			Noeud curr = it.next();
			EtatNoeud en = prev.e;
			for (Vertice v : en.vertices) {
				if (v.fin.equals(curr)) {
					// vertice trouvée, on passe à la suite
					if (v.vol != null) {
						result.getPath().add(v.vol);
						result.setGain(result.getGain().add(v.gain));
					}
					prev = curr;
					continue outer;
				}
			}
			throw new IllegalArgumentException("dafuq");
		}

		return result;
	}

	/**
	 * Renvoie true si a touché la fin.
	 * @param depart
	 * @param fin
	 * @param graphe
	 * @param q
	 * @return
	 */
	protected boolean explore(final Noeud depart, Noeud fin, final SortedMap<Noeud, EtatNoeud> graphe, final SortedSet<Noeud> q) {
		for (Vertice v : depart.e.vertices) {
			if (q.contains(v.fin)) {
				EtatNoeud eFin = graphe.get(v.fin);
				BigDecimal parcours = depart.marquage.add(v.poids);
				if (parcours.compareTo(eFin.n.marquage) < 0) {
					// on enlève avant de mettre à jour la valeur,
					// sinon ça pète le TreeSet
					q.remove(eFin.n);
					
					eFin.n.marquage = parcours;
					eFin.n.prev = depart;
					
					if(eFin.n.equals(fin)) {
						// c'est fini
						return true;
					}
					
					

					// si la vertice est factice, on continue plus loin
					if (v.vol == null) {
						if(explore(eFin.n, fin, graphe, q)) {
							return true;
						}
					} else {
						// pas factice, on remet le noeud pour tri
						q.add(eFin.n);
					}
				}
			}
		}
		return false;
	}

	protected SortedMap<Noeud, EtatNoeud> prepareGraphe(final List<Trajet> trajets) {
		SortedMap<Noeud, EtatNoeud> result = new TreeMap<Noeud, EtatNoeud>();
		final BigDecimal un = new BigDecimal(1);
		un.setScale(15);

		// d'abord il nous faut un graphe
		for (Trajet t : trajets) {
			final Noeud dep = new Noeud(t.getDEPART());
			final Noeud arr = new Noeud(t.getDEPART().add(t.getDUREE()));

			EtatNoeud e = result.get(dep);
			if (e == null) {
				e = new EtatNoeud(dep);
				result.put(dep, e);
			}
			e.vertices.add(new Vertice(arr, t.getVOL(), t.getPRIX(), un.divide(new BigDecimal(t.getPRIX(), 0),
					RoundingMode.FLOOR)));

			if (!result.containsKey(arr)) {
				result.put(arr, new EtatNoeud(arr));
			}
		}
		Noeud prev = null;
		// ensuite on s'assure qu'il y a un chemin partout
		outer: for (Iterator<Noeud> it = result.keySet().iterator(); it.hasNext();) {
			if (prev == null) {
				prev = it.next();
				continue;
			}
			Noeud curr = it.next();
			EtatNoeud en = prev.e;
			for (Vertice v : en.vertices) {
				if (v.fin.equals(curr)) {
					prev = curr;
					continue outer;
				}
			}
			// pas de vertice trouvée entre prev et curr
			en.vertices.add(new Vertice(curr, null, null, BigDecimal.ZERO));

			prev = curr;
		}

		return result;
	}

	private static class Noeud implements Comparable<Noeud> {
		public EtatNoeud e;
		public Noeud prev = null;
		final BigInteger id;
		BigDecimal marquage = BigDecimal.valueOf(Long.MAX_VALUE);

		public Noeud(BigInteger id) {
			this.id = id;
		}

		@Override
		public int compareTo(Noeud o) {
			return id.compareTo(o.id);
		}

		@Override
		public int hashCode() {
			return id.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			return id.equals(((Noeud) obj).id);
		}

		public String toString() {
			return "N(" + id + ", " + e.vertices + ")";
		}
	}

	private static class EtatNoeud {
		public EtatNoeud(Noeud n) {
			this.n = n;
			n.e = this;
		}

		final Noeud n;
		List<Vertice> vertices = new ArrayList<Vertice>();

		public String toString() {
			return "";
		}
	}

	private static class Vertice {
		private final Noeud fin;
		private final String vol;
		private final BigInteger gain;
		private final BigDecimal poids;

		public Vertice(Noeud fin, String vol, BigInteger gain, BigDecimal poids) {
			this.fin = fin;
			this.vol = vol;
			this.gain = gain;
			this.poids = poids;
		}

		public String toString() {
			return "=> " + fin.id + "[" + vol + "]";
		}
	}
}
