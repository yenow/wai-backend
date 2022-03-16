package com.wai.common.exception;

import com.wai.common.exception.user.UserIdNotExistException;
import com.wai.common.exception.user.UserKeyDuplicationException;
import com.wai.common.util.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = {UserIdNotExistException.class})
    public ResponseEntity<Object> handleUserIdNotExistException(UserIdNotExistException e){
        ApiException apiException = new ApiException(ErrorCode.NOT_EXISTED_USER_ID);
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }
}
