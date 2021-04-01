package ast;

import utility.position;

public class BlockStNode extends StNode {
	
	public BlockNode block;
	
	public BlockStNode( position pos ) {
		super(pos);
		block = null;
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
