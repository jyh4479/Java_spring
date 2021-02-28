package com.practice.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myRoutes {

    @Bean
    public RouteLocator myRoute(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p
                .path("/service/A").uri("http://localhost:8081/service/A"))
                .route(p->p
                .path("/service/B").uri("http://localhost:8082/service/B"))
                .build();
    }
}
