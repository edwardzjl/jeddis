package org.zjl.jeddit.forum.infrastructure.repository.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author Junlin Zhou
 */
public interface PostMongoRepository extends ReactiveMongoRepository<Post, String> {
}
