package com.wai.common.exception;

import com.wai.common.exception.user.UserKeyDuplicationException;
import com.wai.common.exception.user.UserKeyNotExistException;
import com.wai.common.exception.user.UserKeyTooLongException;
import com.wai.common.util.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class InvalidInputExceptionHandler {

    @ExceptionHandler(value = {UserKeyNotExistException.class})
    public ResponseEntity<Object> handleUserKeyDuplicationException(UserKeyNotExistException e){
        ApiException apiException = new ApiException(ErrorCode.NOT_EXISTED_USER_KEY);
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }

}
