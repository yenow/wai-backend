package com.wai.common.exception;

import com.wai.common.exception.sign.PasswordNotExistException;
import com.wai.common.exception.user.UserNicknameDuplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class SignExceptionHandler {

    @ExceptionHandler(value = {PasswordNotExistException.class})
    public ResponseEntity<ApiException> handlePasswordNotExistException(PasswordNotExistException e){

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ApiException apiException = ApiException.builder()
                .error(httpStatus.getReasonPhrase())
                .message("password is not present")
                .status(httpStatus.value())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(apiException, httpStatus);
    }

    @ExceptionHandler(value = {UserNicknameDuplicationException.class})
    public ResponseEntity<ApiException> handleUserNicknameDuplicationException(UserNicknameDuplicationException e){

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ApiException apiException = ApiException.builder()
                .error(httpStatus.getReasonPhrase())
                .message("nickname duplication")
                .status(httpStatus.value())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(apiException, httpStatus);
    }
}
