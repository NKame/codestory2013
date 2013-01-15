package nk.enonces;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nk.rdb.RdbManager;

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

			if (enonce.getContenuMarkdown() != null) {
				resp.getWriter().write(enonce.getContenuMarkdown());
			}
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// poussé par Drools
		final int enonceId = (int) req.getAttribute("id");
		final String contenu = (String) req.getAttribute("postBody");
		final RdbManager managueur = RdbManager.instance(getServletContext());

		boolean existe = managueur.existe(EnonceBean.class, String.valueOf(enonceId));
		final EnonceBean enonce = new EnonceBean();

		enonce.setContenuMarkdown(contenu);

		managueur.stocke(String.valueOf(enonceId), enonce);

		// Cf. RFC 2616, nouveau => 201, modifié => 202, il ne se passe rien de spécial => 200
		resp.setStatus(existe ? HttpServletResponse.SC_OK : HttpServletResponse.SC_CREATED);
	}
}
