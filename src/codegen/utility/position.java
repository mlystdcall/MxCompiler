package utility;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public class position {
	public int row, col;
	
	public position( int row, int col ) {
		this.row = row;
		this.col = col;
	}
	
	public position( Token token ) {
		this.row = token.getLine();
		this.col = token.getCharPositionInLine();
	}

	public position( TerminalNode terminal ) {
		this(terminal.getSymbol());
	}
	
	public position( ParserRuleContext ctx ) {
		this(ctx.getStart());
	}

	public String toString() {
		return row + "," + col;
	}
}
