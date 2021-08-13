package ast;

import utility.position;

import java.util.ArrayList;

public class VarDefStNode extends StNode {
	
	public TypeNode type;
	public ArrayList<String> names;
	public ExpNode exp;

	public VarDefStNode( position pos ) {
		super(pos);
		type = null;
		names = new ArrayList<>();
		exp = null;
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
