package org.zjl.jeddit.forum.infrastructure.spring.converter;

import org.springframework.core.convert.converter.Converter;
import org.zjl.jeddit.forum.domain.model.valueobjects.PostId;

/**
 * Construct a {@code PostId} by a {@code Long}.
 * <p>
 * Inverse Function of {@link PostIdConverter}, used when retrieving data from postgres.
 *
 * @author Junlin Zhou
 */
public class PostIdReverseConverter implements Converter<Long, PostId> {

    @Override
    public PostId convert(Long source) {
        return PostId.of(source);
    }
}
