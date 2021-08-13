package ast;

import utility.position;

import java.util.ArrayList;

public class ClassDefNode extends PartNode {
	
	public String name;
	public ArrayList<ClassContentNode> content;
	
	public ClassDefNode( position pos ) {
		super(pos);
		name = new String();
		content = new ArrayList<>();
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
