package org.zjl.jeddit.forum.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.zjl.jeddit.forum.domain.model.valueobjects.PostId;
import org.zjl.jeddit.forum.domain.model.valueobjects.User;

/**
 * @author Junlin Zhou
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @JsonProperty
    private PostId id;

    @JsonProperty
    private User author;

    @JsonProperty
    private org.zjl.jeddit.forum.domain.model.valueobjects.Post replyTo;

    @JsonProperty
    private String title;

    @JsonProperty
    private String content;

    /*
    TODO: 2020/8/26 zjl replace NoArgsConstructor and AllArgsConstructor with this specific constructor
    support for parametrized constructor is not supported in current version (1.3.1), and will be supported in 1.4.0
    See https://github.com/mapstruct/mapstruct/issues/73
    Once updated, omit the NoArgsConstructor, and use following constructor
    */

//    public Post(User author, Post replyTo, String title, String content) {
//        this(null, author, replyTo, title, content);
//    }

}
