package com.wai.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * packageName : com.wai.controller.dto
 * fileName : HelloDto
 * author : 윤신영
 * date : 2021-12-28
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-28   윤신영     최초 생성
 */
@Getter
@ToString
@AllArgsConstructor
public class HelloRequestDto {

    private String name;
    private HelloEnum helloEnum;

}
