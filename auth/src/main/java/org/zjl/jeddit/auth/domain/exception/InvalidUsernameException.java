package org.zjl.jeddit.auth.domain.exception;

/**
 * @author Junlin Zhou
 */
// TODO: 2020/8/19 zjl choose a better base class
public class InvalidUsernameException extends RuntimeException{

    public InvalidUsernameException() {
        super();
    }

    public InvalidUsernameException(String message) {
        super(message);
    }

    public InvalidUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUsernameException(Throwable cause) {
        super(cause);
    }

    protected InvalidUsernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
