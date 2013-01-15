tree grammar ArithmetiqueCalc;

options {
    tokenVocab=Arithmetique;
    ASTLabelType=CommonTree;
}

@header { package nk.questions.antlr; }

prog returns [double value]: expr { $value = $expr.value; }
	;

expr returns [double value]
    :   ^('+' a=expr b=expr)       { $value = $a.value + $b.value; }
    |   ^('-' a=expr b=expr)       { $value = $a.value - $b.value; }
    |   ^('*' a=expr b=expr)       { $value = $a.value * $b.value; }
    |   ^('/' a=expr b=expr)       { $value = $a.value / $b.value; }
    |   INT                        { $value = java.lang.Double.parseDouble($INT.text); }
    |   FLOAT                      { $value = java.lang.Double.parseDouble($FLOAT.text); }
    ;