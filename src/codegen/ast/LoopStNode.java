package ast;

import utility.position;

public class LoopStNode extends StNode {
	
	public ExpNode exp1;
	public ExpNode exp2;
	public ExpNode exp3;
	public StNode st;
	
	public LoopStNode( position pos ) {
		super(pos);
		exp1 = null;
		exp2 = null;
		exp3 = null;
		st = null;
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
