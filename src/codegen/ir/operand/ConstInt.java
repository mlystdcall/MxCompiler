package ir.operand;

import ir.type.IntType;

public class ConstInt extends Const {
	public long val;

	public ConstInt( long val ) {
		super(new IntType());
		this.val = val;
	}

	@Override public String toString() {
		return String.valueOf(val);
	}
}
