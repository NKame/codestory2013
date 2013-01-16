package nk.enonces.jajascript;

import java.math.BigInteger;

public class Trajet implements Comparable<Trajet> {
	private String VOL;
	private BigInteger DEPART;
	private BigInteger DUREE;
	private BigInteger PRIX;

	public String getVOL() {
		return VOL;
	}

	public void setVOL(String vOL) {
		VOL = vOL;
	}

	public BigInteger getDEPART() {
		return DEPART;
	}

	public void setDEPART(BigInteger dEPART) {
		DEPART = dEPART;
	}

	public BigInteger getDUREE() {
		return DUREE;
	}

	public void setDUREE(BigInteger dUREE) {
		DUREE = dUREE;
	}

	public BigInteger getPRIX() {
		return PRIX;
	}

	public void setPRIX(BigInteger pRIX) {
		PRIX = pRIX;
	}

	/**
	 * En fait, comme on a trié, on ne vérifie que la moitié de l'inclusion
	 * @param o
	 * @return
	 */
	public boolean contenu(Trajet o) {		
		return (this.DEPART.add(this.DUREE)).compareTo(o.DEPART.add(o.DUREE)) <= 0;
	}
	
	/**
	 * Même prix ou supérieur = plusRentable. 
	 * @param o
	 * @return
	 */
	public boolean plusRentable(Trajet o) {
		return this.PRIX.compareTo(o.PRIX) >= 0;
	}

	/**
	 * Test strict sur les horaires.
	 * @param prev
	 * @return
	 */
	public boolean memesHoraires(Trajet o) {
		return this.DEPART.equals(o.DEPART) && this.DUREE.equals(o.DUREE);
	}

	/**
	 * Renvoie si la cible est bien après ce trajet.
	 * @param t
	 * @return
	 */
	public boolean avant(Trajet o) {		
		return (this.DEPART.add(this.DUREE)).compareTo(o.DEPART) <= 0;
	}	
	
	@Override
	public int compareTo(Trajet o) {
		// dans l'ordre : heure de départ (ASC), durée (ASC), prix (DESC), vol (ASC)
		int result = this.DEPART.compareTo(o.DEPART);
		if (result == 0) {
			result = this.DUREE.compareTo(o.DUREE);
		}
		if (result == 0) {
			result = o.PRIX.compareTo(this.PRIX);
		}
		if (result == 0) {
			result = this.VOL.compareTo(o.VOL);
		}

		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DEPART == null) ? 0 : DEPART.hashCode());
		result = prime * result + ((DUREE == null) ? 0 : DUREE.hashCode());
		result = prime * result + ((PRIX == null) ? 0 : PRIX.hashCode());
		result = prime * result + ((VOL == null) ? 0 : VOL.hashCode());
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
		Trajet other = (Trajet) obj;
		if (DEPART == null) {
			if (other.DEPART != null)
				return false;
		} else if (!DEPART.equals(other.DEPART))
			return false;
		if (DUREE == null) {
			if (other.DUREE != null)
				return false;
		} else if (!DUREE.equals(other.DUREE))
			return false;
		if (PRIX == null) {
			if (other.PRIX != null)
				return false;
		} else if (!PRIX.equals(other.PRIX))
			return false;
		if (VOL == null) {
			if (other.VOL != null)
				return false;
		} else if (!VOL.equals(other.VOL))
			return false;
		return true;
	}

	
}
