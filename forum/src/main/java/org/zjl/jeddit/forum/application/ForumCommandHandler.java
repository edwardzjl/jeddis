package org.zjl.jeddit.forum.application;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author Junlin Zhou
 */
@Component
public class ForumCommandHandler {

    public Mono<ServerResponse> createTopic(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("creating topic"));
    }

    public Mono<ServerResponse> updateTopic(ServerRequest request) {
        int topicId = Integer.parseInt(request.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("updating topic: " + topicId));
    }
}
