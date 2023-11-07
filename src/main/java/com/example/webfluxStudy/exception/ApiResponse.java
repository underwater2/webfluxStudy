package com.example.webfluxStudy.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ApiResponse<T> {

    private int code;
    private String message;
    private T data;

}
