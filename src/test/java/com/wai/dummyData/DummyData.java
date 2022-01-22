package com.wai.dummyData;

import com.wai.domain.post.PostRepository;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * packageName : com.wai.sampleData
 * fileName : DummyData
 * author : 윤신영
 * date : 2022-01-20
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-20   윤신영     최초 생성
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DummyData {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Test
    void testUserInsert() {
        String userKey = "8707b210-78f2-11ec-931d-65194c540f17";
        User user = User.builder().userKey(userKey).build();

        userRepository.save(user);
        System.out.println(user.getUserId());
    }
}
