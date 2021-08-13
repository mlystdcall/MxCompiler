package ir.inst;

import ir.operand.Operand;
import ir.operand.Register;
import ir.operand.GlobalVar;
import ir.BasicBlock;
import ir.type.PtrType;
import ir.type.ArrayType;
import ir.type.CharType;
import ir.type.IntType;
import ir.IRVisitor;

public class GetElemPtrInst extends IRInst {
	public Operand ptr;
	public Operand idx;
	public Operand offset;
	public Register rst;

	public GetElemPtrInst( BasicBlock blk, Operand ptr, Operand idx, Operand offset, Register rst ) {
		super(blk);
		this.ptr = ptr;
		this.idx = idx;
		this.offset = offset;
		this.rst = rst;
		assert( (ptr.type instanceof PtrType) || (ptr.type instanceof ArrayType) );
		assert( idx.type instanceof IntType );
		assert( offset.type instanceof IntType );
		assert( rst.type instanceof PtrType );
		if( ptr.type instanceof ArrayType ) {
			assert( ptr instanceof GlobalVar );
			assert( ((PtrType)rst.type).base instanceof CharType );
		}
	}

	@Override public String toString() {
		return rst.toString() + " = GetElemPtr " + ptr.toString() + ", " + idx.toString() + ", " + offset.toString();
	}

	@Override public void accept( IRVisitor visitor ) {
		visitor.visit(this);
	}
}
