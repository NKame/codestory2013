// $ANTLR 3.5 src/ArithmetiqueCalc.g 2013-01-15 02:06:32
 package nk.questions.antlr; 

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ArithmetiqueCalc extends TreeParser {
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
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public ArithmetiqueCalc(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public ArithmetiqueCalc(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ArithmetiqueCalc.tokenNames; }
	@Override public String getGrammarFileName() { return "src/ArithmetiqueCalc.g"; }



	// $ANTLR start "prog"
	// src/ArithmetiqueCalc.g:10:1: prog returns [double value] : expr ;
	public final double prog() throws RecognitionException {
		double value = 0.0;


		double expr1 =0.0;

		try {
			// src/ArithmetiqueCalc.g:10:28: ( expr )
			// src/ArithmetiqueCalc.g:10:30: expr
			{
			pushFollow(FOLLOW_expr_in_prog44);
			expr1=expr();
			state._fsp--;

			 value = expr1; 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "prog"



	// $ANTLR start "expr"
	// src/ArithmetiqueCalc.g:13:1: expr returns [double value] : ( ^( '+' a= expr b= expr ) | ^( '-' a= expr b= expr ) | ^( '*' a= expr b= expr ) | ^( '/' a= expr b= expr ) | INT );
	public final double expr() throws RecognitionException {
		double value = 0.0;


		CommonTree INT2=null;
		double a =0.0;
		double b =0.0;

		try {
			// src/ArithmetiqueCalc.g:14:5: ( ^( '+' a= expr b= expr ) | ^( '-' a= expr b= expr ) | ^( '*' a= expr b= expr ) | ^( '/' a= expr b= expr ) | INT )
			int alt1=5;
			switch ( input.LA(1) ) {
			case 11:
				{
				alt1=1;
				}
				break;
			case 12:
				{
				alt1=2;
				}
				break;
			case 10:
				{
				alt1=3;
				}
				break;
			case 13:
				{
				alt1=4;
				}
				break;
			case INT:
				{
				alt1=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// src/ArithmetiqueCalc.g:14:9: ^( '+' a= expr b= expr )
					{
					match(input,11,FOLLOW_11_in_expr67); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr71);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr75);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 value = a + b; 
					}
					break;
				case 2 :
					// src/ArithmetiqueCalc.g:15:9: ^( '-' a= expr b= expr )
					{
					match(input,12,FOLLOW_12_in_expr95); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr99);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr103);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 value = a - b; 
					}
					break;
				case 3 :
					// src/ArithmetiqueCalc.g:16:9: ^( '*' a= expr b= expr )
					{
					match(input,10,FOLLOW_10_in_expr123); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr127);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr131);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 value = a * b; 
					}
					break;
				case 4 :
					// src/ArithmetiqueCalc.g:17:9: ^( '/' a= expr b= expr )
					{
					match(input,13,FOLLOW_13_in_expr151); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr155);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr159);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 value = a / b; 
					}
					break;
				case 5 :
					// src/ArithmetiqueCalc.g:18:9: INT
					{
					INT2=(CommonTree)match(input,INT,FOLLOW_INT_in_expr178); 
					 value = java.lang.Double.parseDouble((INT2!=null?INT2.getText():null)); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "expr"

	// Delegated rules



	public static final BitSet FOLLOW_expr_in_prog44 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_expr67 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr71 = new BitSet(new long[]{0x0000000000003C20L});
	public static final BitSet FOLLOW_expr_in_expr75 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_12_in_expr95 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr99 = new BitSet(new long[]{0x0000000000003C20L});
	public static final BitSet FOLLOW_expr_in_expr103 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_10_in_expr123 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr127 = new BitSet(new long[]{0x0000000000003C20L});
	public static final BitSet FOLLOW_expr_in_expr131 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_13_in_expr151 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr155 = new BitSet(new long[]{0x0000000000003C20L});
	public static final BitSet FOLLOW_expr_in_expr159 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INT_in_expr178 = new BitSet(new long[]{0x0000000000000002L});
}
