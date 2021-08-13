package ir.operand;

import ir.type.PtrType;
import ir.type.VoidType;

public class ConstNull extends Const {
	public ConstNull() {
		super(new PtrType(new VoidType()));
	}

	@Override public String toString() {
		return "null";
	}
}
