grammar MxStar;

// Parser

program : define*;
define
    : class_def
    | func_def
    | global_var_def_stmt
    ;
class_def : CLASS IDENTIFIER '{'  (var_def_stmt | func_def)*
            constructor_def? (var_def_stmt | func_def)*'}' ';';
constructor_def : IDENTIFIER '(' ')' suite;
var_def_stmt : var_def ';';
var_def : type var_def_arg (',' var_def_arg)*;
var_def_arg : IDENTIFIER ('=' expr)?;
func_def : func_type IDENTIFIER parameter_list suite;
basic_type : BOOL | INT | STRING;
type : (IDENTIFIER | basic_type) ('[' ']')*;
func_type : type | VOID;
parameter_list : '(' (parameter (',' parameter)*)? ')';
parameter : type IDENTIFIER;
global_var_def_stmt : var_def ';';
suite : '{' block* '}';
stmt
    : var_def_stmt
    | expr_stmt
    | if_stmt
    | loop_stmt
    | flow_stmt
    ;
block : suite | stmt | ';';
if_stmt : IF '(' expr ')' block else_stmt?;
else_stmt : ELSE block;
loop_stmt
    : while_stmt
    | for_stmt
    ;
while_stmt : WHILE '(' expr ')' block;
for_stmt : FOR '(' for_init? ';' for_stop? ';' expr? ')' block;
for_init : var_def | expr;
for_stop : expr;
flow_stmt
    : return_stmt
    | break_stmt
    | continue_stmt
    ;
return_stmt : RETURN expr? ';';
break_stmt : BREAK ';';
continue_stmt : CONITNUE ';';
expr_stmt : expr ';';
expr
    : expr '.' expr                                     #binaryExpr
    | expr arg_list                                     #funcCallExpr
    | lambda_stmt                                       #lambdaExpr
    | expr '[' expr ']'                                 #arrayExpr
    | <assoc=right> (PLUS_PLUS | MINUS_MINUS) expr      #preIncDecExpr
    | expr (PLUS_PLUS | MINUS_MINUS)                    #postIncDecExpr
    | <assoc=right> (PLUS | MINUS) expr                 #unaryExpr
    | <assoc=right> (NOT_LOG | NOT_OP) expr             #unaryExpr
    | <assoc=right> NEW creator                         #newExpr
    | expr (STAR | DIV | MOD) expr                      #binaryExpr
    | expr (PLUS | MINUS) expr                          #binaryExpr
    | expr (LEFT_SHIFT | RIGHT_SHIFT) expr              #binaryExpr
    | expr (LESS_THAN | GREATER_THAN) expr              #binaryExpr
    | expr (LT_EQ | GT_EQ) expr                         #binaryExpr
    | expr (EQUALS | NOT_EQ) expr                       #binaryExpr
    | expr AND_OP expr                                  #binaryExpr
    | expr XOR_OP expr                                  #binaryExpr
    | expr OR_OP expr                                   #binaryExpr
    | expr AND_LOG expr                                 #binaryExpr
    | expr OR_LOG expr                                  #binaryExpr
    | <assoc=right> expr ASSIGN expr                    #binaryExpr
    | '(' expr ')'                                      #bracketExpr
    | primary                                           #primayExpr
    ;
primary
    : THIS
    | NULL
    | INT_LITERAL
    | BOOL_LITERAL
    | STRING_LITERAL
    | IDENTIFIER
    ;
arg_list : '(' (expr (',' expr)*)? ')';
creator : (IDENTIFIER | basic_type) ('(' ')' | creator_size*);
creator_size : '[' expr? ']';
lambda_stmt : LAMBDA_HEAD parameter_list? ARROW suite arg_list;

// Lexer

PLUS : '+';
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
fragment ESCAPE_CHAR : ["nr\\];
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
    : '"' (SPACE | '\\' ESCAPE_CHAR | PRINTABLE_CHAR)*? '"'
    ;

IDENTIFIER : LETTER_ (LETTER_ | DIGIT)*;
NEWLINE : '\r'?'\n' -> skip;
BlockComment : '/*' .*? '*/' -> skip;
LINE_COMMENT : '//'~ [\r\n]* -> skip;
WS : [ \t]+ -> skip;
