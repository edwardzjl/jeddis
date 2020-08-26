package org.zjl.jeddit.forum.application.commands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Junlin Zhou
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatePostCommand {

    @JsonProperty
    private String title;

    @JsonProperty
    private String content;

}
