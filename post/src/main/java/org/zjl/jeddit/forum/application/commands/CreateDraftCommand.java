package org.zjl.jeddit.forum.application.commands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zjl.jeddit.forum.domain.model.valueobjects.Post;
import org.zjl.jeddit.forum.domain.model.valueobjects.User;

import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * Command used to create a draft
 * Not extending {@link CreatePostCommand} because they might not have a relation
 *
 * @author Junlin Zhou
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateDraftCommand {

    @JsonProperty
    private User author;

    @JsonProperty
    private Post replyTo;

    @JsonProperty
    private String title;

    @JsonProperty
    private String content;

    @Nullable
    @JsonProperty
    LocalDateTime plannedDate;

}
