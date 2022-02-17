package com.wai.domain.enneagramTest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wai.domain.user.Gender;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum TestType {
    select, simple, hard;

    @JsonCreator
    public static TestType from(String s) {
        return TestType.valueOf(s.toLowerCase());
    }
}
