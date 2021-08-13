package ir.type;

import java.util.ArrayList;

public class StructType extends IRType {
	public String name;
	public ArrayList<IRType> member;

	public StructType( String name, ArrayList<IRType> member ) {
		this.name = name;
		this.member = member;
	}

	@Override public int size() {
		int sz = 0;
		for( IRType type : member )
			sz += type.size();
		return sz;
	}

	@Override public String toString() {
		return "%" + name;
	}

	@Override public boolean equals( IRType type ) {
		return (type instanceof StructType) &&
			name.equals( ((StructType)type).name ) &&
			member.equals( ((StructType)type).member );
	}
}
