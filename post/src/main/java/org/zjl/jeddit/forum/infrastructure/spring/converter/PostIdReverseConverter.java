package org.zjl.jeddit.forum.infrastructure.spring.converter;

import org.springframework.core.convert.converter.Converter;
import org.zjl.jeddit.forum.domain.model.valueobjects.PostId;

/**
 * @author Junlin Zhou
 */
public class PostIdReverseConverter implements Converter<Long, PostId> {

    @Override
    public PostId convert(Long source) {
        return PostId.of(source);
    }
}
