package org.zjl.jeddit.forum.application;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.zjl.jeddit.forum.domain.model.aggregates.Post;
import org.zjl.jeddit.forum.domain.model.aggregates.PostRepository;
import org.zjl.jeddit.forum.infrastructure.mapper.PostMapper;
import reactor.core.publisher.Mono;

/**
 * @author Junlin Zhou
 */
@AllArgsConstructor
@Component
public class ForumCommandHandler {

    private final PostRepository postRepo;
    private final PostMapper postMapper;

    public Mono<ServerResponse> createPost(ServerRequest request) {
        return request.bodyToMono(Post.class)
                .log()
                .map(postRepo::save)
                .flatMap(post -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_STREAM_JSON)
                        .body(post, Post.class));
    }

    public Mono<ServerResponse> updatePost(ServerRequest request) {
        return request.bodyToMono(Post.class)
                .log()
                .zipWith(
                        postRepo.findById(request.pathVariable("id")),
                        postMapper::update
                ).map(postRepo::save)
                .flatMap(post -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_STREAM_JSON)
                        .body(post, Post.class));
    }

}
