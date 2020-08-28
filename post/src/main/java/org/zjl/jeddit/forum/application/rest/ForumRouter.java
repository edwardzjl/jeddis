package org.zjl.jeddit.forum.application.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.zjl.jeddit.forum.application.ForumCommandHandler;
import org.zjl.jeddit.forum.application.ForumQueryHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;

/**
 * @author Junlin Zhou
 */
@Configuration
public class ForumRouter {

    @Bean
    public RouterFunction<ServerResponse> mongoQueryRoute(ForumQueryHandler queryHandler) {
        return RouterFunctions
                .nest(path("/api/posts/mongo"),
                        RouterFunctions
                                .route(RequestPredicates.GET("/"), queryHandler::getTopicsOnMongo)
                                .andRoute(RequestPredicates.GET("/{id}"), queryHandler::getTopicOnMongo));
    }

    @Bean
    public RouterFunction<ServerResponse> postgQueryRoute(ForumQueryHandler queryHandler) {
        return RouterFunctions
                .nest(path("/api/posts/postg"),
                        RouterFunctions
                                .route(RequestPredicates.GET("/"), queryHandler::getTopicsOnPostg)
                                .andRoute(RequestPredicates.GET("/{id}"), queryHandler::getTopicOnPostg));
    }

    @Bean
    public RouterFunction<ServerResponse> mongoCommandRoute(ForumCommandHandler commandHandler) {
        return RouterFunctions
                .nest(path("/api/posts/mongo"),
                        RouterFunctions
                                .route(RequestPredicates.POST("/"), commandHandler::createPostOnMongo)
                                .andRoute(RequestPredicates.PUT("/{id}"), commandHandler::updatePostOnMongo));
    }

    @Bean
    public RouterFunction<ServerResponse> postgCommandRoute(ForumCommandHandler commandHandler) {
        return RouterFunctions
                .nest(path("/api/posts/postg"),
                        RouterFunctions
                                .route(RequestPredicates.POST("/"), commandHandler::createPostOnPostg)
                                .andRoute(RequestPredicates.PUT("/{id}"), commandHandler::updateOnPostg));
    }

}
