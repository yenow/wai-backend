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
                buildUser(getUUID(),getUUID(),"일반유저", null, false,true),
                buildUser(getUUID(),getUUID(),"일반유저2",null,false,true),
                buildUser(getUUID(),getUUID(),"비활성유저",null,false,false),
                buildUser(getUUID(),getUUID(),"테스트없는유저","",false,true),
                buildUser(getUUID(),getUUID(),"일반유저3","email@naver.com",true,true)
        ));
        dummyUsers.forEach(userRepository::save);
        addUserEnneagramTest(dummyUsers);

        return dummyUsers;
    }

    User buildUser(String userKey, String password, String nickname, String email, boolean isMember, boolean isActivated) {
        return User.builder()
                .userKey(userKey)
                .nickname(nickname)
                .password(password)
                .email(email)
                .isMember(isMember)
                .isActivated(isActivated)
                .build();
    }

    public void addUserEnneagramTest(List<User> users) {
        AtomicInteger index = new AtomicInteger(0);

        users.forEach(user -> {

            if (index.intValue() != 3) {
                int enneagramType = index.getAndIncrement() % 9 + 1;
                EnneagramTest enneagramTest = EnneagramTest.builder().myEnneagramType(enneagramType).testType(TestType.select).build();
                user.doEnneagramTest(enneagramTest);
            }
        });
    }

    private String getUUID() {
        return UUID.randomUUID().toString();
    }
}
