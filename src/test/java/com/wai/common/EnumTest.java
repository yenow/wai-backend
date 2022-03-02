package com.wai.common;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnumTest {

    @Test
    void enumTest() {
        System.out.println(tenum.user.name());
        System.out.println(tenum.admin.name());

        Assertions.assertThat(tenum.user.name()).isEqualTo("name");
        Assertions.assertThat(tenum.admin.name()).isEqualTo("admin");
    }

    enum tenum {
        admin, user
    }
}
