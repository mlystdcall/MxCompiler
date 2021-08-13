package ir.operand;

import ir.type.ArrayType;
import ir.type.CharType;

public class ConstString extends Const {
	public String val;

	public ConstString( String val ) {
		super(new ArrayType(val.length() + 1, new CharType()));
		this.val = val;
	}

	@Override public String toString() {
		return "\"" + val + "\"";
	}
}
