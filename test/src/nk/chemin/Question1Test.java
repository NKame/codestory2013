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
	public void testMail() {
		final DecisionRoutage dr = new DecisionRoutage();
		agent.roule(dr, new Parametre("q", "Quelle est ton adresse email"));
		
		Assert.assertEquals(1, dr.getTypeRoutage());
		Assert.assertEquals("WEB-INF/static/mail.txt", dr.getTargetPath());
	}
	
	@Test
	public void testML() {
		final DecisionRoutage dr = new DecisionRoutage();
		agent.roule(dr, new Parametre("q", "Es tu abonne a la mailing list(OUI/NON)"));
		
		Assert.assertEquals(1, dr.getTypeRoutage());
		Assert.assertEquals("WEB-INF/static/OUI.txt", dr.getTargetPath());
	}

	
	@Test
	public void testQuestionInconnue() {
		final DecisionRoutage dr = new DecisionRoutage();
		agent.roule(dr, new Parametre("q", "Ca va bien (OUI/NON)"));
		
		Assert.assertEquals(1, dr.getTypeRoutage());
		Assert.assertEquals("WEB-INF/static/NON.txt", dr.getTargetPath());
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
