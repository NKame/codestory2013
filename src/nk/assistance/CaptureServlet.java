package nk.assistance;

import static nk.assistance.AssistanceStockage.stocke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Capture des requêtes inconnues.
 */
public class CaptureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String[] PAS_INTERESSANT = new String[] { "connection", "cookie", "date", "host",
			"ua-cpu" };

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CaptureServlet() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		captureRequest(getServletContext(), request);

		// plus propre de répondre en 404 dans ce cas
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}

	@SuppressWarnings("unchecked")
	public static void captureRequest(ServletContext sc, HttpServletRequest request) {
		final Requete demande = new Requete();
		demande.methode = request.getMethod();
		demande.chemin = (String) request.getAttribute("javax.servlet.forward.request_uri");
		demande.queryString = (String) request.getAttribute("javax.servlet.forward.query_string");
		demande.parametres = request.getParameterMap();
		demande.postBody = (String) request.getAttribute("postBody");

		final Map<String, String[]> entetes = new HashMap<String, String[]>();
		final Enumeration<String> enumNames = request.getHeaderNames();
		while (enumNames.hasMoreElements()) {
			final String name = enumNames.nextElement();
			String headerKey = name.toLowerCase();
			if (Arrays.binarySearch(PAS_INTERESSANT, headerKey) < 0) {
				final Enumeration<String> enumValues = request.getHeaders(name);
				final List<String> valeurs = new ArrayList<String>();
				while (enumValues.hasMoreElements()) {
					valeurs.add(enumValues.nextElement());
				}
				entetes.put(headerKey, valeurs.toArray(new String[valeurs.size()]));
			}
		}
		demande.entetes = entetes;

		stocke(sc, demande);
	}
}
