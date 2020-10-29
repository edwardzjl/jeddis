package org.zjl.jeddit.forum.domain.model.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

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

    UUID id;

    @JsonCreator
    public static Post of(UUID id) {
        return new Post(id);
    }

}
