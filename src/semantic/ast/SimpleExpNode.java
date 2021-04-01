package ast;

import utility.position;

public class SimpleExpNode extends ExpNode {
	
	public String type;
	public long num;
	public String str;
	public boolean bool;
	public String name;
	
	public SimpleExpNode( position pos ) {
		super(pos);
		type = new String();
		num = 0;
		str = new String();
		bool = false;
		name = new String();
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
