package utility;

import utility.position;

public class semanticError extends error {
	public semanticError( String msg, position pos ) {
		super( "Semantic Error: " + msg, pos );
	}
}
