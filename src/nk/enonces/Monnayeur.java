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
		if (grosSous >= (2 << LIMITE)) {
			throw new IllegalArgumentException("Trop de grop sous !");
		}
		final Set<PetiteMonnaie> result = new HashSet<PetiteMonnaie>();

		// pas de slot pour la plus petite unité
		final MultiLoop ml = new MultiLoop((short) (CentsInfo.values().length - 1), LIMITE);

		// principe : division euclidienne, enough said

		// pof les maxs des boucles
		for (CentsInfo ci : CentsInfo.values()) {
			ml.setLimite((short) ci.ordinal(), grosSous / ci.getMontant());
		}

		return result;
	}
}
