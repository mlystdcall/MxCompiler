package ast;

import utility.position;

public class DotExpNode extends ExpNode {
	
	public ExpNode exp;
	public String name;
	
	public DotExpNode( position pos ) {
		super(pos);
		exp = null;
		name = new String();
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
