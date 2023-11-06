package com.example.webfluxStudy.entity;

import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

public class BaseEntity {

    @PastOrPresent
    @CreatedDate
    private Date createdAt;

    @PastOrPresent
    @LastModifiedDate
    private Date updatedAt;

}
