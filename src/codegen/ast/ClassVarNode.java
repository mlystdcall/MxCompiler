package ast;

import utility.position;

import java.util.ArrayList;

public class ClassVarNode extends ClassContentNode {
	
	public TypeNode type;
	public ArrayList<String> names;
	
	public ClassVarNode( position pos ) {
		super(pos);
		type = null;
		names = new ArrayList<>();
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
