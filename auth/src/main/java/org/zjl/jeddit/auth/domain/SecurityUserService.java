package org.zjl.jeddit.auth.domain;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zjl.jeddit.auth.domain.aggregates.SecurityUser;
import org.zjl.jeddit.auth.infrustructure.mapper.SecurityUserMapper;
import org.zjl.jeddit.auth.infrustructure.repository.jpa.SecurityUserRepository;

/**
 * @author Junlin Zhou
 */
@Service
public class SecurityUserService implements UserDetailsService {

    private final SecurityUserRepository securityUserRepo;
    private final SecurityUserMapper mapper;

    public SecurityUserService(SecurityUserRepository securityUserRepo, SecurityUserMapper mapper) {
        this.securityUserRepo = securityUserRepo;
        this.mapper = mapper;
    }


    /**
     * @param username openId from wechat
     */
    @Override
    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return securityUserRepo.findByUsername(username)
                .map(mapper::entityToModel)
                .orElseThrow(() -> new UsernameNotFoundException("No such user for name: " + username));
//        if (!securityUser.isEnabled()) {
//            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
//        } else if (!securityUser.isAccountNonLocked()) {
//            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
//        } else if (!securityUser.isAccountNonExpired()) {
//            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
//        } else if (!securityUser.isCredentialsNonExpired()) {
//            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
//        }
    }

}
