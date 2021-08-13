package ast;

import utility.position;

import java.util.ArrayList;

public class NewExpNode extends ExpNode {
	
	public String type;
	public int dim;
	public ArrayList<ExpNode> exps;
	
	public NewExpNode( position pos ) {
		super(pos);
		type = new String();
		dim = 0;
		exps = new ArrayList<>();
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
