package parser;

// Generated from Mx.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#program_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram_part(MxParser.Program_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#var_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_def(MxParser.Var_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#func_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_def(MxParser.Func_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#param_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_list(MxParser.Param_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#class_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_def(MxParser.Class_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#class_content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_content(MxParser.Class_contentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#class_var_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_var_def(MxParser.Class_var_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#class_func_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_func_def(MxParser.Class_func_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MxParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_st(MxParser.Block_stContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var_def_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_def_st(MxParser.Var_def_stContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_st(MxParser.If_stContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_st(MxParser.While_stContext ctx);
	/**
	 * Visit a parse tree produced by the {@code for_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_st(MxParser.For_stContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_st(MxParser.Return_stContext ctx);
	/**
	 * Visit a parse tree produced by the {@code break_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_st(MxParser.Break_stContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continue_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue_st(MxParser.Continue_stContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exp_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_st(MxParser.Exp_stContext ctx);
	/**
	 * Visit a parse tree produced by the {@code empty_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty_st(MxParser.Empty_stContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(MxParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_statement(MxParser.While_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statement(MxParser.For_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MxParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fun_call_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun_call_exp(MxParser.Fun_call_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code null_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull_exp(MxParser.Null_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idx_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdx_exp(MxParser.Idx_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code this_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThis_exp(MxParser.This_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber_exp(MxParser.Number_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifier_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier_exp(MxParser.Identifier_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_exp(MxParser.String_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unary_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_exp(MxParser.Unary_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bin_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBin_exp(MxParser.Bin_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dot_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDot_exp(MxParser.Dot_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code false_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse_exp(MxParser.False_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen_exp(MxParser.Paren_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code true_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_exp(MxParser.True_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_exp(MxParser.New_expContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suf_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuf_exp(MxParser.Suf_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#fun_call_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun_call_list(MxParser.Fun_call_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code error_new}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitError_new(MxParser.Error_newContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren_new}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen_new(MxParser.Paren_newContext ctx);
	/**
	 * Visit a parse tree produced by the {@code array_new}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_new(MxParser.Array_newContext ctx);
	/**
	 * Visit a parse tree produced by the {@code other_new}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOther_new(MxParser.Other_newContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#not_arr_t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_arr_t(MxParser.Not_arr_tContext ctx);
}
