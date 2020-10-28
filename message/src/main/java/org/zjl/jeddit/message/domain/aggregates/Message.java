package org.zjl.jeddit.message.domain.aggregates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zjl.jeddit.message.domain.valueobjects.User;

import java.util.Date;

/**
 * @author Junlin Zhou
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {

    @JsonProperty
    private String id;

    private User from;

    private User to;

    private String title;

    private String content;

    private Date sendTime;


}
