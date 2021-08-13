package ir.operand;

import ir.inst.IRInst;
import ir.type.IRType;

public class Register extends Operand {
	public String name;
	public IRInst def;

	public Register( IRType type, String name ) {
		super(type);
		this.name = name;
	}

	@Override public String toString() {
		return "%" + name;
	}
}
