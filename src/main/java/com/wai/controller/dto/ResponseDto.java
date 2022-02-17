package com.wai.controller.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private Boolean isSuccess;
    private Integer errorCode;
    private String errorMessage;
    private LocalDateTime nowServerTime = LocalDateTime.now();
}
