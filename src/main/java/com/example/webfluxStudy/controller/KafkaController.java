package com.example.webfluxStudy.controller;

import com.example.webfluxStudy.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer producer;

    @GetMapping("/kafka/produce")
    public String sendMessage(@RequestParam String message) {
        producer.sendMessage("myTopic", message);

        return "ok";
    }
}
