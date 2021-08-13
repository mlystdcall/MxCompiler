package ir.inst;

import ir.BasicBlock;
import ir.operand.Register;
import ir.type.IRType;
import ir.type.PtrType;
import ir.IRVisitor;

public class AllocaInst extends IRInst {
	public Register rst;
	public IRType type;

	public AllocaInst( BasicBlock blk, Register rst, IRType type ) {
		super(blk);
		this.rst = rst;
		this.type = type;
		assert( rst.type.equals( new PtrType(type) ) );
	}

	@Override public String toString() {
		return rst.toString() + " = alloca " + type.toString();
	}

	@Override public void accept( IRVisitor visitor ) {
		visitor.visit(this);
	}
}
