package org.zjl.jeddit.forum.application;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.zjl.jeddit.forum.domain.model.aggregates.Post;
import org.zjl.jeddit.forum.domain.model.aggregates.PostRepository;
import reactor.core.publisher.Mono;

/**
 * @author Junlin Zhou
 */
@Component
@AllArgsConstructor
public class MongoQueryHandler {

    private final PostRepository postRepo;

    public Mono<ServerResponse> getTopics(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(postRepo.findAllInMongo(), Post.class);
    }

    public Mono<ServerResponse> getTopic(ServerRequest request) {
        return postRepo.findByIdOnMongo(request.pathVariable("id"))
                .flatMap(p -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_STREAM_JSON)
                        .body(BodyInserters.fromValue(p)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}