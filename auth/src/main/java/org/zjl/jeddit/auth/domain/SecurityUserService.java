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
    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepo.findByUsername(username)
                .map(mapper::mongoEntityToModel);
    }
}
