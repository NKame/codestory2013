package nk.chemin;

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
		DecisionRoutage dr2 = new DecisionRoutage();
		agent.roule(dr2, new Parametre("q", "Quelle est ton adresse email"));

		Assert.assertEquals(1, dr2.getTypeRoutage());
		Assert.assertEquals("/WEB-INF/static/mail.txt", dr2.getTargetPath());

		disOui("Es tu abonne a la mailing list(OUI/NON)");
		disOui("Es tu heureux de participer(OUI/NON)");
		disOui("As tu bien recu le premier enonce(OUI/NON)");
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