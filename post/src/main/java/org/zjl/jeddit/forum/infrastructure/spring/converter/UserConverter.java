package org.zjl.jeddit.forum.infrastructure.spring.converter;

import org.springframework.core.convert.converter.Converter;
import org.zjl.jeddit.forum.domain.model.valueobjects.User;

/**
 * R2dbc does not support nested objects (as expected), so we have to convert them before persist.
 *
 * @author Junlin Zhou
 */
public class UserConverter implements Converter<User, Long> {

    @Override
    public Long convert(User source) {
        return source.getId();
    }
}
