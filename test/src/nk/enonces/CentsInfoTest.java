package nk.enonces;

import org.junit.Assert;
import org.junit.Test;

public class CentsInfoTest {

	@Test
	public void testDescendant() {
		int last = Integer.MAX_VALUE;
		for(CentsInfo ci : CentsInfo.values()) {
			final int current = ci.getMontant();
			Assert.assertTrue("Montant trop faible pour " + ci.name(), current < last);
			last = current;
		}
	}
}
