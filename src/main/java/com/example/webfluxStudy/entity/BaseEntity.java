package com.example.webfluxStudy.entity;

import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
public class BaseEntity {

    @PastOrPresent
    @CreatedDate
    private LocalDateTime createdAt;

    @PastOrPresent
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
