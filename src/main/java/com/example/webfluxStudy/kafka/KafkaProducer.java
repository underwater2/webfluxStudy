package com.example.webfluxStudy.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
//@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public Mono<String> sendMessage(String topic, String payload) {
        log.info("produce>>> topic: {}, payload: {}", topic, payload);
        return Mono.fromFuture(kafkaTemplate.send(topic, payload))
                .thenReturn("ok");
    }
}
