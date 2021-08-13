package ir.inst;

import ir.operand.Operand;
import ir.operand.Register;
import ir.BasicBlock;
import ir.IRVisitor;

public class MoveInst extends IRInst {
	public Operand src;
	public Register rst;

	public MoveInst( BasicBlock blk, Operand src, Register rst ) {
		super(blk);
		this.src = src;
		this.rst = rst;
		assert( src.type.equals( rst.type ) );
	}

	@Override public String toString() {
		return rst.toString() + " = " + src.toString();
	}

	@Override public void accept( IRVisitor visitor ) {
		visitor.visit(this);
	}
}
