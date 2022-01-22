package com.wai.service.post;

import com.wai.controller.dto.post.PostRequestDto;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;

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
        System.out.println("==== end before ====");
    }

    @DisplayName("post 저장 테스트")
    @Test
    void savePost() {
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
    }

    @DisplayName("read posts")
    @Test
    void readPostsInit() {
        List<Post> postList = new ArrayList<>();
        IntStream.range(1,16).forEach(value -> {
            Post post = Post.builder()
                    .user(user)
                    .title("제목" + value + "입니다.")
                    .content("내용" + value + "입니다.")
                    .build();

            postList.add(post);
            postRepository.save(post);
        });

        PostRequestDto postRequestDto = PostRequestDto.builder().postsCount(5).build();
        List<Post> posts = postService.readInitPosts(postRequestDto);

        assertEquals(postList.get(14).getPostId(), posts.get(0).getPostId());
        assertEquals(postList.get(13).getPostId(), posts.get(1).getPostId());
        System.out.println(posts.get(0).getUser().getUserId());
        // System.out.println(posts.get(0).getUser().getPosts().get(0).getPostId());
        System.out.println(posts.get(0).getTitle());
        System.out.println(posts.get(0).getContent());
    }

    @AfterEach
    void after () {
        System.out.println("==== start after ====");
        postRepository.deleteAllByUserKey(userKey);
        userRepository.deleteByUserKey(userKey);
    }

}