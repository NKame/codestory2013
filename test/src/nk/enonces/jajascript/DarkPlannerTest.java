package nk.enonces.jajascript;

import java.util.List;

import junit.framework.Assert;
import nk.assistance.IO;

import org.junit.Test;

public class DarkPlannerTest {

	@Test
	public void test() {
		DarkPlanner dp = new DarkPlanner();
		final List<Trajet> trajets = charge(dp, "payload1.txt");
		Assert.assertEquals(1, trajets.size());
	}

	@Test
	public void testClean() {
		DarkPlanner dp = new DarkPlanner();
		final List<Trajet> trajets = charge(dp, "payload2.txt");
		Assert.assertEquals(3, trajets.size());

		final List<Trajet> filtre = dp.filtre(trajets);

		Assert.assertEquals(1, filtre.size());

		final Planning p = dp.resoud(filtre);

		Assert.assertTrue(p.getGain().intValue() == 12);
		Assert.assertEquals(1, p.getPath().size());
		Assert.assertEquals("AF516", p.getPath().get(0));
	}

	@Test
	public void testClean2() {
		DarkPlanner dp = new DarkPlanner();
		final List<Trajet> trajets = charge(dp, "payload3.txt");
		Assert.assertEquals(4, trajets.size());

		final List<Trajet> filtre = dp.filtre(trajets);

		Assert.assertEquals(3, filtre.size());

		final Planning p = dp.resoud(filtre);

		Assert.assertEquals(18, p.getGain().intValue());
		Assert.assertEquals(2, p.getPath().size());
		Assert.assertEquals("MONAD42", p.getPath().get(0));
		Assert.assertEquals("LEGACY01", p.getPath().get(1));
	}

	@Test
	public void testClean3() {
		DarkPlanner dp = new DarkPlanner();
		final List<Trajet> trajets = charge(dp, "payload4.txt");
		Assert.assertEquals(4, trajets.size());

		final List<Trajet> filtre = dp.filtre(trajets);

		Assert.assertEquals(4, filtre.size());

		final Planning p = dp.resoud(filtre);

		Assert.assertEquals(39, p.getGain().intValue());
		Assert.assertEquals(4, p.getPath().size());
		Assert.assertEquals("MONAD42", p.getPath().get(0));
		Assert.assertEquals("META18", p.getPath().get(1));
		Assert.assertEquals("LEGACY01", p.getPath().get(2));
		Assert.assertEquals("YAGNI17", p.getPath().get(3));
	}

	@Test
	public void testClean4() {
		DarkPlanner dp = new DarkPlanner();
		final List<Trajet> trajets = charge(dp, "payload5.txt");
		Assert.assertEquals(7, trajets.size());

		final List<Trajet> filtre = dp.filtre(trajets);

		Assert.assertEquals(3, filtre.size());

		final Planning p = dp.resoud(filtre);

		Assert.assertEquals(20, p.getGain().intValue());
		Assert.assertEquals(2, p.getPath().size());
		Assert.assertEquals("AF516", p.getPath().get(0));
		Assert.assertEquals("LEGACY01", p.getPath().get(1));
	}

	@Test
	public void testClean5() {
		DarkPlanner dp = new DarkPlanner();
		final List<Trajet> trajets = charge(dp, "payload.cs.0.txt");
		Assert.assertEquals(4, trajets.size());

		final List<Trajet> filtre = dp.filtre(trajets);

		Assert.assertEquals(4, filtre.size());

		final Planning p = dp.resoud(filtre);

		Assert.assertEquals(18, p.getGain().intValue());
		Assert.assertEquals(2, p.getPath().size());
		Assert.assertEquals("AF514", p.getPath().get(0));
		Assert.assertEquals("BA01", p.getPath().get(1));
	}

	public List<Trajet> charge(DarkPlanner dp, final String fichier) {
		final String jsonText = IO.readText(this.getClass().getResourceAsStream(fichier));
		return dp.chargeTexteJSON(jsonText);
	}

}
