package com.wai;

import com.wai.domain.user.UserRepository;
import com.wai.dummyData.DummyData;
import com.wai.testConfig.TestConfig;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
@Import(TestConfig.class)
public class SampleJpaRepositoryTest {

    @Autowired UserRepository userRepository;
    @Autowired DummyData dummyData;

    @Test
    void testDummyData() {
        Assertions.assertNotNull(dummyData);
        Assertions.assertNotNull(dummyData.getUserRepository());
    }

    @DisplayName("@DataJpaTest 테스트")
    @Test
    public void dataJpaTest() {
        Assertions.assertNotNull(userRepository);
    }

}
