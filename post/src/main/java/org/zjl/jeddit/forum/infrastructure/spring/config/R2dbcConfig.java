package org.zjl.jeddit.forum.infrastructure.spring.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.zjl.jeddit.forum.infrastructure.spring.converter.*;

import java.util.ArrayList;
import java.util.List;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

/**
 * @author Junlin Zhou
 */
// R2dbc auditing comes after 1.2.0-M2
//@EnableR2dbcAuditing
@EqualsAndHashCode(callSuper = true)
@Data
@EnableR2dbcRepositories(basePackages = "org.zjl.jeddit.forum.domain.model.aggregates")
@Configuration
public class R2dbcConfig extends AbstractR2dbcConfiguration {

    @Value("${spring.r2dbc.driver}")
    private String driver;

    @Value("${spring.r2dbc.host}")
    private String host;

    @Value("${spring.r2dbc.port}")
    private Integer port;

    @Value("${spring.r2dbc.username}")
    private String username;

    @Value("${spring.r2dbc.password}")
    private String password;

    @Value("${spring.r2dbc.database}")
    private String database;

    @Bean
    @Override
    public ConnectionFactory connectionFactory() {
        ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
                .option(DRIVER, driver)
                .option(HOST, host)
                .option(PORT, port) // optional, defaults to 1433
                .option(USER, username)
                .option(PASSWORD, password)
                .option(DATABASE, database) // optional
                .build();
        return ConnectionFactories.get(options);
    }

    @Override
    protected List<Object> getCustomConverters() {
        List<Object> converterList = new ArrayList<>();
        converterList.add(new UserConverter());
        converterList.add(new PostConverter());
        converterList.add(new PostReverseConverter());
        converterList.add(new PostIdConverter());
        converterList.add(new PostIdReverseConverter());
        return converterList;
    }

}
