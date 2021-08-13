package ir;

import ir.inst.*;
import ir.type.StructType;
import ir.operand.GlobalVar;

public class IRPrinter implements IRVisitor {
	@Override public void visit( Module module ) {
		for( StructType type : module.structs.values() ) {
			System.err.println( "Class " + type.toString() );
			for( int i = 0; i < type.member.size(); ++i ) {
				System.err.println( "Member " + i + " " + type.member.get(i).toString() );
			}
			System.err.println( "end Class" );
		}
		System.err.println("");
		System.err.println("Global Vars");
		for( GlobalVar var : module.globalvars.values() ) {
			System.err.println( var.type.toString() + " " + var.toString() + " = " + var.init.toString() );
		}
		System.err.println("");
		System.err.println("Const String");
		for( String str : module.cstrs.keySet() ) {
			System.err.println( module.cstrs.get(str).toString() + " = \"" + str + "\"" );
		}
		System.err.println("");
		for( Function func : module.extfuncs.values() ) {
			System.err.println("Extern Function");
			func.accept(this);
			System.err.println("");
		}
		for( Function func : module.funcs.values() ) {
			func.accept(this);
			System.err.println("");
		}
	}

	@Override public void visit( Function func ) {
		System.err.println( "Function " + func.toString() );
		System.err.println( "Return " + func.functype.returnType.toString() + " " + func.retval.toString() );
		for( int i = 0; i < func.params.size(); ++i ) {
			System.err.println( "Param " + i + " " + func.params.get(i).type.toString() + " " + func.params.get(i).toString() );
		}
		func.initblk.accept(this);
		for( BasicBlock blk : func.blks )
			blk.accept(this);
		func.rtnblk.accept(this);
		System.err.println( "end Function" );
	}

	@Override public void visit( BasicBlock blk ) {
		System.err.println( "Block " + blk.toString() );
		for( IRInst inst : blk.insts )
			inst.accept(this);
		System.err.println( "end Block" );
	}

	@Override public void visit( AllocaInst inst ) {
		System.err.println( "\t" + inst.toString() );
	}

	@Override public void visit( BinOpInst inst ) {
		System.err.println( "\t" + inst.toString() );
	}

	@Override public void visit( BrInst inst ) {
		System.err.println( "\t" + inst.toString() );
	}

	@Override public void visit( CallInst inst ) {
		System.err.println( "\t" + inst.toString() );
	}

	@Override public void visit( GetElemPtrInst inst ) {
		System.err.println( "\t" + inst.toString() );
	}

	@Override public void visit( IcmpInst inst ) {
		System.err.println( "\t" + inst.toString() );
	}

	@Override public void visit( LoadInst inst ) {
		System.err.println( "\t" + inst.toString() );
	}

	@Override public void visit( MoveInst inst ) {
		System.err.println( "\t" + inst.toString() );
	}

	@Override public void visit( RetInst inst ) {
		System.err.println( "\t" + inst.toString() );
	}

	@Override public void visit( StoreInst inst ) {
		System.err.println( "\t" + inst.toString() );
	}
}
