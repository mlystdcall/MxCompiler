package ast;

import utility.position;

import java.util.ArrayList;

public class FunCallExpNode extends ExpNode {
	
	public ExpNode exp;
	public ArrayList<ExpNode> paramList;
	
	public FunCallExpNode( position pos ) {
		super(pos);
		exp = null;
		paramList = new ArrayList<>();
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
