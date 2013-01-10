package nk.assistance;

import nk.chemin.DecisionRoutage;
import nk.rules.AgentDeReconaissance;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RoutageAssistanceTest {

	private static AgentDeReconaissance agent;

	@BeforeClass
	public static void setUp() {
		agent = new AgentDeReconaissance("/nk/chemin/routes.drl");
	}

	@Test
	public void testFavicon() {
		DecisionRoutage dr = new DecisionRoutage();
		dr.setPath("/favicon.ico");
		agent.roule(dr);

		Assert.assertTrue(dr.isDecide());
		Assert.assertEquals(2, dr.getTypeRoutage());
	}

	@Test
	public void testAssistance() {
		final DecisionRoutage dr = new DecisionRoutage();
		dr.setPath("/assistance/SansPeugeot");

		agent.roule(dr);

		Assert.assertTrue(dr.isDecide());
		Assert.assertEquals(1, dr.getTypeRoutage());
		Assert.assertEquals(dr.getPath(), dr.getTargetPath());
	}
}
