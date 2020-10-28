package org.zjl.jeddit.forum.application.commands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zjl.jeddit.forum.domain.model.valueobjects.Post;
import org.zjl.jeddit.forum.domain.model.valueobjects.User;

import javax.annotation.Nullable;

/**
 * @author Junlin Zhou
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePostCommand {

    @JsonProperty
    private User author;

    @Nullable
    @JsonProperty
    private Post replyTo;

    @JsonProperty
    private String title;

    @JsonProperty
    private String content;

}
