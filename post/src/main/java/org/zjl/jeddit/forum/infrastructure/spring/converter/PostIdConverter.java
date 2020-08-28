package org.zjl.jeddit.forum.infrastructure.spring.converter;

import org.springframework.core.convert.converter.Converter;
import org.zjl.jeddit.forum.domain.model.valueobjects.PostId;

/**
 * @author Junlin Zhou
 */
public class PostIdConverter implements Converter<PostId, Long> {

    @Override
    public Long convert(PostId source) {
        return source.getLongId();
    }
}
