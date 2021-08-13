package ir.type;

public class IntType extends IRType {
	@Override public int size() {
		return 4;
	}
	@Override public String toString() {
		return "int";
	}
	@Override public boolean equals( IRType type ) {
		return (type instanceof IntType);
	}
}
