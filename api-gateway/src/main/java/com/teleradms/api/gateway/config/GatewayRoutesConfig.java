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
                .route("USER-SERVICE",
                        r -> r.path(BASE_URL + "/users/**")
                                .uri("lb://USER-SERVICE"))
                .route("REPORT-SERVICE",
                        r -> r.path(BASE_URL + "/reports/**")
                                .uri("lb://REPORT-SERVICE"))
                .route("HOSPITAL-SERVICE",
                        r -> r.path(BASE_URL + "/hospitals/**")
                                .uri("lb://HOSPITAL-SERVICE"))
                .route("COMPANY-SERVICE",
                        r -> r.path(BASE_URL + "/companies/**")
                                .uri("lb://COMPANY-SERVICE"))
                .route("AUDIT-SERVICE",
                        r -> r.path(BASE_URL + "/audits/**")
                                .uri("lb://AUDIT-SERVICE"))
                .route("AUTH-SERVICE",
                        r -> r.path(BASE_URL + "/auth/**")
                                .uri("lb://AUTH-SERVICE"))
                .route("ADMIN-SERVICE",
                        r -> r.path(BASE_URL + "/admin/**")
                                .uri("lb://ADMIN-SERVICE"))
                .build();}
}
