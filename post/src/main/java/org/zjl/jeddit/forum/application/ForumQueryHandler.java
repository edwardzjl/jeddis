package org.zjl.jeddit.forum.application;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.zjl.jeddit.forum.domain.model.aggregates.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Junlin Zhou
 */
@Component
public class ForumQueryHandler {

    public Mono<ServerResponse> getTopics(ServerRequest request) {
        Flux<Post> topics;
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("get all topics"));
    }

    public Mono<ServerResponse> getTopic(ServerRequest request) {
        int topicId = Integer.parseInt(request.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("get topic: " + topicId));
    }
}
