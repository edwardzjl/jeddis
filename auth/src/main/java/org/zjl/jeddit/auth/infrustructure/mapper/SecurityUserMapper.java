package org.zjl.jeddit.auth.infrustructure.mapper;

import org.mapstruct.Mapper;
import org.zjl.jeddit.auth.domain.aggregates.SecurityUser;
import org.zjl.jeddit.auth.domain.valueobjects.Password;
import org.zjl.jeddit.auth.domain.valueobjects.Username;
import org.zjl.jeddit.auth.infrustructure.repository.jpa.SecurityUserEntity;

/**
 * @author Junlin Zhou
 */
@Mapper(componentModel = "spring")
public interface SecurityUserMapper {


    SecurityUser entityToModel(SecurityUserEntity entity);

    default Username usernameConverter(String username) {
        return Username.construct(username);
    }

    default Password passwordConverter(String password) {
        return Password.construct(password, true);
    }
}
