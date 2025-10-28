package org.vvspickles.apigateway.LoggingFilter;


import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class PreRouteLoggingFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // This runs before route matching
        System.out.println("📌 Incoming request: " + exchange.getRequest().getURI());

        return chain.filter(exchange); // Continue to the next filter
    }

    @Override
    public int getOrder() {
        return -1; // Negative values run before the routing happens
    }
}
