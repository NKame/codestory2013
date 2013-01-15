// $ANTLR 3.5 src/Arithmetique.g 2013-01-15 02:51:41
 package nk.questions.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ArithmetiqueLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int FLOAT=4;
	public static final int ID=5;
	public static final int INT=6;
	public static final int NEWLINE=7;
	public static final int WS=8;

	        public void emitErrorMessage(String msg) {
	        	System.out.println(msg);
	        }


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ArithmetiqueLexer() {} 
	public ArithmetiqueLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ArithmetiqueLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "src/Arithmetique.g"; }

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:14:6: ( '(' )
			// src/Arithmetique.g:14:8: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:15:7: ( ')' )
			// src/Arithmetique.g:15:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:16:7: ( '*' )
			// src/Arithmetique.g:16:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:17:7: ( '+' )
			// src/Arithmetique.g:17:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:18:7: ( '-' )
			// src/Arithmetique.g:18:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:19:7: ( '/' )
			// src/Arithmetique.g:19:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:34:5: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
			// src/Arithmetique.g:34:9: ( 'a' .. 'z' | 'A' .. 'Z' )+
			{
			// src/Arithmetique.g:34:9: ( 'a' .. 'z' | 'A' .. 'Z' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/Arithmetique.g:
					{
					if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:37:5: ( ( '-' )? ( '0' .. '9' )+ )
			// src/Arithmetique.g:37:9: ( '-' )? ( '0' .. '9' )+
			{
			// src/Arithmetique.g:37:9: ( '-' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='-') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// src/Arithmetique.g:37:9: '-'
					{
					match('-'); 
					}
					break;

			}

			// src/Arithmetique.g:37:13: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// src/Arithmetique.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:40:7: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* )
			// src/Arithmetique.g:40:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )*
			{
			// src/Arithmetique.g:40:9: ( '0' .. '9' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// src/Arithmetique.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			match('.'); 
			// src/Arithmetique.g:40:25: ( '0' .. '9' )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// src/Arithmetique.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop5;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:44:5: ( ( '\\r' )? '\\n' )
			// src/Arithmetique.g:44:7: ( '\\r' )? '\\n'
			{
			// src/Arithmetique.g:44:7: ( '\\r' )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='\r') ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// src/Arithmetique.g:44:7: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:47:5: ( ( ' ' | '\\t' )+ )
			// src/Arithmetique.g:47:9: ( ' ' | '\\t' )+
			{
			// src/Arithmetique.g:47:9: ( ' ' | '\\t' )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0=='\t'||LA7_0==' ') ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// src/Arithmetique.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			 skip(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// src/Arithmetique.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | ID | INT | FLOAT | NEWLINE | WS )
		int alt8=11;
		alt8 = dfa8.predict(input);
		switch (alt8) {
			case 1 :
				// src/Arithmetique.g:1:10: T__9
				{
				mT__9(); 

				}
				break;
			case 2 :
				// src/Arithmetique.g:1:15: T__10
				{
				mT__10(); 

				}
				break;
			case 3 :
				// src/Arithmetique.g:1:21: T__11
				{
				mT__11(); 

				}
				break;
			case 4 :
				// src/Arithmetique.g:1:27: T__12
				{
				mT__12(); 

				}
				break;
			case 5 :
				// src/Arithmetique.g:1:33: T__13
				{
				mT__13(); 

				}
				break;
			case 6 :
				// src/Arithmetique.g:1:39: T__14
				{
				mT__14(); 

				}
				break;
			case 7 :
				// src/Arithmetique.g:1:45: ID
				{
				mID(); 

				}
				break;
			case 8 :
				// src/Arithmetique.g:1:48: INT
				{
				mINT(); 

				}
				break;
			case 9 :
				// src/Arithmetique.g:1:52: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 10 :
				// src/Arithmetique.g:1:58: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 11 :
				// src/Arithmetique.g:1:66: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA8 dfa8 = new DFA8(this);
	static final String DFA8_eotS =
		"\5\uffff\1\13\2\uffff\1\14\5\uffff";
	static final String DFA8_eofS =
		"\16\uffff";
	static final String DFA8_minS =
		"\1\11\4\uffff\1\60\2\uffff\1\56\5\uffff";
	static final String DFA8_maxS =
		"\1\172\4\uffff\1\71\2\uffff\1\71\5\uffff";
	static final String DFA8_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\1\7\1\uffff\1\12\1\13\1\5\1\10\1"+
		"\11";
	static final String DFA8_specialS =
		"\16\uffff}>";
	static final String[] DFA8_transitionS = {
			"\1\12\1\11\2\uffff\1\11\22\uffff\1\12\7\uffff\1\1\1\2\1\3\1\4\1\uffff"+
			"\1\5\1\uffff\1\6\12\10\7\uffff\32\7\6\uffff\32\7",
			"",
			"",
			"",
			"",
			"\12\14",
			"",
			"",
			"\1\15\1\uffff\12\10",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
	static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
	static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
	static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
	static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
	static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
	static final short[][] DFA8_transition;

	static {
		int numStates = DFA8_transitionS.length;
		DFA8_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
		}
	}

	protected class DFA8 extends DFA {

		public DFA8(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 8;
			this.eot = DFA8_eot;
			this.eof = DFA8_eof;
			this.min = DFA8_min;
			this.max = DFA8_max;
			this.accept = DFA8_accept;
			this.special = DFA8_special;
			this.transition = DFA8_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | ID | INT | FLOAT | NEWLINE | WS );";
		}
	}

}
