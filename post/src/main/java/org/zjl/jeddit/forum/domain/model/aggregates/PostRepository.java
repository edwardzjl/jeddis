package org.zjl.jeddit.forum.domain.model.aggregates;

import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import org.zjl.jeddit.forum.infrastructure.mapper.PostMapper;
import org.zjl.jeddit.forum.infrastructure.repository.mongo.PostMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.r2dbc.query.Criteria.where;

/**
 * @author Junlin Zhou
 */
@AllArgsConstructor
@Component
public class PostRepository {

    private final PostMongoRepository postRepo;
    private final PostMapper postMapper;
    private final DatabaseClient databaseClient;


    public Mono<Post> save(Post entity) {
        org.zjl.jeddit.forum.infrastructure.repository.mongo.Post mongoEntity = postMapper.modelToMongoEntity(entity);
        return postRepo.save(mongoEntity)
                .log()
                .map(postMapper::mongoEntityToModel);
    }

    /**
     * @return Id of the newly created entity.
     */
    public Mono<String> createOnPostg(Post entity) {
        return databaseClient.insert()
                .into(Post.class)
                .using(entity)
                .map(row -> row.get("id", Long.class))
                .one()
                .map(Object::toString);
    }

    public Mono<Integer> updateOnPostg(Long id, Post entity) {
        entity.setId(id);
        return databaseClient.update()
                .table(Post.class)
                .using(entity)
                .matching(where("id").is(id))
                .fetch()
                .rowsUpdated();
    }

    public Mono<Post> findByIdOnMongo(String id) {
        return postRepo.findById(id)
                .log()
                .map(postMapper::mongoEntityToModel);
    }

    public Mono<Post> findByIdOnPostg(Long id) {
        return databaseClient.select()
                .from(Post.class)
                .matching(where("id").is(id))
                .as(Post.class)
                .one();
    }

    public Flux<Post> findAllInMongo() {
        return postRepo.findAll()
                .log()
                .map(postMapper::mongoEntityToModel);
    }

    public Flux<Post> findAllInPostg() {
        return databaseClient.select()
                .from(Post.class)
                .fetch()
                .all();
    }

}
