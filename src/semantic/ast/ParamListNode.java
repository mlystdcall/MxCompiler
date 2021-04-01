package ast;

import utility.position;

import java.util.ArrayList;

public class ParamListNode extends ASTNode {
	
	public ArrayList<TypeNode> types;
	public ArrayList<String> names;
	
	public ParamListNode( position pos ) {
		super(pos);
		types = new ArrayList<>();
		names = new ArrayList<>();
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
