// $ANTLR 3.5 src/Arithmetique.g 2013-01-17 23:47:02
 package nk.questions.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class ArithmetiqueParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEGATE", "NEWLINE", "NUMBER", 
		"WS", "'('", "')'", "'*'", "'+'", "'-'", "'/'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int NEGATE=4;
	public static final int NEWLINE=5;
	public static final int NUMBER=6;
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
			// src/Arithmetique.g:18:2: ( expr )
			// src/Arithmetique.g:18:4: expr
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_expr_in_prog51);
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
	// src/Arithmetique.g:21:1: expr : multExpr ( ( '+' | '-' ) ^ multExpr )* ;
	public final ArithmetiqueParser.expr_return expr() throws RecognitionException {
		ArithmetiqueParser.expr_return retval = new ArithmetiqueParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set3=null;
		ParserRuleReturnScope multExpr2 =null;
		ParserRuleReturnScope multExpr4 =null;

		Object set3_tree=null;

		try {
			// src/Arithmetique.g:21:5: ( multExpr ( ( '+' | '-' ) ^ multExpr )* )
			// src/Arithmetique.g:21:9: multExpr ( ( '+' | '-' ) ^ multExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_multExpr_in_expr62);
			multExpr2=multExpr();
			state._fsp--;

			adaptor.addChild(root_0, multExpr2.getTree());

			// src/Arithmetique.g:21:18: ( ( '+' | '-' ) ^ multExpr )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= 11 && LA1_0 <= 12)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/Arithmetique.g:21:19: ( '+' | '-' ) ^ multExpr
					{
					set3=input.LT(1);
					set3=input.LT(1);
					if ( (input.LA(1) >= 11 && input.LA(1) <= 12) ) {
						input.consume();
						root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set3), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multExpr_in_expr72);
					multExpr4=multExpr();
					state._fsp--;

					adaptor.addChild(root_0, multExpr4.getTree());

					}
					break;

				default :
					break loop1;
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
	// src/Arithmetique.g:24:1: multExpr : unary ( ( '*' | '/' ) ^ unary )* ;
	public final ArithmetiqueParser.multExpr_return multExpr() throws RecognitionException {
		ArithmetiqueParser.multExpr_return retval = new ArithmetiqueParser.multExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set6=null;
		ParserRuleReturnScope unary5 =null;
		ParserRuleReturnScope unary7 =null;

		Object set6_tree=null;

		try {
			// src/Arithmetique.g:25:5: ( unary ( ( '*' | '/' ) ^ unary )* )
			// src/Arithmetique.g:25:9: unary ( ( '*' | '/' ) ^ unary )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_unary_in_multExpr93);
			unary5=unary();
			state._fsp--;

			adaptor.addChild(root_0, unary5.getTree());

			// src/Arithmetique.g:25:15: ( ( '*' | '/' ) ^ unary )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==10||LA2_0==13) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// src/Arithmetique.g:25:16: ( '*' | '/' ) ^ unary
					{
					set6=input.LT(1);
					set6=input.LT(1);
					if ( input.LA(1)==10||input.LA(1)==13 ) {
						input.consume();
						root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set6), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unary_in_multExpr103);
					unary7=unary();
					state._fsp--;

					adaptor.addChild(root_0, unary7.getTree());

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
	// $ANTLR end "multExpr"


	public static class unary_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "unary"
	// src/Arithmetique.g:28:1: unary : ( '+' atom -> atom | '-' atom -> ^( NEGATE atom ) | atom );
	public final ArithmetiqueParser.unary_return unary() throws RecognitionException {
		ArithmetiqueParser.unary_return retval = new ArithmetiqueParser.unary_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal8=null;
		Token char_literal10=null;
		ParserRuleReturnScope atom9 =null;
		ParserRuleReturnScope atom11 =null;
		ParserRuleReturnScope atom12 =null;

		Object char_literal8_tree=null;
		Object char_literal10_tree=null;
		RewriteRuleTokenStream stream_11=new RewriteRuleTokenStream(adaptor,"token 11");
		RewriteRuleTokenStream stream_12=new RewriteRuleTokenStream(adaptor,"token 12");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");

		try {
			// src/Arithmetique.g:29:2: ( '+' atom -> atom | '-' atom -> ^( NEGATE atom ) | atom )
			int alt3=3;
			switch ( input.LA(1) ) {
			case 11:
				{
				alt3=1;
				}
				break;
			case 12:
				{
				alt3=2;
				}
				break;
			case NUMBER:
			case 8:
				{
				alt3=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// src/Arithmetique.g:29:4: '+' atom
					{
					char_literal8=(Token)match(input,11,FOLLOW_11_in_unary119);  
					stream_11.add(char_literal8);

					pushFollow(FOLLOW_atom_in_unary121);
					atom9=atom();
					state._fsp--;

					stream_atom.add(atom9.getTree());
					// AST REWRITE
					// elements: atom
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 29:13: -> atom
					{
						adaptor.addChild(root_0, stream_atom.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// src/Arithmetique.g:30:4: '-' atom
					{
					char_literal10=(Token)match(input,12,FOLLOW_12_in_unary130);  
					stream_12.add(char_literal10);

					pushFollow(FOLLOW_atom_in_unary132);
					atom11=atom();
					state._fsp--;

					stream_atom.add(atom11.getTree());
					// AST REWRITE
					// elements: atom
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 30:13: -> ^( NEGATE atom )
					{
						// src/Arithmetique.g:30:16: ^( NEGATE atom )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NEGATE, "NEGATE"), root_1);
						adaptor.addChild(root_1, stream_atom.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// src/Arithmetique.g:31:4: atom
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atom_in_unary145);
					atom12=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom12.getTree());

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
	// $ANTLR end "unary"


	public static class atom_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// src/Arithmetique.g:34:1: atom : ( NUMBER | '(' expr ')' -> expr );
	public final ArithmetiqueParser.atom_return atom() throws RecognitionException {
		ArithmetiqueParser.atom_return retval = new ArithmetiqueParser.atom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token NUMBER13=null;
		Token char_literal14=null;
		Token char_literal16=null;
		ParserRuleReturnScope expr15 =null;

		Object NUMBER13_tree=null;
		Object char_literal14_tree=null;
		Object char_literal16_tree=null;
		RewriteRuleTokenStream stream_9=new RewriteRuleTokenStream(adaptor,"token 9");
		RewriteRuleTokenStream stream_8=new RewriteRuleTokenStream(adaptor,"token 8");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// src/Arithmetique.g:35:2: ( NUMBER | '(' expr ')' -> expr )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==NUMBER) ) {
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
					// src/Arithmetique.g:35:6: NUMBER
					{
					root_0 = (Object)adaptor.nil();


					NUMBER13=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_atom159); 
					NUMBER13_tree = (Object)adaptor.create(NUMBER13);
					adaptor.addChild(root_0, NUMBER13_tree);

					}
					break;
				case 2 :
					// src/Arithmetique.g:36:9: '(' expr ')'
					{
					char_literal14=(Token)match(input,8,FOLLOW_8_in_atom169);  
					stream_8.add(char_literal14);

					pushFollow(FOLLOW_expr_in_atom171);
					expr15=expr();
					state._fsp--;

					stream_expr.add(expr15.getTree());
					char_literal16=(Token)match(input,9,FOLLOW_9_in_atom173);  
					stream_9.add(char_literal16);

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
					// 36:25: -> expr
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



	public static final BitSet FOLLOW_expr_in_prog51 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr62 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_set_in_expr65 = new BitSet(new long[]{0x0000000000001940L});
	public static final BitSet FOLLOW_multExpr_in_expr72 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_unary_in_multExpr93 = new BitSet(new long[]{0x0000000000002402L});
	public static final BitSet FOLLOW_set_in_multExpr96 = new BitSet(new long[]{0x0000000000001940L});
	public static final BitSet FOLLOW_unary_in_multExpr103 = new BitSet(new long[]{0x0000000000002402L});
	public static final BitSet FOLLOW_11_in_unary119 = new BitSet(new long[]{0x0000000000000140L});
	public static final BitSet FOLLOW_atom_in_unary121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_unary130 = new BitSet(new long[]{0x0000000000000140L});
	public static final BitSet FOLLOW_atom_in_unary132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unary145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_atom159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_atom169 = new BitSet(new long[]{0x0000000000001940L});
	public static final BitSet FOLLOW_expr_in_atom171 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_atom173 = new BitSet(new long[]{0x0000000000000002L});
}
