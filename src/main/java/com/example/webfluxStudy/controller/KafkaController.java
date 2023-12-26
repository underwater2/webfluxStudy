package com.example.webfluxStudy.controller;

import com.example.webfluxStudy.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

//@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer producer;

    @GetMapping("/kafka/produce")
    public Mono<String> sendMessage(@RequestParam String message) {
        return producer.sendMessage("myTopic", message);
    }
}
