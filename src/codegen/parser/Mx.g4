grammar Mx;

program : program_part* EOF
		;

program_part : var_def
			 | func_def
			 | class_def
			 ;

var_def : type IDENTIFIER '=' expression ';'
		| type IDENTIFIER (',' IDENTIFIER)* ';'
		;

func_def : type IDENTIFIER '(' param_list? ')' block
		 ;

param_list : type IDENTIFIER (',' type IDENTIFIER)*
		   ;

class_def : 'class' IDENTIFIER '{' class_content '}' ';'
		  ;

class_content : (class_var_def | class_func_def)*
			  ;

class_var_def : type IDENTIFIER (',' IDENTIFIER)* ';'
			  ;

class_func_def : type IDENTIFIER '(' param_list? ')' block
			   | IDENTIFIER '(' ')' block
			   ;

block : '{' statement* '}'
	  ;

statement : block                         #block_st
		  | var_def						  #var_def_st
		  | if_statement				  #if_st
		  | while_statement				  #while_st
		  | for_statement				  #for_st
		  | 'return' expression? ';'	  #return_st
		  | 'break' ';'			 		  #break_st
		  | 'continue' ';'				  #continue_st
		  | expression ';'				  #exp_st
		  | ';'		   					  #empty_st
		  ;

if_statement : 'if' '(' expression ')' strue=statement ('else' sfalse=statement)?
			 ;

while_statement : 'while' '(' expression ')' statement
				;

for_statement : 'for' '(' exp1=expression? ';' exp2=expression? ';' exp3=expression? ')' statement
			  ;

type : typename='bool'      ( lbrack='[' ']' )*
	 | typename='int'  	  	( lbrack='[' ']' )*
	 | typename='string'    ( lbrack='[' ']' )*
	 | typename='void'
	 | typename=IDENTIFIER  ( lbrack='[' ']' )*
	 ;

expression : expression op=('++' | '--')                                  #suf_exp
		   | expression '(' fun_call_list? ')'							  #fun_call_exp
		   | name=expression '[' idx=expression ']'						  #idx_exp
		   | expression '.' IDENTIFIER									  #dot_exp
		   | <assoc=right> op=('++' | '--') expression					  #unary_exp
		   | <assoc=right> op=('+' | '-') expression					  #unary_exp
		   | <assoc=right> op=('!' | '~') expression					  #unary_exp
		   | <assoc=right> 'new' new_expression							  #new_exp
		   | exp1=expression op=('*' | '/' | '%') exp2=expression		  #bin_exp
		   | exp1=expression op=('+' | '-') exp2=expression				  #bin_exp
		   | exp1=expression op=('<<' | '>>') exp2=expression			  #bin_exp
		   | exp1=expression op=('<' | '<=') exp2=expression			  #bin_exp
		   | exp1=expression op=('>' | '>=') exp2=expression			  #bin_exp
		   | exp1=expression op=('!=' | '==') exp2=expression			  #bin_exp
		   | exp1=expression op='&' exp2=expression						  #bin_exp
		   | exp1=expression op='^' exp2=expression						  #bin_exp
		   | exp1=expression op='|' exp2=expression						  #bin_exp
		   | exp1=expression op='&&' exp2=expression					  #bin_exp
		   | exp1=expression op='||' exp2=expression					  #bin_exp
		   | <assoc=right> exp1=expression op='=' exp2=expression		  #bin_exp
		   | NUMBER		   				   		  						  #number_exp
		   | STRING														  #string_exp
		   | 'null'														  #null_exp
		   | 'true'														  #true_exp
		   | 'false'													  #false_exp
		   | 'this'														  #this_exp
		   | IDENTIFIER													  #identifier_exp
		   | '(' expression ')'											  #paren_exp
		   ;

fun_call_list : expression (',' expression)*
			  ;

new_expression : not_arr_t ('[' expression ']')+ ('['']')+ ('[' expression ']')+ #error_new
			   | not_arr_t '(' ')'                    	   				   		 #paren_new
			   | not_arr_t ('[' expression ']')+ ( lbrack='[' ']' )*			 #array_new
			   | not_arr_t 	   												 	 #other_new
			   ;

not_arr_t : typename='int'
		  | typename='bool'
		  | typename='string'
		  | typename=IDENTIFIER
		  ;

IDENTIFIER : [a-zA-Z] [a-zA-Z_0-9]*
		   ;

NUMBER : [0-9]+
	   ;

STRING : '"' ( ~["\n\r\\] | '\\' ["nr\\] )*? '"'
	   ;

LINE_COMMENT : '//' .*? (EOF | '\n') ->skip
			 ;

BLOCK_COMMENT : '/*' .*? '*/' ->skip
			  ;

WHITE_SPACE : [ \t\n\r]+ ->skip
			;
