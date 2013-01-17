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

prog
	:	expr
	;

expr:   multExpr (('+'|'-')^ multExpr)*
    ;

multExpr
    :   unary (('*'|'/')^ unary)*
    ;

unary
	: '+' atom -> atom
	| '-' atom -> ^(NEGATE atom)
	| atom
	;	

atom
	:   NUMBER
    |   '(' expr ')'    -> expr    
    ;
    
NUMBER : ('0'..'9')+ ('.' ('0'..'9')*)?
	;

NEGATE	:	'¤'
	;

NEWLINE
    :	'\r'? '\n'
    ;

WS  :   (' '|'\t')+ { skip(); }
	;