package org.zjl.jeddit.forum.application.commands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;

/**
 * @author Junlin Zhou
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatePostCommand {

    @Nullable
    @JsonProperty
    private String title;

    @Nullable
    @JsonProperty
    private String content;

}
