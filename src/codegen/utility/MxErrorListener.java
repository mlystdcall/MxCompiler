package utility;

import utility.syntaxError;
import utility.position;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class MxErrorListener extends BaseErrorListener {
	@Override
	public void syntaxError( Recognizer<?,?> recognizer,
							 Object offendingSymbol,
							 int line,
							 int col,
							 String msg,
							 RecognitionException e) {
		throw new syntaxError(msg, new position(line, col));
	}
}
