package org.zjl.jeddit.forum.infrastructure.repository.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.zjl.jeddit.forum.domain.model.aggregates.Post;

import java.util.UUID;

/**
 * @author Junlin Zhou
 */
public interface PostMongoRepository extends ReactiveMongoRepository<Post, UUID> {
}
