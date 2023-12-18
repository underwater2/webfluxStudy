package com.example.webfluxStudy.controller;

import com.example.webfluxStudy.service.CircuitBreakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class CircuitBreakerController {

    private final CircuitBreakerService circuitBreakerService;

    //내부 API 호출이라 Circuit breaker가 동작하지 않지만 남겨놓음
    @GetMapping("/circuitbreaker")
    public Mono<String> circuitbreakerTest(@RequestParam String key) {
        return circuitBreakerService.circuitbreakerTest(key);
    }
}
