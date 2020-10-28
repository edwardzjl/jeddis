package org.zjl.jeddit.forum.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.zjl.jeddit.forum.domain.model.valueobjects.User;

import javax.annotation.Nullable;
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

    @Builder
    public Post(User author, org.zjl.jeddit.forum.domain.model.valueobjects.Post replyTo, String title, String content) {
        this(UUID.randomUUID(), author, replyTo, title, content);
    }

}
