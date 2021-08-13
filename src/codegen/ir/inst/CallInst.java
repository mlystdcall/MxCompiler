package ir.inst;

import ir.BasicBlock;
import ir.Function;
import ir.operand.Operand;
import ir.operand.Register;
import ir.IRVisitor;

import java.util.ArrayList;

public class CallInst extends IRInst {
	public Function func;
	public ArrayList<Operand> params;
	public Register rst;

	public CallInst( BasicBlock blk, Function func, ArrayList<Operand> params, Register rst ) {
		super(blk);
		this.func = func;
		this.params = params;
		this.rst = rst;
		assert( rst.type.equals( func.functype.returnType ) );
		assert( params.size() == func.functype.paramList.size() );
		assert( params.size() == func.params.size() );
		for( int i = 0; i < params.size(); ++i ) {
			assert( params.get(i).type.equals( func.params.get(i).type ) );
			assert( params.get(i).type.equals( func.functype.paramList.get(i) ) );
		}
	}

	@Override public String toString() {
		StringBuilder str = new StringBuilder();
		str.append( rst.toString() + " = @" + func.name + "(" );
		for( int i = 0; i < params.size(); ++i ) {
			if( i != 0 ) str.append(", ");
			str.append( params.get(i).toString() );
		}
		str.append(")");
		return str.toString();
	}

	@Override public void accept( IRVisitor visitor ) {
		visitor.visit(this);
	}
}
