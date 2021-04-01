package parser;

// Generated from Mx.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#program_part}.
	 * @param ctx the parse tree
	 */
	void enterProgram_part(MxParser.Program_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#program_part}.
	 * @param ctx the parse tree
	 */
	void exitProgram_part(MxParser.Program_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#var_def}.
	 * @param ctx the parse tree
	 */
	void enterVar_def(MxParser.Var_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#var_def}.
	 * @param ctx the parse tree
	 */
	void exitVar_def(MxParser.Var_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#func_def}.
	 * @param ctx the parse tree
	 */
	void enterFunc_def(MxParser.Func_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#func_def}.
	 * @param ctx the parse tree
	 */
	void exitFunc_def(MxParser.Func_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#param_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_list(MxParser.Param_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#param_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_list(MxParser.Param_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#class_def}.
	 * @param ctx the parse tree
	 */
	void enterClass_def(MxParser.Class_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#class_def}.
	 * @param ctx the parse tree
	 */
	void exitClass_def(MxParser.Class_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#class_content}.
	 * @param ctx the parse tree
	 */
	void enterClass_content(MxParser.Class_contentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#class_content}.
	 * @param ctx the parse tree
	 */
	void exitClass_content(MxParser.Class_contentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#class_var_def}.
	 * @param ctx the parse tree
	 */
	void enterClass_var_def(MxParser.Class_var_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#class_var_def}.
	 * @param ctx the parse tree
	 */
	void exitClass_var_def(MxParser.Class_var_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#class_func_def}.
	 * @param ctx the parse tree
	 */
	void enterClass_func_def(MxParser.Class_func_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#class_func_def}.
	 * @param ctx the parse tree
	 */
	void exitClass_func_def(MxParser.Class_func_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MxParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MxParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock_st(MxParser.Block_stContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock_st(MxParser.Block_stContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var_def_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVar_def_st(MxParser.Var_def_stContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var_def_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVar_def_st(MxParser.Var_def_stContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_st(MxParser.If_stContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_st(MxParser.If_stContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_st(MxParser.While_stContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_st(MxParser.While_stContext ctx);
	/**
	 * Enter a parse tree produced by the {@code for_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_st(MxParser.For_stContext ctx);
	/**
	 * Exit a parse tree produced by the {@code for_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_st(MxParser.For_stContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_st(MxParser.Return_stContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_st(MxParser.Return_stContext ctx);
	/**
	 * Enter a parse tree produced by the {@code break_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreak_st(MxParser.Break_stContext ctx);
	/**
	 * Exit a parse tree produced by the {@code break_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreak_st(MxParser.Break_stContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continue_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinue_st(MxParser.Continue_stContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continue_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinue_st(MxParser.Continue_stContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exp_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExp_st(MxParser.Exp_stContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exp_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExp_st(MxParser.Exp_stContext ctx);
	/**
	 * Enter a parse tree produced by the {@code empty_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_st(MxParser.Empty_stContext ctx);
	/**
	 * Exit a parse tree produced by the {@code empty_st}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_st(MxParser.Empty_stContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(MxParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(MxParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(MxParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(MxParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(MxParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(MxParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MxParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MxParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fun_call_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFun_call_exp(MxParser.Fun_call_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fun_call_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFun_call_exp(MxParser.Fun_call_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code null_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNull_exp(MxParser.Null_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code null_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNull_exp(MxParser.Null_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idx_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdx_exp(MxParser.Idx_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idx_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdx_exp(MxParser.Idx_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code this_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThis_exp(MxParser.This_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code this_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThis_exp(MxParser.This_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber_exp(MxParser.Number_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber_exp(MxParser.Number_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifier_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_exp(MxParser.Identifier_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifier_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_exp(MxParser.Identifier_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterString_exp(MxParser.String_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitString_exp(MxParser.String_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unary_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_exp(MxParser.Unary_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unary_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_exp(MxParser.Unary_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bin_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBin_exp(MxParser.Bin_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bin_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBin_exp(MxParser.Bin_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dot_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDot_exp(MxParser.Dot_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dot_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDot_exp(MxParser.Dot_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code false_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFalse_exp(MxParser.False_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code false_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFalse_exp(MxParser.False_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paren_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParen_exp(MxParser.Paren_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paren_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParen_exp(MxParser.Paren_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code true_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTrue_exp(MxParser.True_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code true_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTrue_exp(MxParser.True_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNew_exp(MxParser.New_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNew_exp(MxParser.New_expContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suf_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuf_exp(MxParser.Suf_expContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suf_exp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuf_exp(MxParser.Suf_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#fun_call_list}.
	 * @param ctx the parse tree
	 */
	void enterFun_call_list(MxParser.Fun_call_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#fun_call_list}.
	 * @param ctx the parse tree
	 */
	void exitFun_call_list(MxParser.Fun_call_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code error_new}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void enterError_new(MxParser.Error_newContext ctx);
	/**
	 * Exit a parse tree produced by the {@code error_new}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void exitError_new(MxParser.Error_newContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paren_new}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void enterParen_new(MxParser.Paren_newContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paren_new}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void exitParen_new(MxParser.Paren_newContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array_new}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void enterArray_new(MxParser.Array_newContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array_new}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void exitArray_new(MxParser.Array_newContext ctx);
	/**
	 * Enter a parse tree produced by the {@code other_new}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void enterOther_new(MxParser.Other_newContext ctx);
	/**
	 * Exit a parse tree produced by the {@code other_new}
	 * labeled alternative in {@link MxParser#new_expression}.
	 * @param ctx the parse tree
	 */
	void exitOther_new(MxParser.Other_newContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#not_arr_t}.
	 * @param ctx the parse tree
	 */
	void enterNot_arr_t(MxParser.Not_arr_tContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#not_arr_t}.
	 * @param ctx the parse tree
	 */
	void exitNot_arr_t(MxParser.Not_arr_tContext ctx);
}
