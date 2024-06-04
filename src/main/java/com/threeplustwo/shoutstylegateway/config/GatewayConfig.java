package com.threeplustwo.shoutstylegateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        return routeLocatorBuilder.routes()
                .route("project-service", r -> r.path("/project/**").uri("lb://project-service"))
                .route("shout-style-auth", r -> r.path("/auth/**").uri("lb://shout-style-auth"))
                .route("clc-chat-service", r -> r.path("/chatRoom/**").uri("lb://clc-chat-service"))
                .route("clc-chat-service", r -> r.path("/messages/**").uri("lb://clc-chat-service"))
                .build();

    }

}

