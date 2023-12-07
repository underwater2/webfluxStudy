package com.example.webfluxStudy.controller;

import com.example.webfluxStudy.entity.KafkaEntity;
import com.example.webfluxStudy.kafka.KafkaProducer;
import com.example.webfluxStudy.kafka.KafkaProducerCluster;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class KafkaControllerCluster {

    private final KafkaProducerCluster producer;

    @PostMapping("/kafka/produce/cluster")
    public String sendMessage(@RequestBody KafkaEntity message) {
        producer.sendMessage(message);

        return "ok";
    }
}
