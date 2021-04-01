package ast;

import utility.position;

public class IdxExpNode extends ExpNode {
	
	public ExpNode name;
	public ExpNode idx;

	public IdxExpNode( position pos ) {
		super(pos);
		name = null;
		idx = null;
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
