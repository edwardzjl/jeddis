package org.zjl.jeddit.auth.infrastructure.spring.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.zjl.jeddit.auth.domain.SecurityUserService;

/**
 * @author Junlin Zhou
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    private final IgnoreUrlsConfig ignoreUrlsConfig;
    private final SecurityUserService securityUserService;

    public WebSecurityConfigurer(IgnoreUrlsConfig ignoreUrlsConfig, @Lazy SecurityUserService securityUserService) {
        this.ignoreUrlsConfig = ignoreUrlsConfig;
        this.securityUserService = securityUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
                .antMatchers(ignoreUrlsConfig.getUrls().toArray(new String[0])).permitAll()
                .anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(securityUserService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        auth.authenticationProvider(authenticationProvider);
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
