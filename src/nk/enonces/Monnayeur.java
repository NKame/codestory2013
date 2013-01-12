package nk.enonces;

import java.util.HashSet;
import java.util.Set;

public class Monnayeur {
	public static final short LIMITE = 8;

	/**
	 * Renvoie toutes les possibilités de monnayer les grosSous, limité à 127.
	 * 
	 * @param grosSous
	 * @return
	 */
	public Set<PetiteMonnaie> faitLaMonnaie(int grosSous) {
		if (grosSous >= (1 << LIMITE) - 1) {
			throw new IllegalArgumentException("Trop de grop sous !");
		}
		final Set<PetiteMonnaie> result = new HashSet<PetiteMonnaie>();
		
		
		// pas de slot pour la plus petite unité
		final short nbSlots = (short) (CentsInfo.values().length - 1);
		final CentsInfo petitsCents = CentsInfo.values()[nbSlots];
		final MultiCompteur compteur = new MultiCompteur(nbSlots, LIMITE);

		// principe : division euclidienne, enough said

		// pof les maxs des boucles
		for (CentsInfo ci : CentsInfo.values()) {
			final short pos = (short) ci.ordinal();
			if (pos != nbSlots) {
				final int val = grosSous / ci.getMontant();
				compteur.setLimite(pos, val);
				compteur.set(pos, val);
			}
		}

		// Et on déroule
		do {
			PetiteMonnaie pm = new PetiteMonnaie(compteur.get());
			int delta = grosSous - pm.getTotal();
			if(delta >= 0) {
				// oui, c'est nawak, on sait que c'est 1
				pm.set(petitsCents, delta / petitsCents.getMontant());
				result.add(pm);
			}
		} while (compteur.dec());

		return result;
	}
}
