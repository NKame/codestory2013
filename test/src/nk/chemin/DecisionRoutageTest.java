package nk.chemin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import nk.rules.AgentDeReconaissance;

import org.junit.Test;

public class DecisionRoutageTest {

	@Test
	public void testCompilationRegles() {
		new AgentDeReconaissance("/nk/chemin/routes.drl");
	}

	@Test
	public void testResolutionStatiqueTxt() {
		final DecisionRoutage dr = new DecisionRoutage();

		dr.resoudStatique("a.txt");

		assertTrue(dr.isDecide());
		assertEquals(1, dr.getTypeRoutage());
		assertEquals("WEB-INF/static/a.txt", dr.getTargetPath());
	}

	@Test
	public void testResolutionStatiqueNonTxt() {
		final DecisionRoutage dr = new DecisionRoutage();
		
		dr.resoudStatique("a.truc");

		assertTrue(dr.isDecide());
		assertEquals(1, dr.getTypeRoutage());
		assertEquals("WEB-INF/static/a.truc", dr.getTargetPath());
	}
}
