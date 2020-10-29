package org.zjl.jeddit.forum.infrastructure.spring.converter;

import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.zjl.jeddit.forum.domain.model.aggregates.Post;
import org.zjl.jeddit.forum.domain.model.valueobjects.User;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Junlin Zhou
 */
@ReadingConverter
public class PostReadConverter implements Converter<Row, Post> {

    @Override
    public Post convert(Row source) {
        UUID id = source.get("id", UUID.class);

        UUID authorId = source.get("author", UUID.class);
        User author = null;
        if (authorId != null) {
            author = User.of(authorId);
        }

        UUID replyToId = source.get("reply_to", UUID.class);
        org.zjl.jeddit.forum.domain.model.valueobjects.Post replyTo = null;
        if (replyToId != null) {
            replyTo = org.zjl.jeddit.forum.domain.model.valueobjects.Post.of(replyToId);
        }

        String title = source.get("title", String.class);
        String content = source.get("content", String.class);

        LocalDateTime createTime = source.get("create_time", LocalDateTime.class);
        LocalDateTime updateTime = source.get("update_time", LocalDateTime.class);

        return new Post(id, author, replyTo, title, content, createTime, updateTime);
    }
}
