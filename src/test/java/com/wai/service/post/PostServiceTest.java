package com.wai.service.post;

import com.wai.controller.dto.post.PostSaveRequestDto;
import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : com.wai.service.post
 * fileName : PostServiceTest
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
class PostServiceTest {

    @Autowired
    private PostService postService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    String userKey;
    User user;

    @BeforeEach
    void before() {

        userKey = UUID.randomUUID().toString();
        System.out.println(userKey);
        userRepository.deleteByUserKey(userKey);

        user = User.builder().userKey(userKey).build();
        userRepository.save(user);
    }

    @DisplayName("post 저장 테스트")
    @Test
    void savePost() {
        System.out.println("테스트 시작");
        PostSaveRequestDto postSaveRequestDto = PostSaveRequestDto.builder()
                .title("title")
                .content("content")
                .userId(user.getUserId())
                .userKey(userKey)
                .build();

        Long postId = postService.save(postSaveRequestDto);

        System.out.println(postId);

        Optional<Post> post = postRepository.findById(postId);

        assertEquals(postSaveRequestDto.getTitle(), post.get().getTitle());
        assertEquals(postSaveRequestDto.getContent(), post.get().getContent());
        System.out.println("테스트 끝");
    }

    @AfterEach
    void after () {
        postRepository.deleteAllByUserKey(userKey);
        userRepository.deleteByUserKey(userKey);
    }

}