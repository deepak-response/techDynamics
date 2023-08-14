package com.techdynamics.demo.design.configuration;

import com.flowable.design.actuate.autoconfigure.security.servlet.ActuatorRequestMatcher;
import com.flowable.design.engine.api.idm.DesignPrivileges;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityActuatorConfiguration {

    @Bean
    @Order(6)
    public SecurityFilterChain basicActuatorSecurity(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf()
                .disable();

        http
                .requestMatcher(new ActuatorRequestMatcher())
                .authorizeRequests()
                .requestMatchers(EndpointRequest.to(InfoEndpoint.class, HealthEndpoint.class)).permitAll()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasAuthority(DesignPrivileges.ACCESS_ADMIN)
                .anyRequest().denyAll()
                .and().httpBasic();

        return http.build();
    }
}
