package ir;

import ir.inst.*;

public interface IRVisitor {
	public void visit( Module module );
	public void visit( Function func );
	public void visit( BasicBlock blk );
	
	public void visit( AllocaInst inst );
	public void visit( BinOpInst inst );
	public void visit( BrInst inst );
	public void visit( CallInst inst );
	public void visit( GetElemPtrInst inst );
	public void visit( IcmpInst inst );
	public void visit( LoadInst inst );
	public void visit( MoveInst inst );
	public void visit( RetInst inst );
	public void visit( StoreInst inst );
}
