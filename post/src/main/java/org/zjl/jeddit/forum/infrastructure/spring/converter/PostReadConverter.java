package org.zjl.jeddit.forum.infrastructure.spring.converter;

import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.zjl.jeddit.forum.domain.model.aggregates.Post;
import org.zjl.jeddit.forum.domain.model.valueobjects.PostId;
import org.zjl.jeddit.forum.domain.model.valueobjects.User;

/**
 * @author Junlin Zhou
 */
@ReadingConverter
public class PostReadConverter implements Converter<Row, Post> {

    @Override
    public Post convert(Row source) {
        Long postId = source.get("id", Long.class);
        PostId id = PostId.of(postId);

        Long authorId = source.get("author", Long.class);
        User author = null;
        if (authorId != null) {
            author = User.of(authorId);
        }

        Long replyToId = source.get("reply_to", Long.class);
        org.zjl.jeddit.forum.domain.model.valueobjects.Post replyTo = null;
        if (replyToId != null) {
            replyTo = org.zjl.jeddit.forum.domain.model.valueobjects.Post.of(replyToId);
        }

        String title = source.get("title", String.class);

        String content = source.get("content", String.class);

        return new Post(id, author, replyTo, title, content);
    }
}
