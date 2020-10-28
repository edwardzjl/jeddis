package org.zjl.jeddit.forum.infrastructure.repository.mongo;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.zjl.jeddit.forum.domain.model.valueobjects.User;

import java.util.Date;
import java.util.UUID;

/**
 * @author Junlin Zhou
 */
@Deprecated
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Post {

    @Id
    private UUID id;

    private User author;

    private org.zjl.jeddit.forum.domain.model.valueobjects.Post replyTo;

    private String title;

    private String content;


    @Setter(AccessLevel.NONE)
    @CreatedDate
    private Date createTime;

    @Setter(AccessLevel.NONE)
    @LastModifiedDate
    private Date updateTime;

}
