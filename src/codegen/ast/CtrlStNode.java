package ast;

import utility.position;

public class CtrlStNode extends StNode {
	
	public String ctrl;
	public ExpNode exp;
	
	public CtrlStNode( position pos ) {
		super(pos);
		ctrl = new String();
		exp = null;
	}

	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
