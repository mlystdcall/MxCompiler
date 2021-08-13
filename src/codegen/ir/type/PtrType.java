package ir.type;

public class PtrType extends IRType {
	public IRType base;

	public PtrType( IRType base ) {
		this.base = base;
	}

	@Override public int size() {
		return 4;
	}

	@Override public String toString() {
		return base.toString() + "*";
	}

	@Override public boolean equals( IRType type ) {
		return (type instanceof PtrType) &&
			base.equals( ((PtrType)type).base );
	}
}
