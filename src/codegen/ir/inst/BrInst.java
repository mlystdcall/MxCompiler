package ir.inst;

import ir.operand.Operand;
import ir.BasicBlock;
import ir.type.BoolType;
import ir.IRVisitor;

public class BrInst extends IRInst {
	public Operand cond;
	public BasicBlock trueblk;
	public BasicBlock falseblk;

	public BrInst( BasicBlock blk, Operand cond, BasicBlock trueblk, BasicBlock falseblk ) {
		super(blk);
		this.cond = cond;
		this.trueblk = trueblk;
		this.falseblk = falseblk;
		assert( cond.type.equals( new BoolType() ) );
	}

	@Override public String toString() {
		return "br " + cond.toString() + ", " + trueblk.toString() + ", " + falseblk.toString();
	}

	@Override public void accept( IRVisitor visitor ) {
		visitor.visit(this);
	}
}
