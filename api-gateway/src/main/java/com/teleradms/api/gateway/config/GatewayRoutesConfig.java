package com.teleradms.api.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {

    private static final String BASE_URL = "/api/v1";

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("MEMBER-SERVICE",
                        r -> r.path(BASE_URL + "/members/**")
                                .uri("lb://MEMBER-SERVICE"))
                .build();
    }


}
