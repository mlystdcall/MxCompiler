package ast;

import utility.position;

abstract public class PartNode extends ASTNode {
	
	public PartNode( position pos ) {
		super(pos);
	}
	
	@Override abstract public void accept(ASTVisitor visitor);
}
