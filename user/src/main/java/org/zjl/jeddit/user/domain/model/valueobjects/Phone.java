package org.zjl.jeddit.user.domain.model.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.zjl.jeddit.user.domain.exceptions.InvalidPhoneException;

/**
 * @author Junlin Zhou
 */
@Value
@AllArgsConstructor
public class Phone {

    // TODO: 2020/8/19 zjl read from config file, but not handled by spring?
    private static int LENGTH = 11;

    String phone;

    /**
     * Extra rules may be added.
     */
    private static boolean isValid(String phone) {
        return phone.length() == LENGTH;
    }

    public static Phone construct(String phone) {
        if (phone == null) {
            throw new InvalidPhoneException();
        }
        if (!isValid(phone)) {
            throw new InvalidPhoneException();
        }
        return new Phone(phone);
    }
}
