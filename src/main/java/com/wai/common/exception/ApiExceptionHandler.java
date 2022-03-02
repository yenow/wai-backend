package com.wai.common.exception;

import com.wai.common.exception.user.UserKeyDuplicationException;
import com.wai.common.exception.user.UserKeyNotExistException;
import com.wai.common.exception.user.UserKeyTooLongException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {UserKeyNotExistException.class})
    public ResponseEntity<ApiException> handleUserNotExistException(UserKeyNotExistException e){

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ApiException apiException = ApiException.builder()
                .error(httpStatus.getReasonPhrase())
                .message("userKey is not present")
                .status(httpStatus.value())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(value = {UserKeyTooLongException.class})
    public ResponseEntity<Object> handleUserKeyTooLongException(UserKeyTooLongException e){

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ApiException apiException = ApiException.builder()
                .error(httpStatus.getReasonPhrase())
                .message("userKey size is too big")
                .status(httpStatus.value())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(value = {UserKeyDuplicationException.class})
    public ResponseEntity<Object> handleUserKeyDuplicationException(UserKeyDuplicationException e){

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ApiException apiException = ApiException.builder()
                .error(httpStatus.getReasonPhrase())
                .message("userKey duplicate")
                .status(httpStatus.value())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(apiException, httpStatus);
    }
}
