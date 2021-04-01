package utility;

import utility.position;

public class syntaxError extends error {
	public syntaxError( String msg, position pos ) {
		super("Syntax Error: " + msg, pos);
	}
}
