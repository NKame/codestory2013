package nk.chemin;

import java.util.Collections;

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
	public void testOK() {
		final DecisionRoutage dr = new DecisionRoutage();
		dr.setParametres(Collections.singletonMap("q", new String[] { "Quelle est ton adresse email" }));

		agent.roule(dr);
		
		Assert.assertEquals(1, dr.getTypeRoutage());
		Assert.assertEquals("WEB-INF/static/mail.txt", dr.getTargetPath());
	}
}
