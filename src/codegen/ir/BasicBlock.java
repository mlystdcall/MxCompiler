package ir;

import ir.inst.IRInst;

import java.util.ArrayList;

public class BasicBlock {
	public Function func;
	public String name;
	public ArrayList<IRInst> insts;

	public BasicBlock( Function func, String name ) {
		this.func = func;
		this.name = name;
		insts = new ArrayList<>();
	}

	@Override public String toString() {
		return "%" + name;
	}

	public void accept( IRVisitor visitor ) {
		visitor.visit(this);
	}
}
