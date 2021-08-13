package ir.type;

public class VoidType extends IRType {
	@Override public int size() {
		return 0;
	}
	@Override public String toString() {
		return "void";
	}
	@Override public boolean equals( IRType type ) {
		return (type instanceof VoidType);
	}
}
