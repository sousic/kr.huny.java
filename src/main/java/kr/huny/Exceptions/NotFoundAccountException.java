package kr.huny.Exceptions;

/**
 * Created by sousic on 2016-11-09.
 */
public class NotFoundAccountException extends RuntimeException {
    public NotFoundAccountException(String message) {
        super(message);
    }
}
