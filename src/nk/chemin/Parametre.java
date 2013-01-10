package nk.chemin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Parametre {
	private String nom;
	private String valeur;

	public static Collection<Parametre> derouleRequete(Map<String, String[]> entrant) {
		final List<Parametre> result = new ArrayList<Parametre>();

		if (entrant != null) {
			for (Map.Entry<String, String[]> entree : entrant.entrySet()) {
				for (String s : entree.getValue()) {
					result.add(new Parametre(entree.getKey(), s));
				}
			}
		}

		return result;
	}

	public Parametre(String nom, String valeur) {
		this.nom = nom;
		this.valeur = valeur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
}
