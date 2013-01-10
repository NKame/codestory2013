package nk.chemin;

import java.util.Map;

/**
 * Plein de getter et setters, c'est la rule de draigles.
 */
public class DecisionRoutage {
	private boolean decide = false;
	private String path;
	private String methode;

	/**
	 * 0 - inconnu 1 - page statique
	 */
	private int typeRoutage = 0;
	private String typeMIME = "text/html";
	private String targetPath;

	/**
	 * Décide de router vers une ressource statique.
	 * 
	 * @param chemin
	 */
	public void resoudStatique(String chemin) {
		decide = true;
		// huhu
		targetPath = "WEB-INF/static/" + chemin;
		typeRoutage = 1;
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
}
