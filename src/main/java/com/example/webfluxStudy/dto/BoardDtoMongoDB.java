package com.example.webfluxStudy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class BoardDtoMongoDB {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class save {
        @NotBlank
        private String title;

        @NotBlank
        private String body;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class response {
        @Id
        private String id;

        @NotBlank
        private String title;

        @NotBlank
        private String body;

        @PastOrPresent
        private LocalDateTime createdAt;

        @PastOrPresent
        private LocalDateTime updatedAt;
    }

}
