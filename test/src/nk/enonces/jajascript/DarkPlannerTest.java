package nk.enonces.jajascript;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import junit.framework.Assert;
import nk.assistance.IO;
import nk.enonces.jajascript.DarkPlanner.EtatNoeud;
import nk.enonces.jajascript.DarkPlanner.Noeud;
import nk.enonces.jajascript.DarkPlanner.Vertice;

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

		Assert.assertEquals(12, p.getGain().intValue());
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

	@Test
	public void testClean6() {
		DarkPlanner dp = new DarkPlanner();
		final List<Trajet> trajets = charge(dp, "rl2_0.txt");
		Assert.assertEquals(5, trajets.size());

		final List<Trajet> filtre = dp.filtre(trajets);

		Assert.assertEquals(5, filtre.size());

		final Planning p = dp.resoud(filtre);

		Assert.assertEquals(28, p.getGain().intValue());
		Assert.assertEquals(2, p.getPath().size());
		Assert.assertEquals("uninterested-theoretician-65", p.getPath().get(0));
		Assert.assertEquals("black-refrigerator-82", p.getPath().get(1));
	}

	@Test
	public void testClean7() {
		DarkPlanner dp = new DarkPlanner();
		final List<Trajet> trajets = charge(dp, "rl2_1.txt");
		Assert.assertEquals(10, trajets.size());

		final List<Trajet> filtre = dp.filtre(trajets);

		Assert.assertEquals(String.valueOf(filtre), 8, filtre.size());

		final Planning p = dp.resoud(filtre);

		Assert.assertEquals(66, p.getGain().intValue());
		Assert.assertEquals("Obtenu : " + p.getPath() , 3, p.getPath().size());
		Assert.assertEquals("smiling-antenna-49", p.getPath().get(0));
		Assert.assertEquals("skinny-trader-10", p.getPath().get(1));
		Assert.assertEquals("quaint-bagpipe-71", p.getPath().get(2));
	}

	@Test
	public void produitDot() {
		DarkPlanner dp = new DarkPlanner();
		final List<Trajet> trajets = charge(dp, "payload2.txt");
		final List<Trajet> filtre = dp.filtre(trajets);

		// Assert.assertEquals(filtre.size() + " != " + 8 + "; " + String.valueOf(filtre), 55, filtre.size());
		System.out.println("digraph total { outputorder=out; compound=true; \n");
		final Map<Noeud, EtatNoeud> backlinks = new HashMap<Noeud, EtatNoeud>();

		// d'abord il nous faut un graphe
		final SortedMap<Noeud, EtatNoeud> graphe = dp.creeGrapheInitial(filtre, backlinks);
		dotSubgraph(graphe, "Etape0");
		// suppression des noeuds inutiles "avant"
		dp.grapheEnleveInutilesAvant(graphe, backlinks);
		dotSubgraph(graphe, "Etape1");
		// suppression des noeuds inutiles "arrière"
		dp.grapheEnleveInutilesArriere(graphe, backlinks);
		dotSubgraph(graphe, "Etape2");
		// suppression des liens "évidemment" inutiles
		dp.grapheEnleveVerticesDoubless(graphe.keySet());
		dotSubgraph(graphe, "Etape3");
		// ensuite on s'assure qu'il y a un chemin partout
		dp.grapheComplete(graphe);
		
		dotSubgraph(graphe, "Etape4");
		System.out.println("}");
	}

	protected void dotSubgraph(final SortedMap<Noeud, EtatNoeud> graphe, String nom) {
		System.out.println("subgraph cluster" + nom + "{ label=\"" + nom + "\"");
		for (Noeud n : graphe.keySet()) {
			System.out.println("n" + nom + n.id + " [label=n" + n.id + "];\n");
			for (Vertice v : n.etat.vertices) {
				System.out
						.println("n" + nom + n.id + " -> n" + nom + v.fin.id + "[label=\"" + v.vol + "; " + v.poids + "\"];");
			}
		}
		System.out.println("}");
	}

	@Test
	public void testeTout() {
		final String dirName = this.getClass().getResource(".").toExternalForm().substring("file:".length());
		final File dir = new File(dirName);
		final DarkPlanner dp = new DarkPlanner();
		for (String s : dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.startsWith("rl") && name.endsWith(".txt");
			}
		})) {
			System.out.format("%5s;", s);
			long start = System.currentTimeMillis();
			final List<Trajet> trajets = charge(dp, s);
			long end = System.currentTimeMillis();
			System.out.format("%dms;%d;", end - start, trajets.size());
			start = end;
			final List<Trajet> filtre = dp.filtre(trajets);
			end = System.currentTimeMillis();
			System.out.format("%dms;%d;", end - start, filtre.size());
			start = end;
			final Planning p = dp.resoud(filtre);
			end = System.currentTimeMillis();
			System.out.format("%dms;%d;%d;", end - start, p.getPath().size(), p.getGain());

			start = end;
			final SortedMap<Noeud, EtatNoeud> graphe = dp.prepareGraphe(filtre);

			Planning gainMax = dp.brutalMassif(graphe, graphe.firstKey());
			end = System.currentTimeMillis();
			System.out.format("%dms;%d\n", end - start, gainMax.getGain());
			/*
			 * if(gainMax.compareTo(p.getGain()) > 0) { Assert.fail("Gain trop faible : " + p.getGain() +
			 * " au lieu de " + gainMax); }
			 */
		}
	}

	public List<Trajet> charge(DarkPlanner dp, final String fichier) {
		final String jsonText = IO.readText(this.getClass().getResourceAsStream(fichier));
		return dp.chargeTexteJSON(jsonText);
	}

}
