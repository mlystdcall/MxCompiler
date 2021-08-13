package ir.inst;

import ir.operand.Operand;
import ir.BasicBlock;
import ir.IRVisitor;

public class RetInst extends IRInst {
	public Operand val;

	public RetInst( BasicBlock blk, Operand val ) {
		super(blk);
		this.val = val;
	}

	@Override public String toString() {
		return "ret " + val.toString();
	}

	@Override public void accept( IRVisitor visitor ) {
		visitor.visit(this);
	}
}
