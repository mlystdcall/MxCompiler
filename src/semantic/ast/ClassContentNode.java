package ast;

import utility.position;

abstract public class ClassContentNode extends ASTNode {
	
	public ClassContentNode( position pos ) {
		super(pos);
	}
	
	@Override abstract public void accept(ASTVisitor visitor);
}
