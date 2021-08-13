package ir.operand;

import ir.type.CharType;

public class ConstChar extends Const {
	public char val;

	public ConstChar( char val ) {
		super(new CharType());
		this.val = val;
	}

	@Override public String toString() {
		return "'" + val + "'";
	}
}
