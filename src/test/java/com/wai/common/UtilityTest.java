package com.wai.common;

import com.wai.common.util.Utility;
import com.wai.testConfig.TestConfig;
import org.assertj.core.description.Description;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(TestConfig.class)
class UtilityTest {

    @Autowired
    private Utility utility;

    @Test
    void randomStrings() {
        // given
        int length = 10;

        // when
        String randomString = utility.getRandomString(length);

        // then
        System.out.println("randomString = " + randomString);
        System.out.println("randomString byte size = " + randomString.getBytes().length);
        assertThat(randomString.length()).as("랜덤 문자열 사이즈 비교").isEqualTo(length);
    }

    @Test
    void nullEqualEmptyString() {
        assertThat("").isNotNull();
    }

    @Test
    void assertJTest() {
        final StringBuilder descriptionReportBuilder = new StringBuilder(String.format("Assertions:%n"));
        Consumer<Description> descriptionConsumer = desc -> descriptionReportBuilder.append(String.format("-- %s%n", desc));

//        Assertions.set

        String descriptionReport = descriptionReportBuilder.toString();
    }

    @Test
    void test() {
        String str = "c3ByaW5nLWJvb3Qtc2VjdXJpdHktand0LXR1dG9yaWFsLWppd29vbi1zcHJpbmctYm9vdC1zZWN1cml0eS1qd3QtdHV0b3JpYWwK";
        System.out.println("==============");
        System.out.println(str.getBytes(StandardCharsets.UTF_8).length);
    }
}