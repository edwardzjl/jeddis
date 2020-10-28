package org.zjl.jeddit.auth.infrastructure.spring.config;

import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.zjl.jeddit.auth.domain.SecurityUserService;

/**
 * @author Junlin Zhou
 */
@EnableWebFluxSecurity
public class WebfluxSecurityConfig {

    private final IgnoreUrlsConfig ignoreUrlsConfig;
    private final SecurityUserService securityUserService;

    public WebfluxSecurityConfig(IgnoreUrlsConfig ignoreUrlsConfig, @Lazy SecurityUserService securityUserService) {
        this.ignoreUrlsConfig = ignoreUrlsConfig;
        this.securityUserService = securityUserService;
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange()
                .matchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .matchers(EndpointRequest.toAnyEndpoint()).permitAll()
                .pathMatchers(ignoreUrlsConfig.getUrls().toArray(new String[0])).permitAll()
                .and().build();
    }

    @Bean
    public ReactiveUserDetailsService userDetailsService() {
        return securityUserService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
//                .antMatchers(ignoreUrlsConfig.getUrls().toArray(new String[0])).permitAll()
//                .anyRequest().permitAll();
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
////        authenticationProvider.setUserDetailsService(securityUserService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        auth.authenticationProvider(authenticationProvider);
//    }
}
