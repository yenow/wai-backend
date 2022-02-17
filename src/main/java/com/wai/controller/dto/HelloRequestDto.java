package com.wai.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class HelloRequestDto {

    private String name;
    private HelloEnum helloEnum;

}
