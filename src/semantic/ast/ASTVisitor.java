package ast;

public interface ASTVisitor {
	void visit(RootNode nod);
	void visit(GlobalVarNode nod);
	void visit(TypeNode nod);
	void visit(FuncDefNode nod);
	void visit(ParamListNode nod);
	void visit(BlockNode nod);
	void visit(ClassDefNode nod);
	void visit(ClassVarNode nod);
	void visit(ClassFuncNode nod);
	void visit(BlockStNode nod);
	void visit(VarDefStNode nod);
	void visit(IfStNode nod);
	void visit(LoopStNode nod);
	void visit(CtrlStNode nod);
	void visit(ExpStNode nod);
	void visit(EmptyStNode nod);
	void visit(SufExpNode nod);
	void visit(FunCallExpNode nod);
	void visit(IdxExpNode nod);
	void visit(DotExpNode nod);
	void visit(UnaryExpNode nod);
	void visit(NewExpNode nod);
	void visit(BinExpNode nod);
	void visit(SimpleExpNode nod);
}
