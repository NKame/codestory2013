package nk.enonces.scalaskel;

import static org.junit.Assert.*;

import nk.enonces.scalaskel.PetiteMonnaie;

import org.junit.Test;

public class PetiteMonnaieTest {

	@Test
	public void testTotal() {
		PetiteMonnaie postMeridien = new PetiteMonnaie(62, 35, 93, 1597);
		assertEquals(62 * 21 + 35 * 11 + 93 * 7 + 1597, postMeridien.getTotal());
	}

}
