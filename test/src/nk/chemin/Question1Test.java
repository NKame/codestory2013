package nk.chemin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import nk.rules.AgentDeReconaissance;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Question1Test {

	private static AgentDeReconaissance agent;

	@BeforeClass
	public static void setUp() {
		agent = new AgentDeReconaissance("/nk/chemin/routes.drl");
	}

	@Test
	public void testQuestionsInitiales() {
		DecisionRoutage dr = new DecisionRoutage();
		agent.roule(dr, new Parametre("q", "Quelle est ton adresse email"));

		Assert.assertEquals(1, dr.getTypeRoutage());
		Assert.assertEquals("/WEB-INF/static/mail.txt", dr.getTargetPath());

		disOui("Es tu abonne a la mailing list(OUI/NON)");
		disOui("Es tu heureux de participer(OUI/NON)");
		disOui("As tu bien recu le premier enonce(OUI/NON)");
	}

	@Test
	public void testQuestionsCalculs() {
		DecisionRoutage dr = new DecisionRoutage();
		dr.setQueryString("q=4+5");
		agent.roule(dr, new Parametre("q", "4 5"));

		assertEquals(1, dr.getTypeRoutage());
		assertEquals("/WEB-INF/jsp/chaine.jsp", dr.getTargetPath());
		assertTrue(dr.getContexte() != null);
		assertTrue(dr.getContexte().size() == 1);
		assertTrue(dr.getContexte().containsKey("chaine"));
		assertEquals("9", dr.getContexte().get("chaine"));
		
		dr = new DecisionRoutage();
		dr.setQueryString("q=1,5*4");
		agent.roule(dr);
		assertEquals(1, dr.getTypeRoutage());
		assertEquals("/WEB-INF/jsp/chaine.jsp", dr.getTargetPath());
		assertTrue(dr.getContexte() != null);
		assertTrue(dr.getContexte().size() == 1);
		assertTrue(dr.getContexte().containsKey("chaine"));
		assertEquals("6", dr.getContexte().get("chaine"));		
	}

	private void disOui(String question) {
		DecisionRoutage dr = new DecisionRoutage();
		agent.roule(dr, new Parametre("q", question));

		Assert.assertEquals(1, dr.getTypeRoutage());
		Assert.assertEquals("/WEB-INF/static/OUI.txt", dr.getTargetPath());
	}

	@Test
	public void testQuestionInconnue() {
		final DecisionRoutage dr = new DecisionRoutage();
		agent.roule(dr, new Parametre("q", "Ca va bien (OUI/NON)"));

		Assert.assertEquals(1, dr.getTypeRoutage());
		Assert.assertEquals("/WEB-INF/static/NON.txt", dr.getTargetPath());
	}

	@Test
	public void testPasDeplantage() {
		final DecisionRoutage dr = new DecisionRoutage();
		agent.roule(dr);

		dr.setPath("aupif");
		agent.roule(dr);

		agent.roule(dr, new Parametre("q", null));
	}
}