import ast.RootNode;
import main.ASTBuilder;
import main.SemanticChecker;
import parser.MxLexer;
import parser.MxParser;
import utility.MxErrorListener;
import utility.error;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ir.IRBuilder;

import java.io.FileInputStream;
import java.io.InputStream;

public class Codegen {
	public static void main( String[] args ) throws Exception {
		// String name = args[0];
		InputStream input = System.in;
		try {
			RootNode ASTRoot;
			MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
			lexer.removeErrorListeners();
			lexer.addErrorListener(new MxErrorListener());
			MxParser parser = new MxParser(new CommonTokenStream(lexer));
			parser.removeErrorListeners();
			parser.addErrorListener(new MxErrorListener());
			ParseTree parseTreeRoot = parser.program();
			ASTBuilder astBuilder = new ASTBuilder();
			ASTRoot = (RootNode)astBuilder.visit(parseTreeRoot);
			(new SemanticChecker()).visit(ASTRoot);
			
			IRBuilder irbuilder = new IRBuilder();
			irbuilder.visit(ASTRoot);
			
		} catch(error er) {
			System.err.println(er.toString());
			throw new RuntimeException();
		}
	}
}
