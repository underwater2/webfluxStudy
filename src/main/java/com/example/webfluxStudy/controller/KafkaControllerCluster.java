package com.example.webfluxStudy.controller;

import com.example.webfluxStudy.entity.KafkaEntity;
import com.example.webfluxStudy.kafka.KafkaProducerCluster;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

//@RestController
@RequiredArgsConstructor
public class KafkaControllerCluster {

    private final KafkaProducerCluster producer;

    @PostMapping("/kafka/produce/cluster")
    public Mono<String> sendMessage(@RequestBody KafkaEntity message) {
        return producer.sendMessage(message);
    }

    @PostMapping("/kafka/produce/cluster/{key}")
    public Mono<String> sendMessageToPartition(@PathVariable String key,
        @RequestBody KafkaEntity message) {
        return producer.sendMessageToPartition(key, message);
    }
}
