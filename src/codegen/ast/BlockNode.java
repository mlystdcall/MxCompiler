package ast;

import utility.position;

import java.util.ArrayList;

public class BlockNode extends ASTNode {
	
	public ArrayList<StNode> sts;
	
	public BlockNode( position pos ) {
		super(pos);
		sts = new ArrayList<>();
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
