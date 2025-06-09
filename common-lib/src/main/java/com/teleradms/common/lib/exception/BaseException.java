package com.teleradms.common.lib.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final int statusCode;

    public BaseException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

}
