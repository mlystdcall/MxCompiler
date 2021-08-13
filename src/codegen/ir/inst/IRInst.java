package ir.inst;

import ir.BasicBlock;
import ir.IRVisitor;

abstract public class IRInst {
	public BasicBlock blk;

	public IRInst( BasicBlock blk ) {
		this.blk = blk;
	}

	abstract public String toString();

	abstract public void accept( IRVisitor visitor );
}
