package ast;

import utility.position;

public class BinExpNode extends ExpNode {
	
	public ExpNode lhs;
	public ExpNode rhs;
	public String op;
	
	public BinExpNode( position pos ) {
		super(pos);
		lhs = null;
		rhs = null;
		op = new String();
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
