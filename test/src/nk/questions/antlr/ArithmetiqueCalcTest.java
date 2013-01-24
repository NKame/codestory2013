package nk.questions.antlr;

import java.io.IOException;
import java.math.BigDecimal;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.junit.Assert;
import org.junit.Test;

public class ArithmetiqueCalcTest {

	@Test
	public void test() throws IOException, RecognitionException {
		evalue("1", new BigDecimal(1));
		evalue("(1)", new BigDecimal(1));
		evalue("-1", new BigDecimal(-1));
		evalue("(-1)", new BigDecimal(-1));
		evalue("(1+2)*2", new BigDecimal(6.));
		evalue("(1+4)/2", new BigDecimal(2.5));
		evalue("((1.1+2)+3.14+4+(5+6+7)+(8+9+10)*4267387833344334647677634)/2*553344300034334349999000",
				new BigDecimal("31878018903828899277492024491376690701584023926880"));
		evalue("1-1", BigDecimal.ZERO);
		evalue("1.0000000000000000000000000000000000000000000000001*1.0000000000000000000000000000000000000000000000001",
				new BigDecimal(
						"1.00000000000000000000000000000000000000000000000020000000000000000000000000000000000000000000000001"));
	}

	private void evalue(final String expr, final BigDecimal attendu) throws RecognitionException {
		ANTLRStringStream input = new ANTLRStringStream(expr);
		ArithmetiqueLexer lexer = new ArithmetiqueLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ArithmetiqueParser parser = new ArithmetiqueParser(tokens);
		CommonTree t = (CommonTree) parser.prog().getTree();

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		ArithmetiqueCalc evaluator = new ArithmetiqueCalc(nodes);

		try {
			final BigDecimal obtenu = evaluator.prog();
			Assert.assertNotNull("Pas de résultat pour " + expr + " // " + tokens, obtenu);
			Assert.assertTrue(obtenu + " au lieu de " + attendu + " attendu pour " + tokens,
					attendu.compareTo(obtenu) == 0);
		} catch (Exception e) {
			throw new RuntimeException("oups sur " + expr + " // " + tokens, e);
		}
	}
}