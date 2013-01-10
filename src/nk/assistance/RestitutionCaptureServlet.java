package nk.assistance;

import static nk.assistance.AssistanceStockage.restitue;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.stringtree.json.JSONWriter;

@WebServlet("/assistance/restitutionCapture")
public class RestitutionCaptureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.addHeader("Content-type", "application/json");
		final JSONWriter jason = new JSONWriter(false);
		final Set<Requete> demandes = restitue(getServletContext());
		
		resp.getWriter().write(jason.write(demandes));
	}
}
