package org.zjl.jeddit.forum.infrustructure.repository.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author Junlin Zhou
 */
public interface PostMongoRepository extends ReactiveMongoRepository<Post, String> {
}
