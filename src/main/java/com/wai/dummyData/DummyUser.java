package com.wai.dummyData;

import com.wai.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
@RequiredArgsConstructor
public class DummyUser {
    private List<User> users = new ArrayList<>();

    public void initUser() {
        User user = User.builder().userKey("").build();
        User user2 = User.builder().userKey(null).build();
        User user3 = User.builder().userKey(null).build();

    }
}
