package com.wai.common.exception;

import com.wai.common.exception.user.UserNotExistException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class GlobalRestControllerAdvice  {

    public static final int ORDER = 0;
}
