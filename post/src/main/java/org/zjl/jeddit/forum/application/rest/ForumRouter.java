package org.zjl.jeddit.forum.application.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.zjl.jeddit.forum.application.MongoCommandHandler;
import org.zjl.jeddit.forum.application.MongoQueryHandler;
import org.zjl.jeddit.forum.application.PostgCommandHandler;
import org.zjl.jeddit.forum.application.PostgQueryHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;

/**
 * @author Junlin Zhou
 */
@Configuration
public class ForumRouter {

    @Bean
    public RouterFunction<ServerResponse> mongoQueryRoute(MongoQueryHandler queryHandler) {
        return RouterFunctions
                .nest(path("/api/posts/mongo"),
                        RouterFunctions
                                .route(RequestPredicates.GET("/"), queryHandler::getTopics)
                                .andRoute(RequestPredicates.GET("/{id}"), queryHandler::getTopic));
    }

    @Bean
    public RouterFunction<ServerResponse> postgQueryRoute(PostgQueryHandler queryHandler) {
        return RouterFunctions
                .nest(path("/api/posts/postg"),
                        RouterFunctions
                                .route(RequestPredicates.GET("/"), queryHandler::getTopics)
                                .andRoute(RequestPredicates.GET("/{id}"), queryHandler::getTopic));
    }

    @Bean
    public RouterFunction<ServerResponse> mongoCommandRoute(MongoCommandHandler commandHandler) {
        return RouterFunctions
                .nest(path("/api/posts/mongo"),
                        RouterFunctions
                                .route(RequestPredicates.POST("/"), commandHandler::create)
                                .andRoute(RequestPredicates.PUT("/{id}"), commandHandler::update));
    }

    @Bean
    public RouterFunction<ServerResponse> postgCommandRoute(PostgCommandHandler commandHandler) {
        return RouterFunctions
                .nest(path("/api/posts/postg"),
                        RouterFunctions
                                .route(RequestPredicates.POST("/"), commandHandler::create)
                                .andRoute(RequestPredicates.PUT("/{id}"), commandHandler::update));
    }

}
