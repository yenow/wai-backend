package com.wai.common.exception;

import com.wai.common.exception.post.PostAuthorEnneagramTypeNotExistException;
import com.wai.common.exception.post.PostContentNotExistException;
import com.wai.common.util.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PostExceptionHandler {

    @ExceptionHandler(value = {PostContentNotExistException.class})
    public ResponseEntity<Object> handlePostContentNotExistException(PostContentNotExistException e){
        ApiException apiException = new ApiException(ErrorCode.NOT_EXISTED_POST_TITLE);
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }

    @ExceptionHandler(value = {PostAuthorEnneagramTypeNotExistException.class})
    public ResponseEntity<Object> handlePostAuthorEnneagramNotExistException(PostAuthorEnneagramTypeNotExistException e){
        ApiException apiException = new ApiException(ErrorCode.NOT_EXISTED_POST_AUTHOR_ENNEAGRAM_TYPE);
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }
}
