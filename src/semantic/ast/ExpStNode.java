package ast;

import utility.position;

public class ExpStNode extends StNode {
	
	public ExpNode exp;
	
	public ExpStNode( position pos ) {
		super(pos);
		exp = null;
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
