package org.zjl.jeddit.auth.infrustructure.repository.mongo;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author Junlin Zhou
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class SecurityUser {

    @Id
    private String id;

    @Indexed
    private String username;

    private String password;

    private boolean locked;

    private Boolean enabled;

    private boolean accountExpired;

    private boolean credentialExpired;


    @Setter(AccessLevel.NONE)
    @CreatedDate
    private Date createTime;

    @Setter(AccessLevel.NONE)
    @LastModifiedDate
    private Date updateTime;

    @Version
    private Long version;

}
