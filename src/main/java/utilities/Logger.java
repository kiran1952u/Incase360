package utilities;

import org.apache.log4j.LogManager;

public class Logger {

    private static final org.apache.log4j.Logger logger = LogManager.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.debug("This sdfsd a debug message");
        logger.info("This is an info message");
        logger.warn("This is asdfsd warning message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
    }
}
