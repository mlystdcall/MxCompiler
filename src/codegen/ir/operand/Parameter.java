package ir.operand;

import ir.Function;
import ir.type.IRType;

public class Parameter extends Operand {
	public String name;
	public Function func;

	public Parameter( IRType type, String name ) {
		super(type);
		this.name = name;
	}

	@Override public String toString() {
		return "%" + name;
	}
}
