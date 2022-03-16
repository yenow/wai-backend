package com.wai.dummyData;

import com.wai.domain.enneagramTest.EnneagramTest;
import com.wai.domain.enneagramTest.TestType;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import com.wai.domain.userEnneagramTest.UserEnneagramTestRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Component
@RequiredArgsConstructor
public class DummyUser {
    final private UserRepository userRepository;
    final private UserEnneagramTestRepository userEnneagramTestRepository;

    @Transactional
    public List<User> createDummyUsers() {
        List<User> dummyUsers = new ArrayList<>(Arrays.asList(
                User.builder().userKey(getUUID()).nickname("닉네임").password(getUUID()).isMember(true).isActivated(false).build()
                ,User.builder().userKey(getUUID()).nickname("닉네임2").password(getUUID()).isMember(true).isActivated(false).build()
                ,User.builder().userKey(getUUID()).nickname("비활성유저").password(getUUID()).isMember(true).isActivated(false).build()
        ));
        dummyUsers.forEach(userRepository::save);
        addUserEnneagramTest(dummyUsers);

        return dummyUsers;
    }

    public void addUserEnneagramTest(List<User> users) {
        AtomicInteger index = new AtomicInteger(0);

        users.forEach(user -> {
            int enneagramType = index.getAndIncrement() % 9 + 1;
            EnneagramTest enneagramTest = EnneagramTest.builder().myEnneagramType(enneagramType).testType(TestType.select).build();
            user.doEnneagramTest(enneagramTest);
        });
    }

    private String getUUID() {
        return UUID.randomUUID().toString();
    }
}
