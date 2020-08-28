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
public class ForumQueryHandler {

    private final PostRepository postRepo;

    public Mono<ServerResponse> getTopicsOnMongo(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(postRepo.findAllInMongo(), Post.class);
    }

    public Mono<ServerResponse> getTopicsOnPostg(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(postRepo.findAllInPostg(), Post.class);
    }

    public Mono<ServerResponse> getTopicOnMongo(ServerRequest request) {
        return postRepo.findByIdOnMongo(request.pathVariable("id"))
                .flatMap(p -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_STREAM_JSON)
                        .body(BodyInserters.fromValue(p)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getTopicOnPostg(ServerRequest request) {
        return postRepo.findByIdOnPostg(Long.valueOf(request.pathVariable("id")))
                .flatMap(p -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_STREAM_JSON)
                        .body(BodyInserters.fromValue(p)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
