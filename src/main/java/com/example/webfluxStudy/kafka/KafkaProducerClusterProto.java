package com.example.webfluxStudy.kafka;

import com.example.webfluxStudy.entity.FruitMessage;
import com.example.webfluxStudy.entity.KafkaEntity;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducerClusterProto {

    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    @Value("${spring.kafka.template.default-topic}")
    private String topicName;

    public Mono<String> sendMessage(KafkaEntity kafkaEntity) {

        FruitMessage fruitMessage = FruitMessage.newBuilder()
            .setId(kafkaEntity.getId())
            .setMessage(kafkaEntity.getMessage())
            .build();

        Message<byte[]> message = MessageBuilder
            .withPayload(fruitMessage.toByteArray())
            .setHeader(KafkaHeaders.TOPIC, topicName)
            .build();

        long startTime = System.currentTimeMillis();

        CompletableFuture<SendResult<String, byte[]>> future =
            kafkaTemplate.send(message);

        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;
        log.info("Message sent in >>> " + duration + " milliseconds");

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("producer: success >>> message: {}, offset: {}",
                    result.getProducerRecord().value().toString(),
                    result.getRecordMetadata().offset());
            } else {
                log.info("producer: failure >>> message: {}", ex.getMessage());
            }
        });

        return Mono.fromFuture(future)
            .thenReturn("ok");
    }

    public Mono<String> sendMessageToPartition(String key, KafkaEntity kafkaEntity) {

        FruitMessage fruitMessage = FruitMessage.newBuilder()
            .setId(kafkaEntity.getId())
            .setMessage(kafkaEntity.getMessage())
            .build();

        CompletableFuture<SendResult<String, byte[]>> future =
            kafkaTemplate.send(topicName, key, fruitMessage.toByteArray());

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("producer: success >>> message: {}, offset: {}",
                    result.getProducerRecord().value().toString(),
                    result.getRecordMetadata().offset());
            } else {
                log.info("producer: failure >>> message: {}", ex.getMessage());
            }
        });

        return Mono.fromFuture(future)
            .thenReturn("ok");
    }

}
