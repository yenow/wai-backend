package com.wai.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@AllArgsConstructor
@Builder
@Getter
public class ApiException {
    private final int status;
    private final String error;
    private final String message;
    private final LocalDateTime timestamp;
    private final HttpStatus httpStatus;
    private final String path;

}
