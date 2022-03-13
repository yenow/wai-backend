package com.wai.common.exception;

import com.wai.common.exception.sign.PasswordNotExistException;
import com.wai.common.exception.user.UserKeyDuplicationException;
import com.wai.common.exception.user.UserNicknameDuplicationException;
import com.wai.common.util.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class SignExceptionHandler {

    @ExceptionHandler(value = {UserKeyDuplicationException.class})
    public ResponseEntity<Object> handleUserKeyDuplicationException(UserKeyDuplicationException e){
        ApiException apiException = new ApiException(ErrorCode.DUPLICATION_USER_KEY);
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }

    @ExceptionHandler(value = {UserNicknameDuplicationException.class})
    public ResponseEntity<ApiException> handleUserNicknameDuplicationException(UserNicknameDuplicationException e){
        ApiException apiException = new ApiException(ErrorCode.DUPLICATION_NICKNAME);
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }

    @ExceptionHandler(value = {PasswordNotExistException.class})
    public ResponseEntity<ApiException> handlePasswordNotExistException(PasswordNotExistException e){
        ApiException apiException = new ApiException(ErrorCode.NOT_EXISTED_PASSWORD);
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }
}
