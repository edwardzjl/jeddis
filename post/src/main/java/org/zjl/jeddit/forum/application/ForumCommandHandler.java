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

/**
 * @author Junlin Zhou
 */
@AllArgsConstructor
@Component
public class ForumCommandHandler {

    private final PostRepository postRepo;
    private final PostMapper postMapper;

    public Mono<ServerResponse> createPostOnMongo(ServerRequest request) {
        return request.bodyToMono(CreatePostCommand.class)
                .log()
                .map(postMapper::create)
                .map(postRepo::save)
                .flatMap(monoPost -> monoPost)
                .flatMap(post -> {
                    URI location = UriComponentsBuilder
                            .fromUri(request.uri())
                            .pathSegment(post.getId().getStringId())
                            .build()
                            .toUri();
                    return ServerResponse.created(location)
                            .contentType(MediaType.APPLICATION_STREAM_JSON)
                            .bodyValue(post);
                });
    }

    public Mono<ServerResponse> createPostOnPostg(ServerRequest request) {
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

    public Mono<ServerResponse> updatePostOnMongo(ServerRequest request) {
        return request.bodyToMono(UpdatePostCommand.class)
                .log()
                .zipWith(
                        postRepo.findByIdOnMongo(request.pathVariable("id")),
                        postMapper::update
                ).map(postRepo::save)
                .flatMap(post -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_STREAM_JSON)
                        .body(post, Post.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> updateOnPostg(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        return request.bodyToMono(UpdatePostCommand.class)
                .map(postMapper::update)
                .map(entity -> postRepo.updateOnPostg(id, entity))
                .flatMap(rowsUpdated -> rowsUpdated)
                .flatMap(rowsUpdated -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_STREAM_JSON)
                        .bodyValue(rowsUpdated))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}
