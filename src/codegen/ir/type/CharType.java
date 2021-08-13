package ir.type;

public class CharType extends IRType {
	@Override public int size() {
		return 1;
	}
	@Override public String toString() {
		return "char";
	}
	@Override public boolean equals( IRType type ) {
		return (type instanceof CharType);
	}
}
