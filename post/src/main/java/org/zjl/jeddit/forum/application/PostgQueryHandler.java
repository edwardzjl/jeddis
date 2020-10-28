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

import java.util.UUID;

/**
 * @author Junlin Zhou
 */
@Component
@AllArgsConstructor
public class PostgQueryHandler {

    private final PostRepository postRepo;

    public Mono<ServerResponse> getTopics(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(postRepo.findAllInPostg(), Post.class);
    }

    public Mono<ServerResponse> getTopic(ServerRequest request) {
        return postRepo.findByIdOnPostg(UUID.fromString(request.pathVariable("id")))
                .flatMap(p -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_STREAM_JSON)
                        .body(BodyInserters.fromValue(p)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
