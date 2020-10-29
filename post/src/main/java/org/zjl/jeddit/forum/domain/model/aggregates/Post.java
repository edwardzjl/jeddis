package org.zjl.jeddit.forum.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.zjl.jeddit.forum.domain.model.valueobjects.User;

import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Junlin Zhou
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @JsonProperty
    private UUID id;

    @JsonProperty
    private User author;

    @Nullable
    @JsonProperty
    private org.zjl.jeddit.forum.domain.model.valueobjects.Post replyTo;

    @JsonProperty
    private String title;

    @JsonProperty
    private String content;

    // r2dbc auditing not working now
    @Setter(AccessLevel.NONE)
//    @CreatedDate
    private LocalDateTime createTime;
    @Setter(AccessLevel.NONE)
//    @LastModifiedDate
    private LocalDateTime updateTime;

    @Builder
    public Post(User author, @Nullable org.zjl.jeddit.forum.domain.model.valueobjects.Post replyTo, String title, String content) {
        this.id = UUID.randomUUID();
        this.author = author;
        this.replyTo = replyTo;
        this.title = title;
        this.content = content;
        var _createTime = LocalDateTime.now();
        this.createTime = _createTime;
        this.updateTime = _createTime;
    }

}
