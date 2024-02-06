package com.example.webfluxStudy.kafka;

import com.example.webfluxStudy.entity.FruitMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumerClusterProto {

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(@Payload byte[] message,
        @Headers MessageHeaders messageHeaders) throws InvalidProtocolBufferException {

        // 받은 객체를 가지고 로직 수행
        FruitMessage fruitMessage = FruitMessage.parseFrom(message);
        log.info("*********** id -> {}", fruitMessage.getId());
        log.info("*********** message -> {}", fruitMessage.getMessage());

        log.info("consumer: success >>> message: {}, headers: {}", FruitMessage.parseFrom(message),
            messageHeaders);
    }
}
