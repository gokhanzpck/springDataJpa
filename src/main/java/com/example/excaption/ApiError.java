package com.example.excaption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<T> {

    private String id;
    private LocalDateTime errorTime;
    private T errors;

}