package nk.assistance;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Classe utilitaire pour voir ce qui a été demandé. Tout en mémoire, pour l'instant on est en interactif.
 */
public class AssistanceStockage implements ServletContextListener, Serializable {
	private static final long serialVersionUID = -5984344822900317494L;

	private Set<Requete> stockage = new HashSet<Requete>();

	public AssistanceStockage() {
	}

	/**
	 * Stocke une requête.
	 * @param r
	 */
	public void stocke(Requete r) {
		stockage.add(r);
	}

	/**
	 * Allez, un micro-effort pour mettre un peu d'immutabilité, pas que ça serve à grand chose en l'espèce.
	 * 
	 * @return
	 */
	public Set<Requete> restitue() {
		return new HashSet<Requete>(stockage);
	}

	public static void stocke(ServletContext sc, Requete r) {
		instance(sc).stocke(r);
	}

	public static Set<Requete> restitue(ServletContext sc) {
		return instance(sc).restitue();
	}

	public void contextInitialized(ServletContextEvent arg0) {
		arg0.getServletContext().setAttribute(this.getClass().getName(), this);
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		arg0.getServletContext().removeAttribute(this.getClass().getName());
	}

	private static AssistanceStockage instance(ServletContext sc) {
		return (AssistanceStockage) sc.getAttribute(AssistanceStockage.class.getName());
	}
}
