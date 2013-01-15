package nk.questions.antlr;

import java.io.IOException;

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
		evalue("(1+2)*2", 6.);
		evalue("(1+4)/2", 2.5);
	}

	private void evalue(final String expr, final double attendu) throws RecognitionException {
		ANTLRStringStream input = new ANTLRStringStream(expr);
		ArithmetiqueLexer lexer = new ArithmetiqueLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ArithmetiqueParser parser = new ArithmetiqueParser(tokens);
		CommonTree t = (CommonTree) parser.prog().getTree();

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		ArithmetiqueCalc evaluator = new ArithmetiqueCalc(nodes);
		
		Assert.assertEquals(attendu, evaluator.prog(), 0.00000000000000000000000000001);
	}
}
