package org.zjl.jeddit.forum.application;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.zjl.jeddit.forum.domain.model.aggregates.Post;
import org.zjl.jeddit.forum.domain.model.aggregates.PostRepository;
import org.zjl.jeddit.forum.infrustructure.mapper.PostMapper;
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
        Mono<Post> post = request.bodyToMono(Post.class);
        return post.log()
                .map(postRepo::save)
                .then(ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_STREAM_JSON)
                        .body(BodyInserters.fromValue("creating topic")));
    }

    public Mono<ServerResponse> updatePost(ServerRequest request) {
        String postId = request.pathVariable("id");
        Mono<Post> newPost = request.bodyToMono(Post.class);
        return postRepo.findById(postId)
                .log()
                .zipWith(newPost, postMapper::update)
                .then(ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_STREAM_JSON)
                        .body(BodyInserters.fromValue("updating topic: " + postId)));
    }

}
