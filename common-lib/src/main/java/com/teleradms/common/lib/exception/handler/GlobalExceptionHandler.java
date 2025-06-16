package com.teleradms.common.lib.exception.handler;

import com.teleradms.common.lib.base.BaseResponse;
import com.teleradms.common.lib.exception.AlreadyExistsException;
import com.teleradms.common.lib.exception.BadRequestException;
import com.teleradms.common.lib.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Void>> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        List<String> errorMessages = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .toList();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                BaseResponse.failure("VALIDATION FAILED", HttpStatus.BAD_REQUEST.value(),request.getServletPath(), errorMessages)
        );
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Void>> handleException(Exception ex,HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                BaseResponse.failure(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getServletPath())
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseResponse<Void>> handleNotFoundException(NotFoundException ex, HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                BaseResponse.failure(ex.getMessage(), HttpStatus.NOT_FOUND.value(), request.getServletPath())
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BaseResponse<Void>> handleBadRequestException(BadRequestException ex, HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                BaseResponse.failure(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), request.getServletPath())
        );
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<BaseResponse<Void>> handleAlreadyExistsException(AlreadyExistsException ex, HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                BaseResponse.failure(ex.getMessage(), HttpStatus.CONFLICT.value(), request.getServletPath())
        );
    }
}
