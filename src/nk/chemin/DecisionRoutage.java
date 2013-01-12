package nk.chemin;

import java.util.HashMap;
import java.util.Map;


/**
 * Plein de getter et setters, c'est la rule de draigles.
 */
public class DecisionRoutage {
	private boolean decide = false;
	private String path;
	private String methode;

	/**
	 * 0 - inconnu, 1 - interne application, 2 - redirect permanent
	 */
	private int typeRoutage = 0;
	private String typeMIME = "text/html";
	private String targetPath;
	
	/**
	 * Donnees que le routage souhaite envoyer dans les attributs de requête.
	 */
	private Map<String, Object> contexte;

	/**
	 * Décide de router vers une ressource statique.
	 * 
	 * @param chemin
	 */
	public void resoudStatique(String chemin) {
		decide = true;
		// huhu
		targetPath = "/WEB-INF/static/" + chemin;
		typeRoutage = 1;
	}

	/**
	 * Décide de router en interne.
	 * 
	 * @param chemin
	 */
	public void resoudDynamique(String chemin) {
		decide = true;
		// huhu
		targetPath = chemin;
		typeRoutage = 1;
	}
	
	/**
	 * On continue comme si de rien n'était.
	 */
	public void include() {
		decide = true;
		targetPath = path;
		typeRoutage = 1;
	}
	
	public void redirectPermanent(String uriAbsolue) {
		decide = true;
		targetPath = uriAbsolue;
		typeRoutage = 2;
	}
	
	public void jsonDirect(Object o) {
		decide = true;
		typeRoutage = 1;
		targetPath = "/WEB-INF/jsp/json.jsp";
		contexte = new HashMap<String, Object>();
		contexte.put("json", o);
	}
	
	public boolean isDecide() {
		return decide;
	}

	public void setDecide(boolean decide) {
		this.decide = decide;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMethode() {
		return methode;
	}

	public void setMethode(String methode) {
		this.methode = methode;
	}

	public int getTypeRoutage() {
		return typeRoutage;
	}

	public void setTypeRoutage(int typeRoutage) {
		this.typeRoutage = typeRoutage;
	}

	public String getTypeMIME() {
		return typeMIME;
	}

	public void setTypeMIME(String typeMIME) {
		this.typeMIME = typeMIME;
	}

	public String getTargetPath() {
		return targetPath;
	}

	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}

	public Map<String, Object> getContexte() {
		return contexte;
	}

	public void setContexte(Map<String, Object> contexte) {
		this.contexte = contexte;
	}
}
