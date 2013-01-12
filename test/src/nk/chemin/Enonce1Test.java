package nk.chemin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import nk.rules.AgentDeReconaissance;

import org.junit.BeforeClass;
import org.junit.Test;

public class Enonce1Test {
	private static AgentDeReconaissance agent;

	@BeforeClass
	public static void setUp() {
		agent = new AgentDeReconaissance("/nk/chemin/routes.drl");
	}

	@Test
	public void test8() {
		DecisionRoutage dr = new DecisionRoutage();
		dr.setPath("/scalaskel/change/08");
		agent.roule(dr);

		assertEquals(1, dr.getTypeRoutage());
		assertTrue(dr.isDecide());
		assertTrue(dr.getContexte() != null);
		assertTrue(dr.getContexte().size() == 1);
		assertTrue(dr.getContexte().containsKey("json"));
		assertTrue(dr.getContexte().get("json") instanceof Set<?>);
		assertEquals("/WEB-INF/jsp/json.jsp", dr.getTargetPath());
	}
}
