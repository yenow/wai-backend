package com.wai.dummyData;

import com.wai.domain.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class DummyDataTest {

    @Autowired DummyData dummyData;

    @Test
    void testInitUserEnneagramTest() {
        dummyData.initUsers();
        dummyData.initUserEnneagramTests();

        List<User> users = dummyData.getUsers();

        users.forEach(user -> {
            int myEnneagramType = users.indexOf(user) + 1;
            Assertions.assertEquals(myEnneagramType, user.getUserEnneagramTests().get(0).getEnneagramTest().getMyEnneagramType());
        });
    }

}