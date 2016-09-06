package kr.huny.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sousic on 2016. 9. 6..
 */
public class LogException extends Exception {
    private static final Logger logger = LoggerFactory.getLogger(LogException.class);

    public LogException() {
        super();
    }

    public LogException(String message) {
        super(message);
    }

    public LogException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogException(Throwable cause)
    {
        super(cause);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        logger.error(super.getStackTrace().toString());
    }
}
