package nk.enonces;

import java.util.Arrays;

public class PetiteMonnaie {
	private int[] casiers = new int[CentsInfo.values().length];

	public PetiteMonnaie() {
	}

	public PetiteMonnaie(int... montants) {
		// sans filet ! Mais quelle joie d'utiliser arraycopy
		System.arraycopy(montants, 0, casiers, 0, montants.length);
	}

	public int getFoo() {
		return get(CentsInfo.Foo);
	}

	public int getBar() {
		return get(CentsInfo.Bar);
	}

	public int getQix() {
		return get(CentsInfo.Qix);
	}

	public int getBaz() {
		return get(CentsInfo.Baz);
	}

	public int get(CentsInfo ci) {
		return casiers[ci.ordinal()];
	}

	public int getTotal() {
		int total = 0;
		for(CentsInfo ci : CentsInfo.values()) {
			total += ci.getMontant() * get(ci);
		}
		return total;
	}
	
	public void set(CentsInfo ci, int valeur) {
		casiers[ci.ordinal()] = valeur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(casiers);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PetiteMonnaie other = (PetiteMonnaie) obj;
		if (!Arrays.equals(casiers, other.casiers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PetiteMonnaie [casiers=" + Arrays.toString(casiers) + "]";
	}	
}
