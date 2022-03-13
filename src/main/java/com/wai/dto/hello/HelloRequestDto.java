package com.wai.dto.hello;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class HelloRequestDto {

    private String name;
    private HelloEnum helloEnum;

}
