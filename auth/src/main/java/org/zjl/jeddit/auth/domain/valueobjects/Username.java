package org.zjl.jeddit.auth.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.zjl.jeddit.auth.domain.exception.InvalidUsernameException;

/**
 * @author Junlin Zhou
 */
@Value
@AllArgsConstructor
public class Username {

    // TODO: 2020/8/19 zjl read from config file, but not handled by spring?
    private static int MAX_LENGTH = 15;

    // TODO: 2020/8/19 zjl read from config file, but not handled by spring?
    private static int MIN_LENGTH = 4;

    String username;


    /**
     * Extra rules may be added.
     */
    private static boolean isValid(String username) {
        return username.length() >= MIN_LENGTH && username.length() <= MAX_LENGTH;
    }

    public static Username construct(String username) {
        if (username == null) {
            throw new InvalidUsernameException();
        }
        if (!isValid(username)) {
            throw new InvalidUsernameException();
        }
        return new Username(username);
    }
}
