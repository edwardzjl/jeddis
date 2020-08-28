package org.zjl.jeddit.forum.infrastructure.spring.converter;

import org.springframework.core.convert.converter.Converter;
import org.zjl.jeddit.forum.domain.model.valueobjects.Post;

/**
 * @author Junlin Zhou
 */
public class PostReverseConverter implements Converter<Long, Post> {
    @Override
    public Post convert(Long source) {
        return Post.of(source);
    }
}
