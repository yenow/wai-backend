package com.wai.domain.personalityTest;

import lombok.Getter;

/**
 * packageName : com.wai.domain.personalityTest
 * fileName : TestType
 * author : 윤신영
 * date : 2021-12-23
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-23   윤신영     최초 생성
 */
@Getter
public enum TestType {
    enneagram("에니어그램");

    final private String name;

    TestType(String name){
        this.name = name;
    }
}
