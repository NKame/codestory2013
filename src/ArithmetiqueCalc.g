tree grammar ArithmetiqueCalc;

options {
    tokenVocab=Arithmetique;
    ASTLabelType=CommonTree;
}

@header { 
	package nk.questions.antlr;
	import java.math.BigDecimal; 
}

prog returns [BigDecimal value]
	: expr { $value = $expr.value; }
	;

expr returns [BigDecimal value]
    :   ^('+' a=expr b=expr)	{ $value = $a.value.add($b.value); }
    |   ^('-' a=expr b=expr)    { $value = $a.value.subtract($b.value); }
    |	^(NEGATE a=expr)    	{ $value = $a.value.negate(); }    
    |   ^('*' a=expr b=expr)    { $value = $a.value.multiply($b.value); }
    |   ^('/' a=expr b=expr)    { $value = $a.value.divide($b.value); }
    |   NUMBER			{ $value = new BigDecimal($NUMBER.text); }
    ;
