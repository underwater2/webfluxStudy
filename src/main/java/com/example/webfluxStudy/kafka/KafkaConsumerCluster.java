package com.example.webfluxStudy.kafka;

import com.example.webfluxStudy.entity.KafkaEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumerCluster {

    @KafkaListener(topics = "${spring.kafka.template.default-topic}",
        groupId = "${spring.kafka.consumer.group-id}",
        containerFactory = "pushEntityKafkaListenerContainerFactory")
    public void consume(@Payload KafkaEntity message,
                        @Headers MessageHeaders messageHeaders) {

        // 받은 객체를 가지고 로직 수행

        log.info("consumer: success >>> message: {}, headers: {}", message.toString(), messageHeaders);
    }
}
