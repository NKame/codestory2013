package nk.assistance;

import java.util.Map;

public class Requete {
	public String methode;
	public String chemin;
	public String queryString;
	public Map<String, String[]> parametres;
	public Map<String, String[]> entetes;
	public String postBody;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chemin == null) ? 0 : chemin.hashCode());
		result = prime * result + ((entetes == null) ? 0 : entetes.hashCode());
		result = prime * result + ((methode == null) ? 0 : methode.hashCode());
		result = prime * result + ((parametres == null) ? 0 : parametres.hashCode());
		result = prime * result + ((postBody == null) ? 0 : postBody.hashCode());
		result = prime * result + ((queryString == null) ? 0 : queryString.hashCode());
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
		Requete other = (Requete) obj;
		if (chemin == null) {
			if (other.chemin != null)
				return false;
		} else if (!chemin.equals(other.chemin))
			return false;
		if (entetes == null) {
			if (other.entetes != null)
				return false;
		} else if (!entetes.equals(other.entetes))
			return false;
		if (methode == null) {
			if (other.methode != null)
				return false;
		} else if (!methode.equals(other.methode))
			return false;
		if (parametres == null) {
			if (other.parametres != null)
				return false;
		} else if (!parametres.equals(other.parametres))
			return false;
		if (postBody == null) {
			if (other.postBody != null)
				return false;
		} else if (!postBody.equals(other.postBody))
			return false;
		if (queryString == null) {
			if (other.queryString != null)
				return false;
		} else if (!queryString.equals(other.queryString))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Requete [methode=" + methode + ", chemin=" + chemin + ", queryString=" + queryString
				+ ", parametres=" + parametres + ", entetes=" + entetes + "]";
	}
}
