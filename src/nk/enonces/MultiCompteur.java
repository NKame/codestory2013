package nk.enonces;

/**
 * Evite d'avoir à gérer des boucles imbriquées.
 * Oui, c'est pour se faire plaisir. 
 */
public class MultiCompteur {
	private short nbSlots;
	private short bitParSlot;
	
	private long compteur = 0;
	private long max = 0;
	private final int maxParSlot;

	public MultiCompteur(short nbSlots, short bitParSlot) {
		this.nbSlots = nbSlots;
		this.bitParSlot = bitParSlot;
		maxParSlot = (1 << bitParSlot) - 1;
	}
	
	public void setLimite(short numSlot, int valLimite) {
		checkBounds(numSlot, valLimite);
		max += (valLimite - mask(compteur, numSlot)) << (numSlot * bitParSlot);
	}
	
	public void set(short numSlot, int val) {
		checkBounds(numSlot, val);
		compteur += (val - mask(compteur, numSlot)) << (numSlot * bitParSlot);
	}
	
	public int get(short numSlot) {
		return mask(compteur, numSlot);
	}
	
	public boolean inc() {
		return false;
	}
	
	/**
	 * Décrémente le compteur en partant de la droite (numSlots - 1).
	 * @return true si on a pu décrémenter, false sinon
	 */
	public boolean dec() {
		if(compteur != 0) {
			boolean finished = false;
			for(short i = (short) (nbSlots - 1); i >= 0; --i) {
				int val = mask(compteur, i);
				if(val == 0) {
					val = mask(max, i);
				} else {
					--val;
					finished = true;
				}
				set(i, val);
				if(finished) {
					break;
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Renvoie l'état en cours sous forme d'un tableau.
	 * Comment ça ça détruit toute le travail sur le masquage binaire ?? Chuuuut.
	 * @return
	 */
	public int[] get() {
		int[] result = new int[nbSlots];
		for(short i = 0; i < nbSlots; ++i) {
			result[i] = get(i);
		}
		return result;
	}

	/**
	 * Et pas James Bond.
	 * @param numSlot
	 * @param valLimite
	 */
	private void checkBounds(short numSlot, int valLimite) {
		if(valLimite >= (1 << bitParSlot) || numSlot >= nbSlots) {
			throw new IllegalArgumentException("Compteur " + numSlot + " sous-dimensionné pour " + valLimite + " ou slot inconnu (" + numSlot + ")");
		}
	}

	private int mask(long number, short numSlot) {
		return (int) ((number >> (numSlot * bitParSlot)) & maxParSlot);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("MultiCompteur[");
		final String shoen_separator = " :: ";
		
		for(short i = 0; i < nbSlots; ++i) {
			sb.append(mask(compteur, i)).append("/").append(mask(max, i)).append(shoen_separator);
		}
		if(nbSlots > 0) {
			sb.setLength(sb.length() - shoen_separator.length());
		}
		sb.append("]");
		return sb.toString();
	}
}