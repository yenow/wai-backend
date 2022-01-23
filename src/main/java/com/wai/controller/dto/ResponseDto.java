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
@AllArgsConstructor
public class ResponseDto<T> {
    boolean isSuccess;
    String errorMessage;
    T result;
}
