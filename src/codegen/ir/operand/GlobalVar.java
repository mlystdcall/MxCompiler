package ir.operand;

import ir.type.IRType;

public class GlobalVar extends Operand {
	public String name;
	public Operand init;

	public GlobalVar( IRType type, String name, Operand init ) {
		super(type);
		this.name = name;
		this.init = init;
	}

	@Override public String toString() {
		return "@" + name;
	}
}
