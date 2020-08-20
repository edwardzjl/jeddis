package org.zjl.jeddit.forum.application.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.zjl.jeddit.forum.application.ForumCommandHandler;
import org.zjl.jeddit.forum.application.ForumQueryHandler;

/**
 * @author Junlin Zhou
 */
@Configuration
public class ForumRouter {

    @Bean
    public RouterFunction<ServerResponse> commandRoute(ForumCommandHandler commandHandler) {
        return RouterFunctions
                .route(RequestPredicates.POST("/").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), commandHandler::createPost)
                .andRoute(RequestPredicates.PUT("/{id}").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), commandHandler::updatePost);
    }

    @Bean
    public RouterFunction<ServerResponse> queryRoute(ForumQueryHandler queryHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), queryHandler::getTopics)
                .andRoute(RequestPredicates.GET("/{id}").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), queryHandler::getTopic);
    }
}
