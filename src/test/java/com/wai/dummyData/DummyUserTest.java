package com.wai.dummyData;

import com.wai.domain.enneagramTest.TestType;
import com.wai.domain.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("test")
class DummyUserTest {

    @Autowired
    DummyUser dummyUser;

    @Test
    void testCreateDummyUser() {
        // given

        // when
        List<User> users =dummyUser.createDummyUsers();

        // then
        assertThat(users).extracting(User::getNickname).containsExactly("닉네임", "닉네임2", "비활성유저");

        assertThat(users.get(0).getNickname()).isEqualTo("닉네임");
        System.out.println(users.get(0).getIsActivated());
//        assertThat(users.get(0).getIsActivated()).isEqualTo(true);
        assertThat(users.get(0).getUserEnneagramTests().get(0).getEnneagramTest().getMyEnneagramType()).isEqualTo(1);
        assertThat(users.get(0).getUserEnneagramTests().get(0).getEnneagramTest().getTestType()).isEqualTo(TestType.select);

    }
}