package ir.inst;

import ir.operand.Operand;
import ir.operand.Register;
import ir.BasicBlock;
import ir.type.BoolType;
import ir.IRVisitor;

public class IcmpInst extends IRInst {
	public enum Op {
		eq, ne, sgt, sge, slt, sle
	}

	public Op op;
	public Operand lhs;
	public Operand rhs;
	public Register rst;

	public IcmpInst( BasicBlock blk, Op op, Operand lhs, Operand rhs, Register rst ) {
		super(blk);
		this.op = op;
		this.lhs = lhs;
		this.rhs = rhs;
		this.rst = rst;
		assert( lhs.type.equals( rhs.type ) );
		assert( rst.type.equals( new BoolType() ) );
	}

	@Override public String toString() {
		return rst.toString() + " = " + op.name() + " " + lhs.toString() + ", " + rhs.toString();
	}

	@Override public void accept( IRVisitor visitor ) {
		visitor.visit(this);
	}
}
