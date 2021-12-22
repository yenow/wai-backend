package com.wai.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * packageName : com.wai.home.dto
 * fileName : HelloResponseDto
 * author : 윤신영
 * date : 2021-12-02
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-02   윤신영     최초 생성
 */
@Getter
@ToString
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
