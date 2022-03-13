package com.wai.service.post;

import com.wai.dto.post.PostRequestDto;
import com.wai.dto.post.PostDto;
import com.wai.domain.post.Post;
import com.wai.dummyData.DummyData;
import com.wai.service.PostService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    DummyData dummyData;

    @BeforeAll
    void beforeAll() {
        dummyData.initUsers();
        dummyData.initUserEnneagramTests();
        dummyData.initPosts();
        dummyData.initReply();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("==== start Test ====");
    }

    @Test
    void readPost() {
        // given
        Post post = dummyData.getPosts().get(0);
        PostRequestDto postRequestDto = PostRequestDto.builder().postId(post.getPostId()).build();

        // when
        PostDto postDto = postService.readPost(postRequestDto);

        // then
        assertThat(postDto.getTitle()).isEqualTo(post.getTitle());
        assertThat(postDto.getContent()).isEqualTo(post.getContent());

    }


    @AfterEach
    void afterEach () {
        System.out.println("==== End Test ====");
    }


}