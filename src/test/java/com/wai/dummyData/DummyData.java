package com.wai.dummyData;

import com.wai.WaiSpringApplication;
import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

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
@SpringBootTest(classes= WaiSpringApplication.class)
public class DummyData {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Test
    void insertTestData() {
        String userKey = "8707b210-78f2-11ec-931d-65194c540f17";
        User user = User.builder().userKey(userKey).build();

        userRepository.save(user);
        System.out.println(user.getUserId());


        IntStream.range(1,16).forEach(value -> {
            Post post = Post.builder()
                    .user(user)
                    .title("제목" + value + "입니다.")
                    .content("내용" + value +"입니다.")
                    .build();

            post.setInsert_id(user.getUserId());
            post.setUpdate_id(user.getUserId());

            postRepository.save(post);
        });
    }

    @Test
    void testIntStream() {
        IntStream.range(1,6).forEach(value -> {
            System.out.println(value);
        });
    }
}