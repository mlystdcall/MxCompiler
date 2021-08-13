package ir.operand;

import ir.type.IRType;

abstract public class Operand {
	public IRType type;

	public Operand( IRType type ) {
		this.type = type;
	}

	@Override abstract public String toString();
}
