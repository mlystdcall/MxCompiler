package ast;

import utility.position;

abstract public class ExpNode extends ASTNode {
	
	public String realType;
	public int realDim;
	public boolean lvalue;
	
	public ExpNode( position pos ) {
		super(pos);
		realType = new String();
		lvalue = false;
	}
	
	@Override abstract public void accept(ASTVisitor visitor);
}
