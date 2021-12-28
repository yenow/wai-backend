package com.wai.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * packageName : com.wai.controller.dto
 * fileName : HelloEnum
 * author : 윤신영
 * date : 2021-12-28
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-28   윤신영     최초 생성
 */
public enum HelloEnum {
    hello, hi;

    private static final Map<String, HelloEnum> stringToEnum =
            Stream.of(values()).collect(toMap(Objects::toString, e -> e));

    @JsonCreator
    public static HelloEnum from(String s) {
        return HelloEnum.valueOf(s.toLowerCase());
    }
//    @JsonCreator
//    public static HelloEnum fromString(String symbol) {
//        return stringToEnum.get(symbol);
//    }
//
//    public static void sout() {
//        System.out.println(stringToEnum);
//    }
}
