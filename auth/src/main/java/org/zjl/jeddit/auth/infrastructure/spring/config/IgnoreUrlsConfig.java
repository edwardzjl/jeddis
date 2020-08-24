package org.zjl.jeddit.auth.infrastructure.spring.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Junlin Zhou
 */
@Data
@Component
@ConfigurationProperties(prefix="secure.ignore")
public class IgnoreUrlsConfig {

    private List<String> urls;

}
