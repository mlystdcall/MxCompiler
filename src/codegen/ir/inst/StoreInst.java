package ir.inst;

import ir.operand.Operand;
import ir.BasicBlock;
import ir.type.PtrType;
import ir.IRVisitor;

public class StoreInst extends IRInst {
	public Operand val;
	public Operand ptr;

	public StoreInst( BasicBlock blk, Operand val, Operand ptr ) {
		super(blk);
		this.val = val;
		this.ptr = ptr;
		assert( ptr.type instanceof PtrType );
		assert( ((PtrType)ptr.type).base.equals( val.type ) );
	}

	@Override public String toString() {
		return "store " + ptr.toString() + ", " + val.toString();
	}

	@Override public void accept( IRVisitor visitor ) {
		visitor.visit(this);
	}
}
