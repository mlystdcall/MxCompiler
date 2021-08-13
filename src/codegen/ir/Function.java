package ir;

import ir.type.FuncType;
import ir.type.IRType;
import ir.operand.Parameter;
import ir.operand.Register;
import ir.IRVisitor;

import java.util.ArrayList;

public class Function {
	public Module module;
	
	public String name;
	public FuncType functype;
	public ArrayList<Parameter> params;

	public BasicBlock initblk;
	public BasicBlock rtnblk;
	public ArrayList<BasicBlock> blks;
	public Register retval;

	public Function( Module module, String name, IRType returnType, ArrayList<Parameter> params ) {
		this.module = module;
		this.name = name;
		this.params = params;
		ArrayList<IRType> functype_params = new ArrayList<>();
		for( int i = 0; i < params.size(); ++i ) {
			functype_params.add( params.get(i).type );
			params.get(i).func = this;
		}
		functype = new FuncType( returnType, functype_params );
		initblk = new BasicBlock( this, name + ".initblk" );
		rtnblk = new BasicBlock( this, name + ".rtnblk" );
		blks = new ArrayList<>();
		retval = new Register( returnType, name + ".retval" );
	}

	@Override public String toString() {
		return name;
	}

	public void accept( IRVisitor visitor ) {
		visitor.visit(this);
	}
}
