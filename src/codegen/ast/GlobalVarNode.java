package ast;

import utility.position;

import java.util.ArrayList;

public class GlobalVarNode extends PartNode {
	
	public TypeNode type;
	public ExpNode exp;
	public ArrayList<String> names;
	
	public GlobalVarNode( position pos ) {
		super(pos);
		type = null;
		exp = null;
		names = new ArrayList<>();
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
