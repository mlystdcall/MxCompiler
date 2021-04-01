package ast;

import utility.position;

public class IfStNode extends StNode {
	
	public ExpNode exp;
	public StNode trueSt;
	public StNode falseSt;
	
	public IfStNode( position pos ) {
		super(pos);
		exp = null;
		trueSt = null;
		falseSt = null;
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
