package ast;

import utility.position;

abstract public class StNode extends ASTNode {
	
	public StNode( position pos ) {
		super(pos);
	}
	
	@Override abstract public void accept(ASTVisitor visitor);
}
