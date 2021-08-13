package ir.operand;

import ir.type.BoolType;

public class ConstBool extends Const {
	public boolean val;

	public ConstBool( boolean val ) {
		super(new BoolType());
		this.val = val;
	}

	@Override public String toString() {
		return String.valueOf(val);
	}
}
