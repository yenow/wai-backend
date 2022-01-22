package com.wai.domain.enneagramTest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wai.domain.user.Gender;
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
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TestType {
    select("직접선택"), simple("간단테스트"), hard("정밀테스트");

    final private String name;

    TestType(String name){
        this.name = name;
    }
}
