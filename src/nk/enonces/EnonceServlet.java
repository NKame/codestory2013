package nk.enonces;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nk.rdb.RdbManager;

@WebServlet("/enonce/*")
public class EnonceServlet extends HttpServlet {
	private static final long serialVersionUID = -6586231214913008904L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// poussé par Drools
		final int enonceId = (int) req.getAttribute("id");
		final RdbManager managueur = RdbManager.instance(getServletContext());

		final EnonceBean enonce = managueur.recupere(EnonceBean.class, String.valueOf(enonceId));
		if (enonce != null) {
			resp.setContentType("text/vnd.daringfireball.markdown");
			resp.setCharacterEncoding("UTF-8");

			resp.getWriter().write(enonce.getContenuMarkdown());
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// poussé par Drools
		final int enonceId = (int) req.getAttribute("id");
		final RdbManager managueur = RdbManager.instance(getServletContext());

		boolean existe = managueur.existe(EnonceBean.class, String.valueOf(enonceId));
		final EnonceBean enonce = new EnonceBean();

		// amis de la torsion bonsoir : le contenu du POST est dans la Map des paramètres...
		// en théorie il faudrait prendre LE paramètre sans valeur qui n'est pas présent dans la query string
		// mais bon
		final Map<String, String[]> parameters = req.getParameterMap();
		for(Map.Entry<String, String[]> param : parameters.entrySet()) {
			// le test là est peut-êtr un tomcatisme des familles...
			if(param.getValue().length == 1 && "".equals(param.getValue()[0])) {
				// on en tient un
				enonce.setContenuMarkdown(param.getKey());
				break;
			}
		}
		managueur.stocke(String.valueOf(enonceId), enonce);

		// Cf. RFC 2616, nouveau => 201, modifié => 202, il ne se passe rien de spécial => 200
		resp.setStatus(existe ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CREATED);
	}
}
