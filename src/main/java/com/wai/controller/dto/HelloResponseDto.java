package com.wai.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
