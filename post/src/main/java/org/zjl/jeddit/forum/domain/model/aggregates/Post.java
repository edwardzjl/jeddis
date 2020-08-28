package org.zjl.jeddit.forum.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * @author Junlin Zhou
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {

    @Id
    @JsonProperty
    private Object id;

//    @JsonProperty
//    private User author;

//    @JsonProperty
//    private Post replyTo;

    @JsonProperty
    private String title;

    @JsonProperty
    private String content;

    // TODO: 2020/8/26 zjl support for parametrized constructor is not supported in current version (1.3.1)
    // and will be supported in 1.4.0
    // See https://github.com/mapstruct/mapstruct/issues/73
    // Once updated, omit the NoArgsConstructor, and use following constructor

//    public Post(User author, Post replyTo, String title, String content) {
//        this(null, author, replyTo, title, content);
//    }

}
