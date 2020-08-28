package org.zjl.jeddit.forum.infrastructure.spring.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.data.r2dbc.mapping.SettableValue;
import org.zjl.jeddit.forum.domain.model.aggregates.Post;

/**
 * @author Junlin Zhou
 */
@WritingConverter
public class PostWriteConverter implements Converter<Post, OutboundRow> {

    @Override
    public OutboundRow convert(Post source) {
        OutboundRow row = new OutboundRow();
        if (source.getId() != null) {
            row.put("id", SettableValue.fromOrEmpty(source.getId().getLongId(), Long.class));
        }
        row.put("author", SettableValue.fromOrEmpty(source.getAuthor().getId(), Long.class));
        if (source.getReplyTo() != null) {
            row.put("reply_to", SettableValue.fromOrEmpty(source.getReplyTo().getLongId(), Long.class));
        }
        row.put("title", SettableValue.from(source.getTitle()));
        row.put("content", SettableValue.from(source.getContent()));
        return row;
    }
}
