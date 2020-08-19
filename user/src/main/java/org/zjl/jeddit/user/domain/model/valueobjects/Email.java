package org.zjl.jeddit.user.domain.model.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.zjl.jeddit.user.domain.exceptions.InvalidEmailException;

/**
 * @author Junlin Zhou
 */
@Value
@AllArgsConstructor
public class Email {

    // TODO: 2020/8/19 zjl read from config file, but not handled by spring?
    private static int LENGTH = 8;

    String email;

    /**
     * Extra rules may be added.
     */
    // TODO: 2020/8/19 zjl rule
    private static boolean isValid(String email) {
        return email.length() == LENGTH;
    }

    public static Email construct(String email) {
        if (email == null) {
            throw new InvalidEmailException();
        }
        if (!isValid(email)) {
            throw new InvalidEmailException();
        }
        return new Email(email);
    }

}
