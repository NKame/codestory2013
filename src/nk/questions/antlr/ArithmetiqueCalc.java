// $ANTLR 3.5 src/ArithmetiqueCalc.g 2013-01-17 23:43:24
 
	package nk.questions.antlr;
	import java.math.BigDecimal; 


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ArithmetiqueCalc extends TreeParser {
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
	// src/ArithmetiqueCalc.g:13:1: prog returns [BigDecimal value] : expr ;
	public final BigDecimal prog() throws RecognitionException {
		BigDecimal value = null;


		BigDecimal expr1 =null;

		try {
			// src/ArithmetiqueCalc.g:14:2: ( expr )
			// src/ArithmetiqueCalc.g:14:4: expr
			{
			pushFollow(FOLLOW_expr_in_prog46);
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
	// src/ArithmetiqueCalc.g:17:1: expr returns [BigDecimal value] : ( ^( '+' a= expr b= expr ) | ^( '-' a= expr b= expr ) | ^( NEGATE a= expr ) | ^( '*' a= expr b= expr ) | ^( '/' a= expr b= expr ) | NUMBER );
	public final BigDecimal expr() throws RecognitionException {
		BigDecimal value = null;


		CommonTree NUMBER2=null;
		BigDecimal a =null;
		BigDecimal b =null;

		try {
			// src/ArithmetiqueCalc.g:18:5: ( ^( '+' a= expr b= expr ) | ^( '-' a= expr b= expr ) | ^( NEGATE a= expr ) | ^( '*' a= expr b= expr ) | ^( '/' a= expr b= expr ) | NUMBER )
			int alt1=6;
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
			case NEGATE:
				{
				alt1=3;
				}
				break;
			case 10:
				{
				alt1=4;
				}
				break;
			case 13:
				{
				alt1=5;
				}
				break;
			case NUMBER:
				{
				alt1=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// src/ArithmetiqueCalc.g:18:9: ^( '+' a= expr b= expr )
					{
					match(input,11,FOLLOW_11_in_expr69); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr73);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr77);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 value = a.add(b); 
					}
					break;
				case 2 :
					// src/ArithmetiqueCalc.g:19:9: ^( '-' a= expr b= expr )
					{
					match(input,12,FOLLOW_12_in_expr91); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr95);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr99);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 value = a.subtract(b); 
					}
					break;
				case 3 :
					// src/ArithmetiqueCalc.g:20:7: ^( NEGATE a= expr )
					{
					match(input,NEGATE,FOLLOW_NEGATE_in_expr114); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr118);
					a=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 value = a.negate(); 
					}
					break;
				case 4 :
					// src/ArithmetiqueCalc.g:21:9: ^( '*' a= expr b= expr )
					{
					match(input,10,FOLLOW_10_in_expr140); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr144);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr148);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 value = a.multiply(b); 
					}
					break;
				case 5 :
					// src/ArithmetiqueCalc.g:22:9: ^( '/' a= expr b= expr )
					{
					match(input,13,FOLLOW_13_in_expr165); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr169);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr173);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 value = a.divide(b); 
					}
					break;
				case 6 :
					// src/ArithmetiqueCalc.g:23:9: NUMBER
					{
					NUMBER2=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_expr189); 
					 value = new BigDecimal((NUMBER2!=null?NUMBER2.getText():null)); 
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



	public static final BitSet FOLLOW_expr_in_prog46 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_expr69 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr73 = new BitSet(new long[]{0x0000000000003C50L});
	public static final BitSet FOLLOW_expr_in_expr77 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_12_in_expr91 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr95 = new BitSet(new long[]{0x0000000000003C50L});
	public static final BitSet FOLLOW_expr_in_expr99 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEGATE_in_expr114 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr118 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_10_in_expr140 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr144 = new BitSet(new long[]{0x0000000000003C50L});
	public static final BitSet FOLLOW_expr_in_expr148 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_13_in_expr165 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr169 = new BitSet(new long[]{0x0000000000003C50L});
	public static final BitSet FOLLOW_expr_in_expr173 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NUMBER_in_expr189 = new BitSet(new long[]{0x0000000000000002L});
}
