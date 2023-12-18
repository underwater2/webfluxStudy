package com.example.webfluxStudy.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class CircuitBreakerService {

    //내부 API 호출이라 Circuit breaker가 동작하지 않지만 남겨놓음
    @CircuitBreaker(name = "backend-a", fallbackMethod = "fallback")
    public Mono<String> circuitbreakerTest(String key) {
        return callApi(key);
    }

    private Mono<String> callApi(String key) {
        if (key.equals("fail")) {
            throw new RuntimeException("failed");
        }
        return Mono.just("success");
    }

    private Mono<String> fallback(String key, Throwable t) {
        log.error("circuitBreakerFallback message: {}", t.getMessage());
        return Mono.just("circuitBreakerFallback data");
    }
}
