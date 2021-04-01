package ast;

import utility.position;

import java.util.ArrayList;

public class ClassFuncNode extends ClassContentNode {
	
	public TypeNode type;
	public String name;
	public ParamListNode paramList;
	public BlockNode block;
	
	public ClassFuncNode( position pos ) {
		super(pos);
		type = null;
		name = new String();
		paramList = null;
		block = null;
	}
	
	@Override public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
