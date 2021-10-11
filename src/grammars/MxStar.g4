grammar MxStar;

// Parser

program : define*;
define : class_def | func_def | var_def_stmt;
class_def : CLASS IDENTIFIER '{' constructor_def? (var_def_stmt | func_def)* '}' ';';
constructor_def : IDENTIFIER '(' ')' suite;
var_def_stmt : var_def ';';
var_def : type var_def_arg (',' var_def_arg)*;
var_def_arg : IDENTIFIER ('=' expr)?;
func_def : func_type IDENTIFIER parameter_list suite;
basic_type : BOOL | INT | STRING;
type : IDENTIFIER | basic_type | type '[' ']';
func_type : type | VOID;
parameter_list : '(' (parameter (',' parameter)*)? ')';
parameter : type IDENTIFIER;
suite : '{' (stmt | suite)* '}';
stmt : var_def_stmt | expr_stmt | if_stmt | loop_stmt | flow_stmt;
if_stmt : IF '(' expr ')' (suite | stmt | ';') (ELSE (suite | stmt | ';'))?;
loop_stmt : while_stmt | for_stmt;
while_stmt : WHILE '(' expr ')' (suite | stmt | ';');
for_stmt : FOR '(' (var_def | expr)? ';' expr? ';' expr? ')' (suite | stmt | ';');
flow_stmt : (RETURN expr? | BREAK | CONITNUE) ';';
expr_stmt : expr? ';';
expr
    : expr (PLUS_PLUS | MINUS_MINUS)
    | expr arg_list
    | expr '[' expr ']'
    | expr '.' expr
    | <assoc=right> (PLUS_PLUS | MINUS_MINUS) expr
    | <assoc=right> (ADD | MINUS) expr
    | <assoc=right> (NOT_LOG | NOT_OP) expr
    | <assoc=right> NEW creator
    | expr (STAR | DIV | MOD) expr
    | expr (ADD | MINUS) expr
    | expr (LEFT_SHIFT | RIGHT_SHIFT) expr
    | expr (LESS_THAN | GREATER_THAN) expr
    | expr (LT_EQ | GT_EQ) expr
    | expr (EQUALS | NOT_EQ) expr
    | expr AND_OP expr
    | expr XOR_OP expr
    | expr OR_OP expr
    | expr AND_LOG expr
    | expr OR_LOG expr
    | <assoc=right> expr ASSIGN expr

    | THIS
    | NULL
    | INT_LITERAL
    | BOOL_LITERAL
    | STRING_LITERAL
    | lambda_stmt
    | IDENTIFIER
    | '(' expr ')'
    ;
arg_list : '(' (expr (',' expr)*)? ')';
creator : IDENTIFIER | basic_type | creator '[' expr? ']';
lambda_stmt : LAMBDA_HEAD parameter_list? ARROW suite arg_list;

// Lexer

ADD : '+';
MINUS : '-';
STAR: '*';
DIV : '/';
MOD : '%';

LESS_THAN : '<';
GREATER_THAN : '>';
EQUALS : '==';
GT_EQ : '>=';
LT_EQ : '<=';
NOT_EQ : '!=';

AND_LOG : '&&';
OR_LOG : '||';
NOT_LOG : '!';

LEFT_SHIFT : '<<';
RIGHT_SHIFT : '>>';
OR_OP : '|';
XOR_OP : '^';
AND_OP : '&';
NOT_OP : '~';

ASSIGN : '=';
PLUS_PLUS : '++';
MINUS_MINUS : '--';

DOT : '.';
COMMA : ',';
SEMI : ';';
ARROW : '->';

OPEN_PAREN : '(';
CLOSE_PAREN : ')';
OPEN_BRACK : '[';
CLOSE_BRACK : ']';
OPEN_BRACE : '{';
CLOSE_BRACE : '}';

INT : 'int';
BOOL : 'bool';
STRING : 'string';
NULL : 'null';
VOID : 'void';
fragment TRUE : 'true';
fragment FALSE : 'false';
IF : 'if';
ELSE : 'else';
FOR : 'for';
WHILE : 'while';
BREAK : 'break';
CONITNUE : 'continue';
RETURN : 'return';
NEW : 'new';
CLASS : 'class';
THIS : 'this';
LAMBDA_HEAD : '[&]';

fragment DIGIT : [0-9];
fragment NON_ZERO_DIGIT : [1-9];
fragment LETTER_ : [a-zA-Z_];
fragment SPACE : ' ';
fragment ESCAPE_CHAR : [\n\\] | '\\"';
fragment PRINTABLE_CHAR : ~[\\\r\n\f"];

BOOL_LITERAL
    : TRUE
    | FALSE
    ;

INT_LITERAL
    : NON_ZERO_DIGIT DIGIT*
    | '0'+
    ;

STRING_LITERAL
    : '"' (SPACE | ESCAPE_CHAR | PRINTABLE_CHAR)* '"'
    ;

IDENTIFIER : LETTER_ (LETTER_ | DIGIT)*;
NEWLINE : '\r'?'\n' -> skip;
BlockComment : '/*' .*? '*/' -> skip;
LINE_COMMENT : '//'~ [\r\n]* -> skip;
WS : [ \t]+ -> skip;
