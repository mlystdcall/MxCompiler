package ir.type;

public class ArrayType extends IRType {
	public int len;
	public IRType base;

	public ArrayType( int len, IRType base ) {
		this.len = len;
		this.base = base;
	}

	@Override public int size() {
		return len * base.size();
	}

	@Override public String toString() {
		return base.toString() + "[" + len + "]";
	}

	@Override public boolean equals( IRType type ) {
		return (type instanceof ArrayType) &&
			(len == ((ArrayType)type).len) &&
			base.equals( ((ArrayType)type).base );
	}
}
