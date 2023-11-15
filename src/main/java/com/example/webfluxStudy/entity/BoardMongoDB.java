package com.example.webfluxStudy.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "board")
public class BoardMongoDB extends BaseEntity {

    @Id
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String body;

}
