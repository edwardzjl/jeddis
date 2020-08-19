package org.zjl.jeddit.auth.domain.exception;

/**
 * @author Junlin Zhou
 */
// TODO: 2020/8/19 zjl choose a better base class
public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException() {
        super();
    }

    public InvalidPasswordException(String message) {
        super(message);
    }

    public InvalidPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPasswordException(Throwable cause) {
        super(cause);
    }

    protected InvalidPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
