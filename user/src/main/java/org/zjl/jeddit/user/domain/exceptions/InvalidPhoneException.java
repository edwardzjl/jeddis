package org.zjl.jeddit.user.domain.exceptions;

/**
 * @author Junlin Zhou
 */
// TODO: 2020/8/19 zjl choose a better base class
public class InvalidPhoneException extends RuntimeException {

    public InvalidPhoneException() {
        super();
    }

    public InvalidPhoneException(String message) {
        super(message);
    }


    public InvalidPhoneException(String message, Throwable cause) {
        super(message, cause);
    }


    public InvalidPhoneException(Throwable cause) {
        super(cause);
    }

    protected InvalidPhoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
