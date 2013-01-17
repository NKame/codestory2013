// $ANTLR 3.5 src/Arithmetique.g 2013-01-17 23:47:03
 package nk.questions.antlr; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ArithmetiqueLexer extends Lexer {
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

	// $ANTLR start "T__8"
	public final void mT__8() throws RecognitionException {
		try {
			int _type = T__8;
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
	// $ANTLR end "T__8"

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:15:6: ( ')' )
			// src/Arithmetique.g:15:8: ')'
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
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
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
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
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
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
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
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
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
	// $ANTLR end "T__13"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:39:8: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )? )
			// src/Arithmetique.g:39:10: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )?
			{
			// src/Arithmetique.g:39:10: ( '0' .. '9' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
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
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			// src/Arithmetique.g:39:22: ( '.' ( '0' .. '9' )* )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='.') ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// src/Arithmetique.g:39:23: '.' ( '0' .. '9' )*
					{
					match('.'); 
					// src/Arithmetique.g:39:27: ( '0' .. '9' )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
							alt2=1;
						}

						switch (alt2) {
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
							break loop2;
						}
					}

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "NEGATE"
	public final void mNEGATE() throws RecognitionException {
		try {
			int _type = NEGATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:42:8: ( '¤' )
			// src/Arithmetique.g:42:10: '¤'
			{
			match('\u00A4'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEGATE"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Arithmetique.g:46:5: ( ( '\\r' )? '\\n' )
			// src/Arithmetique.g:46:7: ( '\\r' )? '\\n'
			{
			// src/Arithmetique.g:46:7: ( '\\r' )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\r') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// src/Arithmetique.g:46:7: '\\r'
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
			// src/Arithmetique.g:49:5: ( ( ' ' | '\\t' )+ )
			// src/Arithmetique.g:49:9: ( ' ' | '\\t' )+
			{
			// src/Arithmetique.g:49:9: ( ' ' | '\\t' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='\t'||LA5_0==' ') ) {
					alt5=1;
				}

				switch (alt5) {
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
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
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
		// src/Arithmetique.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | NUMBER | NEGATE | NEWLINE | WS )
		int alt6=10;
		switch ( input.LA(1) ) {
		case '(':
			{
			alt6=1;
			}
			break;
		case ')':
			{
			alt6=2;
			}
			break;
		case '*':
			{
			alt6=3;
			}
			break;
		case '+':
			{
			alt6=4;
			}
			break;
		case '-':
			{
			alt6=5;
			}
			break;
		case '/':
			{
			alt6=6;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt6=7;
			}
			break;
		case '\u00A4':
			{
			alt6=8;
			}
			break;
		case '\n':
		case '\r':
			{
			alt6=9;
			}
			break;
		case '\t':
		case ' ':
			{
			alt6=10;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 6, 0, input);
			throw nvae;
		}
		switch (alt6) {
			case 1 :
				// src/Arithmetique.g:1:10: T__8
				{
				mT__8(); 

				}
				break;
			case 2 :
				// src/Arithmetique.g:1:15: T__9
				{
				mT__9(); 

				}
				break;
			case 3 :
				// src/Arithmetique.g:1:20: T__10
				{
				mT__10(); 

				}
				break;
			case 4 :
				// src/Arithmetique.g:1:26: T__11
				{
				mT__11(); 

				}
				break;
			case 5 :
				// src/Arithmetique.g:1:32: T__12
				{
				mT__12(); 

				}
				break;
			case 6 :
				// src/Arithmetique.g:1:38: T__13
				{
				mT__13(); 

				}
				break;
			case 7 :
				// src/Arithmetique.g:1:44: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 8 :
				// src/Arithmetique.g:1:51: NEGATE
				{
				mNEGATE(); 

				}
				break;
			case 9 :
				// src/Arithmetique.g:1:58: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 10 :
				// src/Arithmetique.g:1:66: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
