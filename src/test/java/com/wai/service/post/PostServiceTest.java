package com.wai.service.post;

import com.wai.controller.post.dto.PostRequestDto;
import com.wai.controller.post.dto.PostResponseDto;
import com.wai.controller.post.dto.PostSaveRequestDto;
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
import java.util.UUID;
import java.util.stream.IntStream;

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

        Post post = postService.save(postSaveRequestDto);

        assertEquals(postSaveRequestDto.getTitle(), post.getTitle());
        assertEquals(postSaveRequestDto.getContent(), post.getContent());
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
                    .isDelete(value == 15 ? true : false)
                    .build();

            postList.add(post);
            postRepository.save(post);
        });

        PostRequestDto postRequestDto = PostRequestDto.builder().postsCount(5).build();
        List<PostResponseDto> postDtos = postService.readInitPosts(postRequestDto);

        // postID : 14
        assertEquals(postList.get(13).getPostId(), postDtos.get(0).getPostId());
    }

    @DisplayName("새로운 게시글 가져오기")
    @Test
    void readMoreNewPosts() {
        IntStream.range(1,16).forEach(value -> {
            Post post = Post.builder()
                    .user(user)
                    .title("제목" + value + "입니다. 유저 : " + user.getUserId())
                    .content("내용" + value + "입니다.")
                    .isDelete(value == 15 ? true : false)
                    .build();

            postRepository.save(post);
        });

        PostRequestDto postRequestDto = PostRequestDto.builder()
                .postsCount(10)
                .startPostId(14L)
                .endPostId(5L)
                .build();

        List<PostResponseDto> postDtos = postService.readMoreNewPosts(postRequestDto);
        postDtos.stream().forEach(post -> System.out.println(post));

    }

    @AfterEach
    void after () {
        System.out.println("==== start after ====");
        postRepository.deleteAllByUserKey(userKey);
        userRepository.deleteByUserKey(userKey);
    }

}