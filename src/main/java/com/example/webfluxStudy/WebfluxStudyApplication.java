package com.example.webfluxStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@SpringBootApplication
@EnableReactiveMongoAuditing
@EnableR2dbcAuditing
public class WebfluxStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxStudyApplication.class, args);
	}

}
