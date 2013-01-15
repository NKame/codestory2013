// $ANTLR 3.5 src/Arithmetique.g 2013-01-15 00:33:42
 package nk.questions.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class ArithmetiqueParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "NEWLINE", "WS", 
		"'('", "')'", "'*'", "'+'", "'-'", "'/'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int ID=4;
	public static final int INT=5;
	public static final int NEWLINE=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ArithmetiqueParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ArithmetiqueParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return ArithmetiqueParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/Arithmetique.g"; }


	public static class prog_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "prog"
	// src/Arithmetique.g:17:1: prog : expr ;
	public final ArithmetiqueParser.prog_return prog() throws RecognitionException {
		ArithmetiqueParser.prog_return retval = new ArithmetiqueParser.prog_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope expr1 =null;


		try {
			// src/Arithmetique.g:17:5: ( expr )
			// src/Arithmetique.g:17:7: expr
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_in_prog49);
			expr1=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr1.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "prog"


	public static class expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// src/Arithmetique.g:20:1: expr : multExpr ( ( '+' ^| '-' ^) multExpr )* ;
	public final ArithmetiqueParser.expr_return expr() throws RecognitionException {
		ArithmetiqueParser.expr_return retval = new ArithmetiqueParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal3=null;
		Token char_literal4=null;
		ParserRuleReturnScope multExpr2 =null;
		ParserRuleReturnScope multExpr5 =null;

		Object char_literal3_tree=null;
		Object char_literal4_tree=null;

		try {
			// src/Arithmetique.g:20:5: ( multExpr ( ( '+' ^| '-' ^) multExpr )* )
			// src/Arithmetique.g:20:9: multExpr ( ( '+' ^| '-' ^) multExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_multExpr_in_expr60);
			multExpr2=multExpr();
			state._fsp--;

			adaptor.addChild(root_0, multExpr2.getTree());

			// src/Arithmetique.g:20:18: ( ( '+' ^| '-' ^) multExpr )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= 11 && LA2_0 <= 12)) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// src/Arithmetique.g:20:19: ( '+' ^| '-' ^) multExpr
					{
					// src/Arithmetique.g:20:19: ( '+' ^| '-' ^)
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==11) ) {
						alt1=1;
					}
					else if ( (LA1_0==12) ) {
						alt1=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 1, 0, input);
						throw nvae;
					}

					switch (alt1) {
						case 1 :
							// src/Arithmetique.g:20:20: '+' ^
							{
							char_literal3=(Token)match(input,11,FOLLOW_11_in_expr64); 
							char_literal3_tree = (Object)adaptor.create(char_literal3);
							root_0 = (Object)adaptor.becomeRoot(char_literal3_tree, root_0);

							}
							break;
						case 2 :
							// src/Arithmetique.g:20:25: '-' ^
							{
							char_literal4=(Token)match(input,12,FOLLOW_12_in_expr67); 
							char_literal4_tree = (Object)adaptor.create(char_literal4);
							root_0 = (Object)adaptor.becomeRoot(char_literal4_tree, root_0);

							}
							break;

					}

					pushFollow(FOLLOW_multExpr_in_expr71);
					multExpr5=multExpr();
					state._fsp--;

					adaptor.addChild(root_0, multExpr5.getTree());

					}
					break;

				default :
					break loop2;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class multExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "multExpr"
	// src/Arithmetique.g:23:1: multExpr : atom ( ( '*' | '/' ) ^ atom )* ;
	public final ArithmetiqueParser.multExpr_return multExpr() throws RecognitionException {
		ArithmetiqueParser.multExpr_return retval = new ArithmetiqueParser.multExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set7=null;
		ParserRuleReturnScope atom6 =null;
		ParserRuleReturnScope atom8 =null;

		Object set7_tree=null;

		try {
			// src/Arithmetique.g:24:5: ( atom ( ( '*' | '/' ) ^ atom )* )
			// src/Arithmetique.g:24:9: atom ( ( '*' | '/' ) ^ atom )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_atom_in_multExpr92);
			atom6=atom();
			state._fsp--;

			adaptor.addChild(root_0, atom6.getTree());

			// src/Arithmetique.g:24:14: ( ( '*' | '/' ) ^ atom )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==10||LA3_0==13) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// src/Arithmetique.g:24:15: ( '*' | '/' ) ^ atom
					{
					set7=input.LT(1);
					set7=input.LT(1);
					if ( input.LA(1)==10||input.LA(1)==13 ) {
						input.consume();
						root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set7), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_atom_in_multExpr102);
					atom8=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom8.getTree());

					}
					break;

				default :
					break loop3;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "multExpr"


	public static class atom_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// src/Arithmetique.g:27:1: atom : ( INT | '(' expr ')' -> expr );
	public final ArithmetiqueParser.atom_return atom() throws RecognitionException {
		ArithmetiqueParser.atom_return retval = new ArithmetiqueParser.atom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token INT9=null;
		Token char_literal10=null;
		Token char_literal12=null;
		ParserRuleReturnScope expr11 =null;

		Object INT9_tree=null;
		Object char_literal10_tree=null;
		Object char_literal12_tree=null;
		RewriteRuleTokenStream stream_9=new RewriteRuleTokenStream(adaptor,"token 9");
		RewriteRuleTokenStream stream_8=new RewriteRuleTokenStream(adaptor,"token 8");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/Arithmetique.g:27:5: ( INT | '(' expr ')' -> expr )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==INT) ) {
				alt4=1;
			}
			else if ( (LA4_0==8) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// src/Arithmetique.g:27:9: INT
					{
					root_0 = (Object)adaptor.nil();


					INT9=(Token)match(input,INT,FOLLOW_INT_in_atom118); 
					INT9_tree = (Object)adaptor.create(INT9);
					adaptor.addChild(root_0, INT9_tree);

					}
					break;
				case 2 :
					// src/Arithmetique.g:28:9: '(' expr ')'
					{
					char_literal10=(Token)match(input,8,FOLLOW_8_in_atom128);  
					stream_8.add(char_literal10);

					pushFollow(FOLLOW_expr_in_atom130);
					expr11=expr();
					state._fsp--;

					stream_expr.add(expr11.getTree());
					char_literal12=(Token)match(input,9,FOLLOW_9_in_atom132);  
					stream_9.add(char_literal12);

					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 28:25: -> expr
					{
						adaptor.addChild(root_0, stream_expr.nextTree());
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"

	// Delegated rules



	public static final BitSet FOLLOW_expr_in_prog49 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr60 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_11_in_expr64 = new BitSet(new long[]{0x0000000000000120L});
	public static final BitSet FOLLOW_12_in_expr67 = new BitSet(new long[]{0x0000000000000120L});
	public static final BitSet FOLLOW_multExpr_in_expr71 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_atom_in_multExpr92 = new BitSet(new long[]{0x0000000000002402L});
	public static final BitSet FOLLOW_set_in_multExpr95 = new BitSet(new long[]{0x0000000000000120L});
	public static final BitSet FOLLOW_atom_in_multExpr102 = new BitSet(new long[]{0x0000000000002402L});
	public static final BitSet FOLLOW_INT_in_atom118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_atom128 = new BitSet(new long[]{0x0000000000000120L});
	public static final BitSet FOLLOW_expr_in_atom130 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_atom132 = new BitSet(new long[]{0x0000000000000002L});
}
