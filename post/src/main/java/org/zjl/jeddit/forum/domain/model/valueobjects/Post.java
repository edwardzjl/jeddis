package org.zjl.jeddit.forum.domain.model.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Used as a reference.
 *
 * @author Junlin Zhou
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {

    @Id
    PostId id;

    @JsonCreator
    public static Post of(Object id) {
        PostId _id = PostId.of(id);
        return new Post(_id);
    }

    @JsonIgnore
    public Long getLongId() {
        return id.getLongId();
    }

    @JsonIgnore
    public String getStringId() {
        return id.getStringId();
    }

}
