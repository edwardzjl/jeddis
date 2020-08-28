package org.zjl.jeddit.forum.infrastructure.spring.converter;

import org.springframework.core.convert.converter.Converter;
import org.zjl.jeddit.forum.domain.model.valueobjects.Post;

/**
 * Construct a Post value object (reply) from a {@code Long}.
 * <p>
 * Inverse Function of {@link PostConverter}, used when retrieving data from postgres.
 *
 * @author Junlin Zhou
 */
public class PostReverseConverter implements Converter<Long, Post> {
    @Override
    public Post convert(Long source) {
        return Post.of(source);
    }
}
