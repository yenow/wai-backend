package com.wai.domain.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * packageName : com.wai.domain.user
 * fileName : Gender
 * author : 윤신영
 * date : 2021-12-27
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-27   윤신영     최초 생성
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {
    man, woman;

    @JsonCreator
    public static Gender from(String s) {
        return Gender.valueOf(s.toLowerCase());
    }
}
