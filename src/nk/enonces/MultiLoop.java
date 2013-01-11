package nk.enonces;

/**
 * Evite d'avoir à gérer des boucles imbriquées.
 * Oui, c'est pour se faire plaisir. 
 */
public class MultiLoop {
	private short nbSlots;
	private short bitParSlot;
	
	private long compteur = 0;
	private long max = 0;
	private final int maxParSlot;

	public MultiLoop(short nbSlots, short bitParSlot) {
		this.nbSlots = nbSlots;
		this.bitParSlot = bitParSlot;
		maxParSlot = (2 << bitParSlot) - 1;
	}
	
	public void setLimite(short numSlot, int valLimite) {
		if(valLimite > (2 << bitParSlot)) {
			throw new IllegalArgumentException("Compteur " + numSlot + " sous-dimensionné pour " + valLimite);
		}
		max += (valLimite >> numSlot) - mask(max, numSlot);
	}
	
	public void setCompteur(short numSlot, int val) {
		if(val > (2 << bitParSlot)) {
			throw new IllegalArgumentException("Compteur " + numSlot + " sous-dimensionné pour " + val);
		}
		max += (val >> numSlot) - mask(max, numSlot);
	}
	
	public void start() {
	}
	
	public boolean inc() {
		return false;
	}
	
	public boolean dec() {
		return false;
	}
	
	private int mask(long number, short slot) {
		return (int) ((number << (slot * bitParSlot)) & maxParSlot);
	}
}
