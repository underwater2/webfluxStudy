package com.example.webfluxStudy.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "myTopic")
    public void consume(String message) {
        log.info("consume>>> {}", message);
    }
}
