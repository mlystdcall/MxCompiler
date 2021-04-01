package ast;

import utility.position;

import java.util.ArrayList;

public class RootNode extends ASTNode {
	public ArrayList<PartNode> parts;
	
	public RootNode( position pos ) {
		super(pos);
		parts = new ArrayList<>();
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
