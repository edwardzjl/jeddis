package org.zjl.jeddit.forum.application;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;
import org.zjl.jeddit.forum.application.commands.CreatePostCommand;
import org.zjl.jeddit.forum.application.commands.UpdatePostCommand;
import org.zjl.jeddit.forum.domain.model.aggregates.Post;
import org.zjl.jeddit.forum.domain.model.aggregates.PostRepository;
import org.zjl.jeddit.forum.infrastructure.mapper.PostMapper;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

/**
 * @author Junlin Zhou
 */
@Component
@AllArgsConstructor
public class PostgCommandHandler {

    private final PostRepository postRepo;
    private final PostMapper postMapper;

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(CreatePostCommand.class)
                .log()
                .map(postMapper::create)
                .map(postRepo::createOnPostg)
                .flatMap(postMono -> postMono)
                .flatMap(postId -> {
                    URI location = UriComponentsBuilder.fromUri(request.uri()).pathSegment(postId).build().toUri();
                    return ServerResponse.created(location)
                            .contentType(MediaType.APPLICATION_STREAM_JSON)
                            .bodyValue(location);
                });
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        UUID id = UUID.fromString(request.pathVariable("id"));
        return request.bodyToMono(UpdatePostCommand.class)
                .log()
                .zipWith(
                        postRepo.findByIdOnPostg(id),
                        postMapper::update
                ).map(post -> postRepo.updateOnPostg(id, post))
                .flatMap(post -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_STREAM_JSON)
                        .body(post, Post.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}
