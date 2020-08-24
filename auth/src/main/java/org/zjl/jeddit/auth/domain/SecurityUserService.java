package org.zjl.jeddit.auth.domain;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.zjl.jeddit.auth.infrastructure.mapper.SecurityUserMapper;
import org.zjl.jeddit.auth.infrastructure.repository.mongo.SecurityUserMongoRepository;
import reactor.core.publisher.Mono;

/**
 * @author Junlin Zhou
 */
@Service
public class SecurityUserService implements ReactiveUserDetailsService {

    private final SecurityUserMongoRepository userRepo;
    private final SecurityUserMapper mapper;

    public SecurityUserService(SecurityUserMongoRepository userRepo, SecurityUserMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    /**
     * @param username openId from wechat
     */
//    @Override
//    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
//        return securityUserRepo.findByUsername(username)
//                .map(mapper::entityToModel)
//                .orElseThrow(() -> new UsernameNotFoundException("No such user for name: " + username));
//        if (!securityUser.isEnabled()) {
//            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
//        } else if (!securityUser.isAccountNonLocked()) {
//            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
//        } else if (!securityUser.isAccountNonExpired()) {
//            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
//        } else if (!securityUser.isCredentialsNonExpired()) {
//            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
//        }
//    }
    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepo.findByUsername(username)
                .map(mapper::mongoEntityToModel);
    }
}
