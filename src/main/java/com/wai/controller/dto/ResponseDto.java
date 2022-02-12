package com.wai.controller.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * packageName : com.wai.controller.dto
 * fileName : ResponseDto
 * author : 윤신영
 * date : 2022-01-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-22   윤신영     최초 생성
 */
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
