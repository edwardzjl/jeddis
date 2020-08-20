package org.zjl.jeddit.auth.infrustructure.repository.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * @author Junlin Zhou
 */
public interface SecurityUserMongoRepository extends ReactiveMongoRepository<SecurityUser, String> {

    Mono<SecurityUser> findByUsername(String username);

}
