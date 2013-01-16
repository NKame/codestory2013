package nk.chemin;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nk.assistance.CaptureServlet;
import nk.assistance.IO;
import nk.rules.AgentDeReconaissance;

/**
 * C'est le coeur du réseau. C'est moche un coeur.
 */
public class RouteurFilter implements Filter {
	private AgentDeReconaissance agent;
	private ServletContext sc;

	public RouteurFilter() {
	}

	public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest request = (HttpServletRequest) sRequest;
		final HttpServletResponse response = (HttpServletResponse) sResponse;

		final DecisionRoutage dec = new DecisionRoutage();
		dec.setPath(request.getRequestURI());
		dec.setQueryString(request.getQueryString());
		dec.setMethode(request.getMethod());
		String readText = IO.readText(request.getInputStream());
		if(readText != null) {
			readText = URLDecoder.decode(readText, request.getCharacterEncoding());
		}
		dec.setPostBody(readText);
		@SuppressWarnings("unchecked")
		final Collection<Parametre> parametres = Parametre.derouleRequete(request.getParameterMap());

		agent.roule(dec, parametres);

		switch (dec.getTypeRoutage()) {
		case 1:
		// routage statique
		{
			if(dec.isCapture()) {
				CaptureServlet.captureRequest(this.sc, request);
			}
			pushAttributs(request, dec);
			RequestDispatcher rd = sRequest.getRequestDispatcher(dec.getTargetPath());			
			rd.forward(sRequest, sResponse);
		}
			break;
		case 2:
		// redirect permanent
		{
			response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
			response.addHeader("Location", dec.getTargetPath());
		}
			break;
		case 3:
			// si on chainait ?
		{
			if(dec.isCapture()) {
				CaptureServlet.captureRequest(this.sc, request);
			}
			pushAttributs(request, dec);
			chain.doFilter(sRequest, sResponse);
			break;
		}
		default:
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void pushAttributs(final HttpServletRequest request, final DecisionRoutage dec) {
		if(dec.getContexte() != null) {
			for(Map.Entry<String, Object> aMettre : dec.getContexte().entrySet()) {
				request.setAttribute(aMettre.getKey(), aMettre.getValue());
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.sc = fConfig.getServletContext();
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
		this.sc = null;
		this.agent = null;
	}
}