package com.wai.controller.dto;

import lombok.*;

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
@Builder
@ToString
@NoArgsConstructor
public class ResponseDto {
    boolean isSuccess;
    String errorMessage;

    @Builder
    public ResponseDto(boolean isSuccess, String errorMessage) {
        this.isSuccess = isSuccess;
        this.errorMessage = errorMessage;
    }
}
