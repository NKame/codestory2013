package nk.enonces;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class MonnayeurTest {

	@Test
	public void test() {
		Monnayeur nayeur = new Monnayeur();
		assertEquals(1, nayeur.faitLaMonnaie(0).size());
		assertEquals(1, nayeur.faitLaMonnaie(1).size());
		assertEquals(1, nayeur.faitLaMonnaie(6).size());
		
		assertEquals(2, nayeur.faitLaMonnaie(7).size());
		
		final Set<PetiteMonnaie> cinquanteHuit = nayeur.faitLaMonnaie(58);
		// System.out.println(cinquanteHuit);
		// ha ha le sale test, ça a une bonne tête, c'est tout.
		assertEquals(48, cinquanteHuit.size());
		
		assertEquals(177, nayeur.faitLaMonnaie(100).size());
	}
}
