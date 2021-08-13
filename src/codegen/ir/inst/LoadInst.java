package ir.inst;

import ir.operand.Operand;
import ir.operand.Register;
import ir.BasicBlock;
import ir.type.PtrType;
import ir.IRVisitor;

public class LoadInst extends IRInst {
	public Operand ptr;
	public Register rst;

	public LoadInst( BasicBlock blk, Operand ptr, Register rst ) {
		super(blk);
		this.ptr = ptr;
		this.rst = rst;
		assert( ptr.type instanceof PtrType );
		assert( ((PtrType)ptr.type).base.equals( rst.type ) );
	}

	@Override public String toString() {
		return rst.toString() + " = load " + ptr.toString();
	}

	@Override public void accept( IRVisitor visitor ) {
		visitor.visit(this);
	}
}
