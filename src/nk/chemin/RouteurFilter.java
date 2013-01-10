package nk.chemin;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collection;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nk.rules.AgentDeReconaissance;

/**
 * C'est le coeur du réseau. C'est moche un coeur.
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/*" })
public class RouteurFilter implements Filter {
	private AgentDeReconaissance agent;

	public RouteurFilter() {
	}

	public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest request = (HttpServletRequest) sRequest;
		final HttpServletResponse response = (HttpServletResponse) sResponse;

		final DecisionRoutage dec = new DecisionRoutage();
		dec.setPath(request.getPathInfo());
		final Collection<Parametre> parametres = Parametre.derouleRequete(request.getParameterMap());
		
		agent.roule(dec, parametres);

		switch (dec.getTypeRoutage()) {
		case 1:
			// routage statique
			RequestDispatcher rd = sRequest.getRequestDispatcher(dec.getTargetPath());
			rd.forward(sRequest, sResponse);
			break;
		default:
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		try {
			agent = new AgentDeReconaissance(MessageFormat.format("/{0}/routes.drl", this.getClass().getPackage()
					.getName().replaceAll("\\.", "/")));
		} catch (Exception e) {
			throw new UnavailableException("On est mort : " + e.getMessage());
		}
	}

	public void destroy() {
		// ça ne sert à rien, c'est juste pour rajouter des lignes de code
		// qui vont faire baisser le taux de couverture :-D
		agent = null;
	}
}