package org.zjl.jeddit.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * @author Junlin Zhou
 */
@EnableMongoAuditing
@EnableReactiveMongoRepositories
@SpringBootApplication
public class JedditForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(JedditForumApplication.class, args);
    }
}
