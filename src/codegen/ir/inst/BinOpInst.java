package ir.inst;

import ir.operand.Operand;
import ir.operand.Register;
import ir.BasicBlock;
import ir.IRVisitor;
import ir.type.IntType;

public class BinOpInst extends IRInst {
	public enum Op {
		add, sub, mul, sdiv, srem, shl, ashr, and, or, xor
	}

	public Op op;
	public Operand lhs;
	public Operand rhs;
	public Register rst;

	public BinOpInst( BasicBlock blk, Op op, Operand lhs, Operand rhs, Register rst ) {
		super(blk);
		this.op = op;
		this.lhs = lhs;
		this.rhs = rhs;
		this.rst = rst;
		assert( lhs.type.equals( new IntType() ) );
		assert( rhs.type.equals( new IntType() ) );
		assert( rst.type.equals( new IntType() ) );
	}

	@Override public String toString() {
		return rst.toString() + " = " + op.name() + " " + lhs.toString() + ", " + rhs.toString();
	}

	@Override public void accept( IRVisitor visitor ) {
		visitor.visit(this);
	}
}
