package ir.type;

import java.util.ArrayList;

public class FuncType extends IRType {
	public IRType returnType;
	public ArrayList<IRType> paramList;

	public FuncType( IRType returnType, ArrayList<IRType> paramList ) {
		this.returnType = returnType;
		this.paramList = paramList;
	}

	@Override public int size() {
		return 0;
	}

	@Override public String toString() {
		StringBuilder str = new StringBuilder();
		str.append( returnType.toString() );
		str.append("(");
		for( int i = 0; i < paramList.size(); ++i ) {
			if( i != 0 ) str.append(", ");
			str.append( paramList.get(i).toString() );
		}
		str.append(")");
		return str.toString();
	}

	@Override public boolean equals( IRType type ) {
		return (type instanceof FuncType) &&
			returnType.equals( ((FuncType)type).returnType ) &&
			paramList.equals( ((FuncType)type).paramList );
	}
}
