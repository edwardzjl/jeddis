package org.zjl.jeddit.user.domain.exceptions;

/**
 * @author Junlin Zhou
 */
// TODO: 2020/8/19 zjl choose a better base class
public class InvalidIdCardException extends RuntimeException {

    public InvalidIdCardException() {
        super();
    }

    public InvalidIdCardException(String message) {
        super(message);
    }


    public InvalidIdCardException(String message, Throwable cause) {
        super(message, cause);
    }


    public InvalidIdCardException(Throwable cause) {
        super(cause);
    }

    protected InvalidIdCardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
