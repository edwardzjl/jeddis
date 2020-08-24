package org.zjl.jeddit.auth.infrastructure.repository.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Junlin Zhou
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "security_user",
        indexes = {@Index(name = "username", columnList = "username")})
public class SecurityUserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "locked")
    private boolean locked;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "account_expired")
    private boolean accountExpired;

    @Column(name = "credential_expired")
    private boolean credentialExpired;

}
