package com.jplan.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String baseUrl = "/jplan/";

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_auto_route", r -> r.path(baseUrl + "authservice/**")
                        .uri("http://localhost:8000/"))
                .route("path_member_route", r -> r.path(baseUrl + "memberservice/**")
                        .uri("http://localhost:8010/"))
                .build();
    }
}
