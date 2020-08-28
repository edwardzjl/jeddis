package org.zjl.jeddit.forum.infrastructure.spring.converter;

import org.springframework.core.convert.converter.Converter;
import org.zjl.jeddit.forum.domain.model.valueobjects.PostId;

/**
 * Convert a {@code PostId} to {@code Long}.
 * <p>
 * We are using multiple persistence infrastructure (Postgres and Mongodb),
 * and they require different data types for id to auto-generate.
 * (Postgres requires {@code Number} meanwhile Mongodb requires {@code String})
 *
 * @author Junlin Zhou
 */
public class PostIdConverter implements Converter<PostId, Long> {

    @Override
    public Long convert(PostId source) {
        return source.getLongId();
    }
}
