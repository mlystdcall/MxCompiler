package ir;

import ir.operand.GlobalVar;
import ir.type.StructType;

import java.util.Map;
import java.util.LinkedHashMap;

public class Module {
	public Map<String, Function> funcs;
	public Map<String, GlobalVar> globalvars;
	public Map<String, StructType> structs;
	public Map<String, GlobalVar> cstrs;
	public Map<String, Function> extfuncs;

	public Module() {
		funcs = new LinkedHashMap<>();
		globalvars = new LinkedHashMap<>();
		structs = new LinkedHashMap<>();
		cstrs = new LinkedHashMap<>();
		extfuncs = new LinkedHashMap<>();
	}

	public void accept( IRVisitor visitor ) {
		visitor.visit(this);
	}
}
