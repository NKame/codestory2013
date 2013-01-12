package nk.enonces;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiCompteurTest {

	@Test
	public void testSet() {
		final short nbSlots = (short) 3;
		final short bitsPerSlot = (short) 2;
		final int max = 1 << bitsPerSlot;

		final MultiCompteur mc = new MultiCompteur(nbSlots, bitsPerSlot);
		for (short i = 0; i < nbSlots; ++i) {
			for (int j = max - 1; j >= 0; --j) {
				mc.set(i, j);
				assertEquals("(" + i + ", " + j + ")", j, mc.get(i));
			}
		}
		for (short i = 0; i < nbSlots; ++i) {
			for (int j = 0; j < max; ++j) {
				mc.set(i, j);
				assertEquals("(" + i + ", " + j + ")", j, mc.get(i));
			}
		}
		for (short i = nbSlots - 1; i >= 0; --i) {
			for (int j = 0; j < max; ++j) {
				mc.set(i, j);
				assertEquals("(" + i + ", " + j + ")", j, mc.get(i));
			}
		}
		for (short i = nbSlots - 1; i >= 0; --i) {
			for (int j = max - 1; j >= 0; --j) {
				mc.set(i, j);
				assertEquals("(" + i + ", " + j + ")", j, mc.get(i));
			}
		}
	}

	@Test
	public void testDec() {
		final short nbSlots = (short) 3;
		final short bitsPerSlot = (short) 2;
		final int max = (1 << bitsPerSlot) - 1;

		final MultiCompteur mc = new MultiCompteur(nbSlots, bitsPerSlot);

		double maxLoop = Math.pow((max + 1), nbSlots) - 1;

		for (short i = 0; i < nbSlots; ++i) {
			mc.setLimite(i, max);
			mc.set(i, max);
		}

		// System.out.println("init : " + mc);
		while (mc.dec()) {
			if (--maxLoop < 0) {
				// oups
				fail("Boucle infinie");
			}
			// System.out.println(mc);
		}
		if(maxLoop > 0) {
			fail("Pas assez d'itérations : " + maxLoop + " restante(s)");
		}
	}

}
