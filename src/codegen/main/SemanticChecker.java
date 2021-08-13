package main;

import ast.*;
import java.util.ArrayList;
import java.util.HashMap;
import utility.semanticError;
import utility.position;

public class SemanticChecker implements ASTVisitor {
	
	public HashMap<String, ClassDef> classes;
	public HashMap<String, FuncDef> funcs;
	public ArrayList<HashMap<String, VarDef>> vars;
	public int loop_dep;
	public FuncDef outside_func;
	public ClassDef outside_class;
	
	public SemanticChecker() {
		classes = new HashMap<>();
		funcs = new HashMap<>();
		vars = new ArrayList<>();
		loop_dep = 0;
		outside_func = null;
		outside_class = null;
	}

	private void add_built_in_function() {
		FuncDef func = null;
		VarDef var = null;
		
		// void print(string str);
		func = new FuncDef();
		func.type = "void";
		func.dim = 0;
		func.name = "print";
		var = new VarDef();
		var.type = "string";
		var.dim = 0;
		var.name = "str";
		func.args.add(var);
		funcs.put(func.name, func);
		
		// void println(string str);
		func = new FuncDef();
		func.type = "void";
		func.dim = 0;
		func.name = "println";
		var = new VarDef();
		var.type = "string";
		var.dim = 0;
		var.name = "str";
		func.args.add(var);
		funcs.put(func.name, func);
		
		// void printInt(int n);
		func = new FuncDef();
		func.type = "void";
		func.dim = 0;
		func.name = "printInt";
		var = new VarDef();
		var.type = "int";
		var.dim = 0;
		var.name = "n";
		func.args.add(var);
		funcs.put(func.name, func);
		
		// void printlnInt(int n);
		func = new FuncDef();
		func.type = "void";
		func.dim = 0;
		func.name = "printlnInt";
		var = new VarDef();
		var.type = "int";
		var.dim = 0;
		var.name = "n";
		func.args.add(var);
		funcs.put(func.name, func);
		
		// string getString();
		func = new FuncDef();
		func.type = "string";
		func.dim = 0;
		func.name = "getString";
		funcs.put(func.name, func);
		
		// int getInt();
		func = new FuncDef();
		func.type = "int";
		func.dim = 0;
		func.name = "getInt";
		funcs.put(func.name, func);
		
		// string toString(int i);
		func = new FuncDef();
		func.type = "string";
		func.dim = 0;
		func.name = "toString";
		var = new VarDef();
		var.type = "int";
		var.dim = 0;
		var.name = "i";
		func.args.add(var);
		funcs.put(func.name, func);
	}
	
	@Override public void visit( RootNode nod ) {
		add_built_in_function();
		vars.add( new HashMap<>() );
		for( PartNode it : nod.parts ) {
			if( it instanceof ClassDefNode ) {
				DeclareClass( (ClassDefNode)it );
			}
		}
		for( PartNode it : nod.parts ) {
			if( it instanceof ClassDefNode ) {
				DeclareClassContent( (ClassDefNode)it );
			} else if( it instanceof FuncDefNode ) {
				DeclareFunc( (FuncDefNode)it );
			}
		}
		for( PartNode it : nod.parts ) {
			it.accept(this);
		}
		vars.remove( vars.size() - 1 );
		if( funcs.containsKey("main") == false ) {
			throw new semanticError("no main found", nod.pos);
		}
		if( funcs.get("main").type.equals("int") == false ||
			funcs.get("main").dim != 0 ) {
			throw new semanticError("error main type", nod.pos);
		}
		if( funcs.get("main").args.size() != 0 ) {
			throw new semanticError("main cannot have args", nod.pos);
		}
	}
	
	@Override public void visit( GlobalVarNode nod ) {
		if( ok_var_type(nod.type.name) == false ) {
			throw new semanticError("error type: " + nod.type.name, nod.pos);
		}
		if( nod.exp != null ) {
			nod.exp.accept(this);
			if( ok_type_match( nod.exp.realType, nod.exp.realDim,
							   nod.type.name, nod.type.dim ) == false ) {
				throw new semanticError("type not match: (" +
										nod.exp.realType +
										") and (" +
										nod.type.name +
										")", nod.pos);
			}
		}
		HashMap<String, VarDef> now_vars = vars.get( vars.size() - 1 );
		for( String name : nod.names ) {
			if( now_vars.containsKey(name) || classes.containsKey(name) ) {
				throw new semanticError("var name invalid: " + name, nod.pos);
			}
			VarDef now = new VarDef();
			now.type = nod.type.name;
			now.dim = nod.type.dim;
			now.name = name;
			now_vars.put(name, now);
		}
	}
	
	@Override public void visit( TypeNode nod ) {
		throw new semanticError("visit(TypeNode) impossible", nod.pos);
	}
	
	private void DeclareFunc( FuncDefNode nod ) {
		if( ok_func_type(nod.returnType.name, nod.returnType.dim) == false ) {
			throw new semanticError("error type: " + nod.returnType.name, nod.pos);
		}
		if( funcs.containsKey(nod.name) || classes.containsKey(nod.name) ) {
			throw new semanticError("func name invalid: " + nod.name, nod.pos);
		}
		FuncDef now = new FuncDef();
		now.type = nod.returnType.name;
		now.dim = nod.returnType.dim;
		now.name = nod.name;
		if( nod.paramList != null ) {
			HashMap<String, VarDef> arg_scope = new HashMap<>();
			int args_cnt = nod.paramList.types.size();
			for( int i = 0; i < args_cnt; ++i ) {
				VarDef var = new VarDef();
				var.type = nod.paramList.types.get(i).name;
				var.dim = nod.paramList.types.get(i).dim;
				var.name = nod.paramList.names.get(i);
				if( ok_var_type(var.type) == false ) {
					throw new semanticError("error type: " + var.type, nod.pos);
				}
				if( arg_scope.containsKey(var.name) ||
					classes.containsKey(var.name) ) {
					throw new semanticError("var name invalid: " + var.name, nod.pos);
				}
				arg_scope.put(var.name, var);
				now.args.add(var);
			}
		}
		funcs.put(now.name, now);
	}
	
	@Override public void visit( FuncDefNode nod ) {
		FuncDef now = funcs.get(nod.name);
		vars.add( new HashMap<>() );
		HashMap<String, VarDef> now_vars = vars.get( vars.size() - 1 );
		for( VarDef var : now.args ) {
			now_vars.put(var.name, var);
		}
		outside_func = now;
		nod.block.accept(this);
		outside_func = null;
		vars.remove( vars.size() - 1 );
	}
	
	@Override public void visit( ParamListNode nod ) {
		throw new semanticError("visit(ParamListNode) impossible", nod.pos);
	}
	
	@Override public void visit( BlockNode nod ) {
		vars.add( new HashMap<>() );
		for( StNode st : nod.sts ) {
			st.accept(this);
		}
		vars.remove( vars.size() - 1 );
	}
	
	private void DeclareClass( ClassDefNode nod ) {
		if( classes.containsKey(nod.name) ||
			funcs.containsKey(nod.name) ||
			find_var(nod.name) != null ) {
			throw new semanticError("class name invalid: " + nod.name, nod.pos);
		}
		ClassDef now = new ClassDef();
		now.name = nod.name;
		classes.put(now.name, now);
	}

	private void DeclareClassContent( ClassDefNode nod ) {
		ClassDef now = classes.get(nod.name);
		for( ClassContentNode it : nod.content ) {
			if( it instanceof ClassVarNode ) {
				ClassVarNode tmp = (ClassVarNode)it;
				if( ok_var_type(tmp.type.name) == false ) {
					throw new semanticError("error type: " + tmp.type.name, tmp.pos);
				}
				for( String name : tmp.names ) {
					if( now.vars.containsKey(name) ||
						classes.containsKey(name) ) {
						throw new semanticError("var name invalid: " + name, tmp.pos);
					}
					VarDef var = new VarDef();
					var.type = tmp.type.name;
					var.dim = tmp.type.dim;
					var.name = name;
					now.vars.put(name, var);
				}
			} else if( it instanceof ClassFuncNode ) {
				ClassFuncNode tmp = (ClassFuncNode)it;
				FuncDef func = new FuncDef();
				if( tmp.type == null ) { // construct function
					func.type = "void";
					func.dim = 0;
					if( tmp.name.equals(now.name) == false ) {
						throw new semanticError("no return type: " + tmp.name, tmp.pos);
					}
					if( now.funcs.containsKey(tmp.name) ) {
						throw new semanticError("redefine construct function", tmp.pos);
					}
					func.name = tmp.name;
					now.funcs.put(func.name, func);
				} else {
					if( ok_func_type(tmp.type.name, tmp.type.dim) == false ) {
						throw new semanticError("error func type: " + tmp.type.name, tmp.pos);
					}
					func.type = tmp.type.name;
					func.dim = tmp.type.dim;
					if( now.funcs.containsKey(tmp.name) ||
						classes.containsKey(tmp.name) ) {
						throw new semanticError("func name invalid: " + tmp.name, tmp.pos);
					}
					func.name = tmp.name;
					if( tmp.paramList != null ) {
						HashMap<String, VarDef> arg_scope = new HashMap<>();
						int arg_cnt = tmp.paramList.types.size();
						for( int i = 0; i < arg_cnt; ++i ) {
							VarDef var = new VarDef();
							var.type = tmp.paramList.types.get(i).name;
							var.dim = tmp.paramList.types.get(i).dim;
							var.name = tmp.paramList.names.get(i);
							if( ok_var_type(var.type) == false ) {
								throw new semanticError("error var type: " + var.type, tmp.pos);
							}
							if( arg_scope.containsKey(var.name) ||
								classes.containsKey(var.name) ) {
								throw new semanticError("var name invalid: " + var.name, tmp.pos);
							}
							arg_scope.put(var.name, var);
							func.args.add(var);
						}
					}
					now.funcs.put(func.name, func);
				}
			} else {
				throw new semanticError("unknown ClassContentNode", nod.pos);
			}
		}
		if( now.funcs.containsKey(now.name) == false ) { // construct function
			FuncDef func = new FuncDef();
			func.type = "void";
			func.dim = 0;
			func.name = now.name;
			now.funcs.put(func.name, func);
		}
	}
	
	@Override public void visit( ClassDefNode nod ) {
		ClassDef now = classes.get(nod.name);
		vars.add( new HashMap<>() );
		HashMap<String, VarDef> now_vars = vars.get( vars.size() - 1 );
		outside_class = now;
		for( VarDef var : now.vars.values() ) {
			now_vars.put(var.name, var);
		}
		for( ClassContentNode it : nod.content ) {
			if( it instanceof ClassFuncNode ) {
				ClassFuncNode tmp = (ClassFuncNode)it;
				vars.add( new HashMap<>() );
				HashMap<String, VarDef> func_scope = vars.get( vars.size() - 1 );
				for( VarDef var : now.funcs.get(tmp.name).args ) {
					func_scope.put(var.name, var);
				}
				outside_func = now.funcs.get(tmp.name);
				tmp.block.accept(this);
				outside_func = null;
				vars.remove( vars.size() - 1 );
			}
		}
		outside_class = null;
		vars.remove( vars.size() - 1 );
	}
	
	@Override public void visit( ClassVarNode nod ) {
		throw new semanticError("ClassVarNode reach impossible", nod.pos);
	}
	
	@Override public void visit( ClassFuncNode nod ) {
		throw new semanticError("ClassFuncNode reach impossible", nod.pos);
	}
	
	@Override public void visit( BlockStNode nod ) {
		nod.block.accept(this);
	}
	
	@Override public void visit( VarDefStNode nod ) {
		if( ok_var_type(nod.type.name) == false ) {
			throw new semanticError("error type: " + nod.type.name, nod.pos);
		}
		if( nod.exp != null ) {
			nod.exp.accept(this);
			if( ok_type_match( nod.exp.realType, nod.exp.realDim,
							   nod.type.name, nod.type.dim ) == false ) {
				throw new semanticError("type not match", nod.pos);
			}
		}
		HashMap<String, VarDef> scope = vars.get( vars.size() - 1 );
		for( String name : nod.names ) {
			if( scope.containsKey(name) || classes.containsKey(name) ) {
				throw new semanticError("var name invalid: " + name, nod.pos);
			}
			VarDef var = new VarDef();
			var.type = nod.type.name;
			var.dim = nod.type.dim;
			var.name = name;
			scope.put(var.name, var);
		}
	}
	
	@Override public void visit( IfStNode nod ) {
		nod.exp.accept(this);
		if( nod.exp.realType.equals("bool") == false ||
			nod.exp.realDim != 0 ) {
			throw new semanticError("if exp not bool", nod.pos);
		}
		vars.add( new HashMap<>() );
		nod.trueSt.accept(this);
		vars.remove( vars.size() - 1 );
		if( nod.falseSt != null ) {
			vars.add( new HashMap<>() );
			nod.falseSt.accept(this);
			vars.remove( vars.size() - 1 );
		}
	}
	
	@Override public void visit( LoopStNode nod ) {
		if( nod.exp1 != null ) {
			nod.exp1.accept(this);
		}
		if( nod.exp2 != null ) {
			nod.exp2.accept(this);
			if( nod.exp2.realType.equals("bool") == false ||
				nod.exp2.realDim != 0 ) {
				throw new semanticError("condition exp not bool", nod.exp2.pos);
			}
		}
		if( nod.exp3 != null ) {
			nod.exp3.accept(this);
		}
		vars.add( new HashMap<>() );
		++loop_dep;
		nod.st.accept(this);
		--loop_dep;
		vars.remove( vars.size() - 1 );
	}
	
	@Override public void visit( CtrlStNode nod ) {
		if( nod.ctrl.equals("return") ) {
			if( outside_func.type.equals("void") ) {
				if( nod.exp != null ) {
					throw new semanticError("void func dont return exp", nod.pos);
				}
			} else {
				if( nod.exp == null ) {
					throw new semanticError("non-void func need return exp", nod.pos);
				} else {
					nod.exp.accept(this);
					if( ok_type_match( nod.exp.realType, nod.exp.realDim,
									   outside_func.type, outside_func.dim ) == false ) {
						throw new semanticError("return type not match", nod.pos);
					}
				}
			}
		} else if( nod.ctrl.equals("continue") ) {
			if( loop_dep == 0 ) {
				throw new semanticError("continue not in loop", nod.pos);
			}
		} else if( nod.ctrl.equals("break") ) {
			if( loop_dep == 0 ) {
				throw new semanticError("break not in loop", nod.pos);
			}
		} else {
			throw new semanticError("unknown ctrl: " + nod.ctrl, nod.pos);
		}
	}
	
	@Override public void visit( ExpStNode nod ) {
		nod.exp.accept(this);
	}
	
	@Override public void visit( EmptyStNode nod ) {
		;
	}
	
	@Override public void visit( SufExpNode nod ) {
		nod.exp.accept(this);
		if( nod.exp.realType.equals("int") == false ||
			nod.exp.realDim != 0 ||
			nod.exp.lvalue == false ) {
			throw new semanticError("cannot suffix ++/--", nod.pos);
		}
		nod.realType = "int";
		nod.realDim = 0;
		nod.lvalue = false;
	}
	
	@Override public void visit( FunCallExpNode nod ) {
		FuncDef func = null;
		if( nod.exp instanceof SimpleExpNode ) {
			SimpleExpNode tmp = (SimpleExpNode)nod.exp;
			if( tmp.type.equals("#IDENTIFIER") == false ) {
				throw new semanticError("not a func", tmp.pos);
			}
			func = find_func(tmp.name);
		} else if( nod.exp instanceof DotExpNode ) {
			DotExpNode tmp = (DotExpNode)nod.exp;
			tmp.exp.accept(this);
			func = get_func( tmp.exp.realType, tmp.exp.realDim, tmp.name, tmp.pos );
		} else {
			throw new semanticError("not a func", nod.pos);
		}
		
		if( func == null ) {
			throw new semanticError("not a func", nod.pos);
		}
		if( func.args.size() != nod.paramList.size() ) {
			throw new semanticError("arg cnt not same: " + func.name, nod.pos);
		}
		int arg_cnt = func.args.size();
		for( int i = 0; i < arg_cnt; ++i ) {
			nod.paramList.get(i).accept(this);
			if( ok_type_match( nod.paramList.get(i).realType, nod.paramList.get(i).realDim,
							   func.args.get(i).type, func.args.get(i).dim ) == false ) {
				throw new semanticError("arg " + i + " type not match", nod.pos);
			}
		}
		nod.realType = func.type;
		nod.realDim = func.dim;
		nod.lvalue = false;
	}
	
	@Override public void visit( IdxExpNode nod ) {
		nod.idx.accept(this);
		if( nod.idx.realType.equals("int") == false ||
			nod.idx.realDim != 0 ) {
			throw new semanticError("subscript is not int: " + nod.idx.realType, nod.pos);
		}
		nod.name.accept(this);
		if( nod.name.realDim == 0 ) {
			throw new semanticError("subscript on non-array type: " + nod.name.realType, nod.pos);
		} else {
			nod.realType = nod.name.realType;
			nod.realDim = nod.name.realDim - 1;
			nod.lvalue = true;
		}
	}
	
	@Override public void visit( DotExpNode nod ) {
		nod.exp.accept(this);
		if( nod.exp.realDim != 0 ||
			classes.containsKey(nod.exp.realType) == false ) {
			throw new semanticError("cannot get member from non-class type: " + nod.exp.realType, nod.pos);
		}
		ClassDef cls = classes.get(nod.exp.realType);
		if( cls.vars.containsKey(nod.name) == false ) {
			throw new semanticError("no member (" + nod.name + ") from (" + cls.name + ")", nod.pos);
		}
		VarDef var = cls.vars.get(nod.name);
		nod.realType = var.type;
		nod.realDim = var.dim;
		nod.lvalue = true;
	}
	
	@Override public void visit( UnaryExpNode nod ) {
		// ++ -- + - ! ~
		nod.exp.accept(this);
		if( nod.exp.realDim > 0 ) {
			throw new semanticError("unary op on array type", nod.pos);
		}
		nod.realDim = 0;
		
		if( nod.op.equals("++") || nod.op.equals("--") ) {
			if( nod.exp.lvalue == false ) {
				throw new semanticError("prefix ++/-- on rvalue", nod.pos);
			}
			nod.lvalue = true;
		} else {
			nod.lvalue = false;
		}
		
		if( nod.op.equals("++") || nod.op.equals("--") ||
			nod.op.equals("+") || nod.op.equals("-") ||
			nod.op.equals("~") ) {
			if( nod.exp.realType.equals("int") == false ) {
				throw new semanticError("++/--/+/-/~ on non-int type: " + nod.exp.realType, nod.pos);
			}
			nod.realType = "int";
		} else if( nod.op.equals("!") ) {
			if( nod.exp.realType.equals("bool") == false ) {
				throw new semanticError("! on non-bool type: " + nod.exp.realType, nod.pos);
			}
			nod.realType = "bool";
		} else {
			throw new semanticError("unknown unary op: " + nod.op, nod.pos);
		}
	}
	
	@Override public void visit( NewExpNode nod ) {
		if( ok_var_type(nod.type) == false ) {
			throw new semanticError("invalid new type: " + nod.type, nod.pos);
		}
		nod.realType = nod.type;
		nod.realDim = nod.dim;
		nod.lvalue = false;
		for( ExpNode exp : nod.exps ) {
			exp.accept(this);
			if( exp.realDim > 0 ||
				exp.realType.equals("int") == false ) {
				throw new semanticError("exp not int in new: " + exp.realType, exp.pos);
			}
		}
	}
	
	@Override public void visit( BinExpNode nod ) {
		// int
		// * / % - >> << & ^ | 
		
		// int string
		// + < <= > >= 
		
		// int string bool array ...
		// != == 
		
		// bool
		// && || 
		
		// all
		// = 
		
		nod.lhs.accept(this);
		nod.rhs.accept(this);
		if( nod.op.equals("=") ) {
			if( nod.lhs.lvalue == false ) {
				throw new semanticError("lhs of assign is rvalue", nod.pos);
			}
			nod.lvalue = true;
			if( ok_type_match( nod.lhs.realType, nod.lhs.realDim,
							   nod.rhs.realType, nod.rhs.realDim ) == false ) {
				throw new semanticError("type not match in assign", nod.pos);
			}
			nod.realType = nod.lhs.realType;
			nod.realDim = nod.lhs.realDim;
			return;
		}
		
		nod.lvalue = false;
		nod.realDim = 0;
		if( ok_type_match( nod.lhs.realType, nod.lhs.realDim,
						   nod.rhs.realType, nod.rhs.realDim ) == false ) {
			throw new semanticError("lhs and rhs type not match", nod.pos);
		}
		if( nod.op.equals("*") || nod.op.equals("/") ||
			nod.op.equals("%") || nod.op.equals("-") ||
			nod.op.equals(">>") || nod.op.equals("<<") ||
			nod.op.equals("&") || nod.op.equals("^") ||
			nod.op.equals("|") ) {
			
			if( nod.lhs.realType.equals("int") == false ||
				nod.lhs.realDim > 0 ) {
				throw new semanticError("arithmatic op on non-int", nod.pos);
			}
			nod.realType = "int";
			
		} else if( nod.op.equals("+") || nod.op.equals("<") ||
				   nod.op.equals("<=") || nod.op.equals(">") ||
				   nod.op.equals(">=") ) {
			
			if( nod.lhs.realDim > 0 ||
				(nod.lhs.realType.equals("int") == false &&
				 nod.lhs.realType.equals("string") == false) ||
				nod.rhs.realDim > 0 ||
				(nod.rhs.realType.equals("int") == false &&
				 nod.rhs.realType.equals("string") == false) ) {
				throw new semanticError("+/cmp op not on int/string", nod.pos);
			}
			if( nod.op.equals("+") ) {
				nod.realType = nod.lhs.realType;
			} else {
				nod.realType = "bool";
			}
			
		} else if( nod.op.equals("!=") || nod.op.equals("==") ) {
			
			nod.realType = "bool";
			
		} else if( nod.op.equals("&&") || nod.op.equals("||") ) {
			
			if( nod.lhs.realType.equals("bool") == false ||
				nod.lhs.realDim > 0 ) {
				throw new semanticError("&&/|| op is non-bool", nod.pos);
			}
			nod.realType = "bool";
			
		} else {
			throw new semanticError("unknown binary op: " + nod.op, nod.pos);
		}
	}
	
	@Override public void visit( SimpleExpNode nod ) {
		if( nod.type.equals("int") ||
			nod.type.equals("string") ||
			nod.type.equals("null") ||
			nod.type.equals("bool") ) {
			nod.realType = nod.type;
			nod.realDim = 0;
			nod.lvalue = false;
		} else if( nod.type.equals("this") ) {
			if( outside_class == null ) {
				throw new semanticError("this not in class", nod.pos);
			}
			nod.realType = outside_class.name;
			nod.realDim = 0;
			nod.lvalue = false;
		} else if( nod.type.equals("#IDENTIFIER") ) {
			VarDef var = find_var(nod.name);
			if( var == null ) {
				throw new semanticError("var not exist: " + nod.name, nod.pos);
			}
			nod.realType = var.type;
			nod.realDim = var.dim;
			nod.lvalue = true;
		} else {
			throw new semanticError("unknown SimpleExpNode type: " + nod.type, nod.pos);
		}
	}
	
	private boolean ok_var_type( String type ) {
		if( type.equals("bool") ||
			type.equals("int") ||
			type.equals("string") ||
			classes.containsKey(type) ) {
			return true;
		} else {
			return false;
		}
	}

	private boolean ok_func_type( String type, int dim ) {
		if( ok_var_type(type) ||
			(type.equals("void") && dim == 0) ) {
			return true;
		} else {
			return false;
		}
	}

	private boolean ok_type_match( String t1name, int t1dim,
								   String t2name, int t2dim ) {
		if( t1name.equals(t2name) && t1dim == t2dim ) {
			return true;
		} else {
			String type;
			int dim;
			if( t1name.equals("null") ) {
				type = t2name;
				dim = t2dim;
			} else if( t2name.equals("null") ) {
				type = t1name;
				dim = t1dim;
			} else {
				return false;
			}
			if( dim > 0 ||
				classes.containsKey(type) ||
				type.equals("string") ) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	private VarDef find_var( String name ) {
		for( int i = vars.size() - 1; i >= 0; --i ) {
			if( vars.get(i).containsKey(name) ) {
				return vars.get(i).get(name);
			}
		}
		return null;
	}
	
	private FuncDef find_func( String name ) {
		if( outside_class != null ) {
			if( outside_class.funcs.containsKey(name) ) {
				return outside_class.funcs.get(name);
			}
		}
		return funcs.get(name);
	}
	
	private FuncDef get_func( String type, int dim, String name, position pos ) {
		if( dim > 0 ) {
			if( name.equals("size") ) {
				FuncDef func = new FuncDef();
				func.type = "int";
				func.dim = 0;
				func.name = "size";
				return func;
			} else {
				throw new semanticError("member func of array not found: " + name, pos);
			}
		} else {
			if( type.equals("string") ) {
				FuncDef func = new FuncDef();
				func.dim = 0;
				if( name.equals("length") ) {
					// int length();
					func.type = "int";
					func.name = "length";
				} else if( name.equals("substring") ) {
					// string substring(int left, int right);
					func.type = "string";
					func.name = "substring";
					VarDef var = new VarDef();
					var.type = "int";
					var.dim = 0;
					var.name = "left";
					func.args.add(var);
					var = new VarDef();
					var.type = "int";
					var.dim = 0;
					var.name = "right";
					func.args.add(var);
				} else if( name.equals("parseInt") ) {
					// int parseInt();
					func.type = "int";
					func.name = "parseInt";
				} else if( name.equals("ord") ) {
					// int ord(int pos);
					func.type = "int";
					func.name = "ord";
					VarDef var = new VarDef();
					var.type = "int";
					var.dim = 0;
					var.name = "pos";
					func.args.add(var);
				} else {
					throw new semanticError("member func of string not found: " + name, pos);
				}
				return func;
			} else {
				if( classes.containsKey(type) ) {
					ClassDef cls = classes.get(type);
					if( cls.funcs.containsKey(name) == false ) {
						throw new semanticError("member func not found: " + name, pos);
					} else {
						return cls.funcs.get(name);
					}
				} else {
					throw new semanticError("non-class dont have member func: " + type, pos);
				}
			}
		}
	}
}

class VarDef {
	
	public String type;
	public String name;
	public int dim;
	
	public VarDef() {
		type = new String();
		name = new String();
		dim = 0;
	}
	
}

class FuncDef {
	
	public String type;
	int dim;
	public String name;
	public ArrayList<VarDef> args;
	
	public FuncDef() {
		type = new String();
		dim = 0;
		name = new String();
		args = new ArrayList<>();
	}
	
}

class ClassDef {
	
	public String name;
	public HashMap<String, VarDef> vars;
	public HashMap<String, FuncDef> funcs;
	
	public ClassDef() {
		name = new String();
		vars = new HashMap<>();
		funcs = new HashMap<>();
	}
	
}
