package com.wai.common.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wai.common.util.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Builder
@Getter
public class ApiException {
    private final HttpStatus httpStatus;
    private final Integer status;
    private final String error;
    private final String errorCode;
    private final String message;
    private final LocalDateTime timestamp;

    public ApiException(ErrorCode errorCode) {
        this.httpStatus = errorCode.getHttpStatus();
        this.status = errorCode.getHttpStatus().value();
        this.error = errorCode.getHttpStatus().getReasonPhrase();
        this.errorCode = errorCode.getErrorCode();
        this.message = errorCode.getMessage();
        this.timestamp = LocalDateTime.now();
    }

}
