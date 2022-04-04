package com.wai.common.exception;

import com.wai.common.exception.user.*;
import com.wai.common.util.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    /* NotExist */
    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<Object> handleUserNotExistException(UserNotExistException e){
        ApiException apiException = new ApiException(ErrorCode.NOT_EXISTED_USER);
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }

    @ExceptionHandler(UserIdNotExistException.class)
    public ResponseEntity<Object> handleUserIdNotExistException(UserIdNotExistException e){
        ApiException apiException = new ApiException(ErrorCode.NOT_EXISTED_USER_ID);
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }

    @ExceptionHandler(PasswordNotExistException.class)
    public ResponseEntity<ApiException> handlePasswordNotExistException(PasswordNotExistException e){
        ApiException apiException = new ApiException(ErrorCode.NOT_EXISTED_PASSWORD);
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }


    /* duplicate*/
    @ExceptionHandler(UserNicknameDuplicationException.class)
    public ResponseEntity<ApiException> handleUserNicknameDuplicationException(UserNicknameDuplicationException e){
        ApiException apiException = new ApiException(ErrorCode.DUPLICATION_NICKNAME);
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }

    @ExceptionHandler(UserKeyDuplicationException.class)
    public ResponseEntity<Object> handleUserKeyDuplicationException(UserKeyDuplicationException e){
        ApiException apiException = new ApiException(ErrorCode.DUPLICATION_USER_KEY);
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }
}
