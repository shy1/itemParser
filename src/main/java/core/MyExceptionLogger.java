package core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by syoung on 10/7/15.
 */
public class MyExceptionLogger extends Exception{
    private static Logger logger;
    private StringWriter trace;

    /**
     * constructor that calls the parent exception constructor and sets up a StringWriter and a logger
     * @param message - string that is the message the exception with display
     */
    public MyExceptionLogger(String message) {
        super(message);
        trace = new StringWriter();
        PrintWriter pw = new PrintWriter(trace);
        super.printStackTrace(pw);
        logger = Logger.getLogger("myLogger");
        logger.log(Level.SEVERE, trace.toString());
    }

    /**
     * constructor with no arguments that calls the argument taking constructor
     * sending a default message argument.
     */
    public MyExceptionLogger() {
        this("No message set.");
    }
}
