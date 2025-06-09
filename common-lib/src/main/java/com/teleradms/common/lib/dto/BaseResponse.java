package com.teleradms.common.lib.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse<T> {

    private boolean success;
    private String message;
    private T data;
    private int status;
    private String path;
    private List<String> errors;
    private LocalDateTime timestamp;


    public static <T> BaseResponse<T> success(T data, String message, int status){
        return BaseResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .status(status)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> BaseResponse<T> failure(String message, int status,String path) {
        return BaseResponse.<T>builder()
                .success(false)
                .message(message)
                .data(null)
                .status(status)
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> BaseResponse<T> failure(String message, int status,String path,List<String>errors) {
        return BaseResponse.<T>builder()
                .success(false)
                .message(message)
                .data(null)
                .status(status)
                .path(path)
                .timestamp(LocalDateTime.now())
                .errors(errors)
                .build();
    }
}
