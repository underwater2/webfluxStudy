package com.example.webfluxStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

@SpringBootApplication
@EnableReactiveMongoAuditing
public class WebfluxStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxStudyApplication.class, args);
	}

}