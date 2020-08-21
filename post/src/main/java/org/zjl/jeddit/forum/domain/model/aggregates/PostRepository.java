package org.zjl.jeddit.forum.domain.model.aggregates;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.zjl.jeddit.forum.infrustructure.mapper.PostMapper;
import org.zjl.jeddit.forum.infrustructure.repository.mongo.PostMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Junlin Zhou
 */
@AllArgsConstructor
@Component
public class PostRepository {

    private final PostMongoRepository postRepo;
    private final PostMapper postMapper;


    public Mono<Post> save(Post entity) {
        org.zjl.jeddit.forum.infrustructure.repository.mongo.Post mongoEntity = postMapper.modelToMongoEntity(entity);
        return postRepo.save(mongoEntity)
                .log()
                .map(postMapper::mongoEntityToModel);
    }

    public Mono<Post> findById(String id) {
        return postRepo.findById(id)
                .log()
                .map(postMapper::mongoEntityToModel);
    }

    public Flux<Post> findAll() {
        return postRepo.findAll()
                .log()
                .map(postMapper::mongoEntityToModel);
    }

}
