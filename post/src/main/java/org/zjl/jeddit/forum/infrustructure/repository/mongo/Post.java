package org.zjl.jeddit.forum.infrustructure.repository.mongo;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author Junlin Zhou
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Post {

    @Id
    private String id;

    private String authorId;

    //    private String replyToId;
    private Post replyTo;

    private String title;

    private String content;


    @Setter(AccessLevel.NONE)
    @CreatedDate
    private Date createTime;

    @Setter(AccessLevel.NONE)
    @LastModifiedDate
    private Date updateTime;

    @Version
    private Long version;


}
