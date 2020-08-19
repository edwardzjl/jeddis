package org.zjl.jeddit.user.domain.exceptions;

/**
 * @author Junlin Zhou
 */
// TODO: 2020/8/19 zjl choose a better base class
public class InvalidEmailException extends RuntimeException {

    public InvalidEmailException() {
        super();
    }

    public InvalidEmailException(String message) {
        super(message);
    }


    public InvalidEmailException(String message, Throwable cause) {
        super(message, cause);
    }


    public InvalidEmailException(Throwable cause) {
        super(cause);
    }

    protected InvalidEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
