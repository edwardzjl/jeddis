package org.zjl.jeddit.auth.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.zjl.jeddit.auth.domain.exception.InvalidPasswordException;

/**
 * @author Junlin Zhou
 */
@Value
@AllArgsConstructor
public class Password {

    // TODO: 2020/8/19 zjl read from config file, but not handled by spring?
    private static int MIN_LENGTH = 8;

    String password;

    boolean encrypted;

    /**
     * Extra rules may be added.
     */
    private static boolean isValid(String password) {
        return password.length() >= MIN_LENGTH;
    }

    public static Password construct(String password, boolean encrypted) {
        if (password == null) {
            throw new InvalidPasswordException();
        }
        // validation check for unencrypted passwords
        if (!encrypted && !isValid(password)) {
            throw new InvalidPasswordException();
        }
        return new Password(password, encrypted);
    }

}
