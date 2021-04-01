package ast;

import utility.position;

public class FuncDefNode extends PartNode {
	
	public TypeNode returnType;
	public String name;
	public ParamListNode paramList;
	public BlockNode block;
	
	public FuncDefNode( position pos ) {
		super(pos);
		returnType = null;
		name = new String();
		paramList = null;
		block = null;
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
