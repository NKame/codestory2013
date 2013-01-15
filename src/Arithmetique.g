grammar Arithmetique;

options {
	language=Java;
	output=AST;
}

@lexer::header { package nk.questions.antlr; }
@header { package nk.questions.antlr; }

@lexer::members {
        public void emitErrorMessage(String msg) {
        	System.out.println(msg);
        }
}

prog: expr
	;

expr:   multExpr (('+'^|'-'^) multExpr)*
    ;

multExpr
    :   atom (('*'|'/')^ atom)*
    ;

atom:   INT
	| FLOAT
    |   '(' expr ')'    -> expr    
    ;
// END:expr

// START:tokens
ID  :   ('a'..'z'|'A'..'Z')+
	;

INT :   '-'?'0'..'9'+
    ;
    
FLOAT : ('0'..'9')+ '.' ('0'..'9')*
	;

NEWLINE
    :	'\r'? '\n'
    ;

WS  :   (' '|'\t')+ { skip(); }
	;



