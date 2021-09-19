package com.jplan.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//https://www.4te.co.kr/926 필터 참고
//https://yhmane.tistory.com/129 어노테이션 참고

//@Configuration과 @Component @Bean이 의미하는 어노테이션 개념 정확히 짚기

@Configuration
public class GlobalPreFilter implements GlobalFilter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("========== This is Global PreFilter ==========");
        return chain.filter(exchange);
    }
}
