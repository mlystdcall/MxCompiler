package ast;

import utility.position;

public class TypeNode extends ASTNode {
	
	public String name;
	public int dim;
	
	public TypeNode( position pos ) {
		super(pos);
		name = new String();
		dim = 0;
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
