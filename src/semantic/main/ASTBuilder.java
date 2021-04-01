package main;

import ast.*;
import parser.MxBaseVisitor;
import parser.MxParser;
import utility.position;
import utility.syntaxError;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;

public class ASTBuilder extends MxBaseVisitor<ASTNode> {
	
	@Override public ASTNode visitProgram(MxParser.ProgramContext ctx) {
		RootNode nod = new RootNode(new position(ctx));
		for( ParserRuleContext part : ctx.program_part() ) {
			nod.parts.add( (PartNode)visit(part) );
		}
		return nod;
	}
	
	@Override public ASTNode visitProgram_part(MxParser.Program_partContext ctx) {
		if( ctx.var_def() != null ) {
			return (PartNode)visit(ctx.var_def());
		} else if( ctx.func_def() != null ) {
			return (PartNode)visit(ctx.func_def());
		} else if( ctx.class_def() != null ) {
			return (PartNode)visit(ctx.class_def());
		} else {
			throw new syntaxError("program_part else", new position(ctx));
		}
	}
	
	@Override public ASTNode visitVar_def(MxParser.Var_defContext ctx) {
		GlobalVarNode nod = new GlobalVarNode(new position(ctx));
		nod.type = (TypeNode)visit(ctx.type());
		if( ctx.expression() != null ) {
			nod.exp = (ExpNode)visit(ctx.expression());
		}
		for( TerminalNode name : ctx.IDENTIFIER() ) {
			nod.names.add( name.getText() );
		}
		return nod;
	}
	
	@Override public ASTNode visitFunc_def(MxParser.Func_defContext ctx) {
		FuncDefNode nod = new FuncDefNode(new position(ctx));
		nod.returnType = (TypeNode)visit(ctx.type());
		nod.name = ctx.IDENTIFIER().getText();
		if( ctx.param_list() != null ) {
			nod.paramList = (ParamListNode)visit(ctx.param_list());
		}
		nod.block = (BlockNode)visit(ctx.block());
		return nod;
	}
	
	@Override public ASTNode visitParam_list(MxParser.Param_listContext ctx) {
		ParamListNode nod = new ParamListNode(new position(ctx));
		for( ParserRuleContext type : ctx.type() ) {
			nod.types.add( (TypeNode)visit(type) );
		}
		for( TerminalNode name : ctx.IDENTIFIER() ) {
			nod.names.add( name.getText() );
		}
		return nod;
	}
	
	@Override public ASTNode visitClass_def(MxParser.Class_defContext ctx) {
		ClassDefNode nod = new ClassDefNode(new position(ctx));
		nod.name = ctx.IDENTIFIER().getText();
		for( ParserRuleContext tmp : ctx.class_content().class_var_def() ) {
			nod.content.add( (ClassContentNode)visit(tmp) );
		}
		for( ParserRuleContext tmp : ctx.class_content().class_func_def() ) {
			nod.content.add( (ClassContentNode)visit(tmp) );
		}
		return nod;
	}

	@Override public ASTNode visitClass_content(MxParser.Class_contentContext ctx) {
		throw new syntaxError("class_content reach impossible", new position(ctx));
	}
	
	@Override public ASTNode visitClass_var_def(MxParser.Class_var_defContext ctx) {
		ClassVarNode nod = new ClassVarNode(new position(ctx));
		nod.type = (TypeNode)visit(ctx.type());
		for( TerminalNode name : ctx.IDENTIFIER() ) {
			nod.names.add( name.getText() );
		}
		return nod;
	}

	@Override public ASTNode visitClass_func_def(MxParser.Class_func_defContext ctx) {
		ClassFuncNode nod = new ClassFuncNode(new position(ctx));
		if( ctx.type() != null ) {
			nod.type = (TypeNode)visit(ctx.type());
		}
		nod.name = ctx.IDENTIFIER().getText();
		if( ctx.param_list() != null ) {
			nod.paramList = (ParamListNode)visit(ctx.param_list());
		}
		nod.block = (BlockNode)visit(ctx.block());
		return nod;
	}
	
	@Override public ASTNode visitBlock(MxParser.BlockContext ctx) {
		BlockNode nod = new BlockNode(new position(ctx));
		for( ParserRuleContext st : ctx.statement() ) {
			nod.sts.add( (StNode)visit(st) );
		}
		return nod;
	}
	
	@Override public ASTNode visitBlock_st(MxParser.Block_stContext ctx) {
		BlockStNode nod = new BlockStNode(new position(ctx));
		nod.block = (BlockNode)visit(ctx.block());
		return nod;
	}
	
	@Override public ASTNode visitVar_def_st(MxParser.Var_def_stContext ctx) {
		VarDefStNode nod = new VarDefStNode(new position(ctx));
		nod.type = (TypeNode)visit(ctx.var_def().type());
		if( ctx.var_def().expression() != null ) {
			nod.exp = (ExpNode)visit(ctx.var_def().expression());
		}
		for( TerminalNode name : ctx.var_def().IDENTIFIER() ) {
			nod.names.add(name.getText());
		}
		return nod;
	}
	
	@Override public ASTNode visitIf_st(MxParser.If_stContext ctx) {
		IfStNode nod = new IfStNode(new position(ctx));
		nod.exp = (ExpNode)visit(ctx.if_statement().expression());
		nod.trueSt = (StNode)visit(ctx.if_statement().strue);
		if( ctx.if_statement().sfalse != null ) {
			nod.falseSt = (StNode)visit(ctx.if_statement().sfalse);
		}
		return nod;
	}
	
	@Override public ASTNode visitWhile_st(MxParser.While_stContext ctx) {
		LoopStNode nod = new LoopStNode(new position(ctx));
		nod.exp2 = (ExpNode)visit(ctx.while_statement().expression());
		nod.st = (StNode)visit(ctx.while_statement().statement());
		return nod;
	}
	
	@Override public ASTNode visitFor_st(MxParser.For_stContext ctx) {
		LoopStNode nod = new LoopStNode(new position(ctx));
		if( ctx.for_statement().exp1 != null ) {
			nod.exp1 = (ExpNode)visit(ctx.for_statement().exp1);
		}
		if( ctx.for_statement().exp2 != null ) {
			nod.exp2 = (ExpNode)visit(ctx.for_statement().exp2);
		}
		if( ctx.for_statement().exp3 != null ) {
			nod.exp3 = (ExpNode)visit(ctx.for_statement().exp3);
		}
		nod.st = (StNode)visit(ctx.for_statement().statement());
		return nod;
	}
	
	@Override public ASTNode visitReturn_st(MxParser.Return_stContext ctx) {
		CtrlStNode nod = new CtrlStNode(new position(ctx));
		nod.ctrl = "return";
		if( ctx.expression() != null ) {
			nod.exp = (ExpNode)visit(ctx.expression());
		}
		return nod;
	}
	
	@Override public ASTNode visitBreak_st(MxParser.Break_stContext ctx) {
		CtrlStNode nod = new CtrlStNode(new position(ctx));
		nod.ctrl = "break";
		return nod;
	}
	
	@Override public ASTNode visitContinue_st(MxParser.Continue_stContext ctx) {
		CtrlStNode nod = new CtrlStNode(new position(ctx));
		nod.ctrl = "continue";
		return nod;
	}
	
	@Override public ASTNode visitExp_st(MxParser.Exp_stContext ctx) {
		ExpStNode nod = new ExpStNode(new position(ctx));
		nod.exp = (ExpNode)visit(ctx.expression());
		return nod;
	}
	
	@Override public ASTNode visitEmpty_st(MxParser.Empty_stContext ctx) {
		EmptyStNode nod = new EmptyStNode(new position(ctx));
		return nod;
	}

	@Override public ASTNode visitIf_statement(MxParser.If_statementContext ctx) {
		throw new syntaxError("if_statement reach impossible", new position(ctx));
	}
	
	@Override public ASTNode visitWhile_statement(MxParser.While_statementContext ctx) {
		throw new syntaxError("while_statement reach impossible", new position(ctx));
	}
	
	@Override public ASTNode visitFor_statement(MxParser.For_statementContext ctx) {
		throw new syntaxError("for_statement reach impossible", new position(ctx));
	}
	
	@Override public ASTNode visitType(MxParser.TypeContext ctx) {
		TypeNode nod = new TypeNode(new position(ctx));
		nod.name = ctx.typename.getText();
		nod.dim = (int)((ctx.getChildCount() - 1) / 2);
		return nod;
	}
	
	@Override public ASTNode visitFun_call_exp(MxParser.Fun_call_expContext ctx) {
		FunCallExpNode nod = new FunCallExpNode(new position(ctx));
		nod.exp = (ExpNode)visit(ctx.expression());
		if( ctx.fun_call_list() != null ) {
			for( ParserRuleContext exp : ctx.fun_call_list().expression() ) {
				nod.paramList.add( (ExpNode)visit(exp) );
			}
		}
		return nod;
	}
	
	@Override public ASTNode visitNull_exp(MxParser.Null_expContext ctx) {
		SimpleExpNode nod = new SimpleExpNode(new position(ctx));
		nod.type = "null";
		return nod;
	}

	@Override public ASTNode visitIdx_exp(MxParser.Idx_expContext ctx) {
		IdxExpNode nod = new IdxExpNode(new position(ctx));
		nod.name = (ExpNode)visit(ctx.name);
		nod.idx = (ExpNode)visit(ctx.idx);
		return nod;
	}
	
	@Override public ASTNode visitThis_exp(MxParser.This_expContext ctx) {
		SimpleExpNode nod = new SimpleExpNode(new position(ctx));
		nod.type = "this";
		return nod;
	}
	
	@Override public ASTNode visitNumber_exp(MxParser.Number_expContext ctx) {
		SimpleExpNode nod = new SimpleExpNode(new position(ctx));
		nod.type = "int";
		nod.num = Long.parseLong(ctx.NUMBER().getText());
		return nod;
	}
	
	@Override public ASTNode visitIdentifier_exp(MxParser.Identifier_expContext ctx) {
		SimpleExpNode nod = new SimpleExpNode(new position(ctx));
		nod.type = "#IDENTIFIER";
		nod.name = ctx.IDENTIFIER().getText();
		return nod;
	}
	
	@Override public ASTNode visitString_exp(MxParser.String_expContext ctx) {
		SimpleExpNode nod = new SimpleExpNode(new position(ctx));
		nod.type = "string";
		int len = ctx.STRING().getText().length();
		nod.str = ctx.STRING().getText().substring(1, len-1);
		return nod;
	}
	
	@Override public ASTNode visitUnary_exp(MxParser.Unary_expContext ctx) {
		UnaryExpNode nod = new UnaryExpNode(new position(ctx));
		nod.exp = (ExpNode)visit(ctx.expression());
		nod.op = ctx.op.getText();
		return nod;
	}
	
	@Override public ASTNode visitBin_exp(MxParser.Bin_expContext ctx) {
		BinExpNode nod = new BinExpNode(new position(ctx));
		nod.lhs = (ExpNode)visit(ctx.exp1);
		nod.rhs = (ExpNode)visit(ctx.exp2);
		nod.op = ctx.op.getText();
		return nod;
	}
	
	@Override public ASTNode visitDot_exp(MxParser.Dot_expContext ctx) {
		DotExpNode nod = new DotExpNode(new position(ctx));
		nod.exp = (ExpNode)visit(ctx.expression());
		nod.name = ctx.IDENTIFIER().getText();
		return nod;
	}

	@Override public ASTNode visitFalse_exp(MxParser.False_expContext ctx) {
		SimpleExpNode nod = new SimpleExpNode(new position(ctx));
		nod.type = "bool";
		nod.bool = false;
		return nod;
	}
	
	@Override public ASTNode visitParen_exp(MxParser.Paren_expContext ctx) {
		return (ExpNode)visit(ctx.expression());
	}
	
	@Override public ASTNode visitTrue_exp(MxParser.True_expContext ctx) {
		SimpleExpNode nod = new SimpleExpNode(new position(ctx));
		nod.type = "bool";
		nod.bool = true;
		return nod;
	}
	
	@Override public ASTNode visitNew_exp(MxParser.New_expContext ctx) {
		return (NewExpNode)visit(ctx.new_expression());
	}
	
	@Override public ASTNode visitSuf_exp(MxParser.Suf_expContext ctx) {
		SufExpNode nod = new SufExpNode(new position(ctx));
		nod.exp = (ExpNode)visit(ctx.expression());
		nod.op = ctx.op.getText();
		return nod;
	}
	
	@Override public ASTNode visitFun_call_list(MxParser.Fun_call_listContext ctx) {
		throw new syntaxError("fun_call_list reach impossible", new position(ctx));
	}
	
	@Override public ASTNode visitError_new(MxParser.Error_newContext ctx) {
		throw new syntaxError("error new", new position(ctx));
	}
	
	@Override public ASTNode visitParen_new(MxParser.Paren_newContext ctx) {
		NewExpNode nod = new NewExpNode(new position(ctx));
		nod.type = ctx.not_arr_t().typename.getText();
		return nod;
	}

	@Override public ASTNode visitArray_new(MxParser.Array_newContext ctx) {
		NewExpNode nod = new NewExpNode(new position(ctx));
		nod.type = ctx.not_arr_t().typename.getText();
		for( ParserRuleContext exp : ctx.expression() ) {
			nod.exps.add( (ExpNode)visit(exp) );
		}
		nod.dim = (int)((ctx.getChildCount() - 1 - ctx.expression().size()) / 2);
		return nod;
	}

	@Override public ASTNode visitOther_new(MxParser.Other_newContext ctx) {
		NewExpNode nod = new NewExpNode(new position(ctx));
		nod.type = ctx.not_arr_t().typename.getText();
		return nod;
	}
	
	@Override public ASTNode visitNot_arr_t(MxParser.Not_arr_tContext ctx) {
		throw new syntaxError("not_arr_t reach impossible", new position(ctx));
	}
	
}
