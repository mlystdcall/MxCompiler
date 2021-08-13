package ast;

import utility.position;

public class EmptyStNode extends StNode {
	
	public EmptyStNode( position pos ) {
		super(pos);
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
