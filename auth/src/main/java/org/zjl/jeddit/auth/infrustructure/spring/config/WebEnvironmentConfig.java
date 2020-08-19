package org.zjl.jeddit.auth.infrustructure.spring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
//import reactor.netty.http.server.HttpServer;

/**
 * @author Junlin Zhou
 */
@Configuration
public class WebEnvironmentConfig {

//    @Bean
//    public NettyContext nettyContext(ApplicationContext context) {
//        HttpHandler handler = WebHttpHandlerBuilder.applicationContext(context).build();
//        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
//        HttpServer httpServer = HttpServer.create("localhost", 8080);
//        return httpServer.newHandler(adapter).block();
//    }
}
