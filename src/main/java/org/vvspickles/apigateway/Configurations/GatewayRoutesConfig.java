package org.vvspickles.apigateway.Configurations;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("vvspickles", r -> r.path("/products/**")
                        .uri("lb://VVSPICKLES"))
                .route("userservice", r -> r.path("/users/**")
                        .uri("lb://USERSERVICE"))
                .build();
    }
}
