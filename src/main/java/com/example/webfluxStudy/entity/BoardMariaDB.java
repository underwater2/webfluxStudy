package com.example.webfluxStudy.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "board")
public class BoardMariaDB extends BaseEntity {

    @Id
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String body;

}
