package com.teleradms.common.lib.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException{
    public BadRequestException(String message, int statusCode) {
        super(message, HttpStatus.BAD_REQUEST.value());
    }
}
