package org.zjl.jeddit.forum.domain.model.aggregates;

import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import org.zjl.jeddit.forum.infrastructure.mapper.PostMapper;
import org.zjl.jeddit.forum.infrastructure.repository.mongo.PostMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.springframework.data.relational.core.query.Criteria.where;

/**
 * @author Junlin Zhou
 */
@Component
public class PostRepository {

    private final PostMongoRepository postRepo;
    private final DatabaseClient databaseClient;

    public PostRepository(PostMongoRepository postRepo, PostMapper postMapper, DatabaseClient databaseClient) {
        this.postRepo = postRepo;
        this.databaseClient = databaseClient;
    }


    public Mono<Post> save(Post entity) {
        return postRepo.save(entity);
    }

    /**
     * @return Id of the newly created entity.
     */
    public Mono<String> createOnPostg(Post entity) {
        return databaseClient.insert()
                .into(Post.class)
                .using(entity)
                // return id of created post
                .map(row -> row.get("id", UUID.class))
                .one()
                .map(Object::toString);
    }

    public Mono<Integer> updateOnPostg(UUID id, Post entity) {
        return databaseClient.update()
                .table(Post.class)
                .using(entity)
                .matching(where("id").is(id))
                .fetch()
                .rowsUpdated();
    }

    public Mono<Post> findByIdOnMongo(UUID id) {
        return postRepo.findById(id);
    }

    public Mono<Post> findByIdOnPostg(UUID id) {
        return databaseClient.select()
                .from(Post.class)
                .matching(where("id").is(id))
                .as(Post.class)
                .one();
    }

    public Flux<Post> findAllInMongo() {
        return postRepo.findAll();
    }

    public Flux<Post> findAllInPostg() {
        return databaseClient.select()
                .from(Post.class)
                .fetch()
                .all();
    }

}
