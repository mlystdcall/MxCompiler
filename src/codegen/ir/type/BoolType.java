package ir.type;

public class BoolType extends IRType {
	@Override public int size() {
		return 1;
	}
	@Override public String toString() {
		return "bool";
	}
	@Override public boolean equals( IRType type ) {
		return (type instanceof BoolType);
	}
}
