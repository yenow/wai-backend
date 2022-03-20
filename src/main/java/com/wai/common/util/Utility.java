package com.wai.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Utility {
    private final int leftLimit = 97; // letter 'a'
    private final int rightLimit = 122; // letter 'z'

    /**
     * 빈 문자열 및 null 체크
     * */
    public boolean isEmpty(String value) {
        return StringUtils.isEmpty(value);
    }

    public String getRandomString(int length) {
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String getRandomKoreanString(int length) {
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
