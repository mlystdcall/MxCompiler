package ast;

import utility.position;

public class SufExpNode extends ExpNode {
	
	public ExpNode exp;
	public String op;
	
	public SufExpNode( position pos ) {
		super(pos);
		exp = null;
		op = new String();
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
