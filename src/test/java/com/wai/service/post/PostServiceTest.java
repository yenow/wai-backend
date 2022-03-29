package com.wai.service.post;

import com.wai.domain.post.PostRepository;
import com.wai.domain.tag.Tag;
import com.wai.domain.user.User;
import com.wai.dto.post.PostRequestDto;
import com.wai.dto.post.PostDto;
import com.wai.dto.post.PostSaveRequestDto;
import com.wai.dto.post.PostSearchType;
import com.wai.dummyData.DummyUser;
import com.wai.service.PostService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PostServiceTest {

    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    DummyUser dummyUser;

    static List<User> users;

    @BeforeAll
    void beforeAll() {
        users = dummyUser.createDummyUsers();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("==== start Test ====");
    }

    @Test
    void getTagsTest() {
        // given

        // when
        List<Tag> tags = postService.getTags("#안녕 #바보 #너는 멍청이다 # 띠용");

        // then
        assertThat(tags.get(0).getTagName()).isEqualTo("안녕");
        assertThat(tags.get(1).getTagName()).isEqualTo("바보");
        assertThat(tags.get(2).getTagName()).isEqualTo("너는 멍청이다");
        assertThat(tags.get(3).getTagName()).isEqualTo("띠용");
    }
    
    @Test
    void testGetDto() {
        // given
        PostSaveRequestDto postSaveRequestDto = PostSaveRequestDto.builder()
                .title("title")
                .content("content")
                .userId(users.get(0).getUserId())
                .userKey(users.get(0).getUserKey())
                .author(users.get(0).getNickname())
                .authorEnneagramType(users.get(0).getUserEnneagramTests().get(0).getEnneagramTest().getMyEnneagramType())
                .tag("#태그 #태그입니다")
                .build();
        PostDto result = postService.createPost(postSaveRequestDto);
        PostRequestDto postRequestDto = PostRequestDto.builder().postId(result.getPostId()).userId(users.get(0).getUserId()).build();

        // when
//        String tagString = postRepository.getTagString(postRequestDto);
        PostDto postDto = postService.getPostDto(postRequestDto);
        
        // then
//        System.out.println("tagString = " + tagString);
        System.out.println("postDto = " + postDto);
    }

    @Test
    void testCreatePost() {
        // given
        PostSaveRequestDto postSaveRequestDto = PostSaveRequestDto.builder()
                .title("title")
                .content("content")
                .userId(users.get(0).getUserId())
                .userKey(users.get(0).getUserKey())
                .author(users.get(0).getNickname())
                .authorEnneagramType(users.get(0).getUserEnneagramTests().get(0).getEnneagramTest().getMyEnneagramType())
                .tag("#태그 #태그입니다.")
                .build();
        // when
        PostDto result = postService.createPost(postSaveRequestDto);

        // then
        assertThat(result.getTitle()).isEqualTo(postSaveRequestDto.getTitle());
        assertThat(result.getContent()).isEqualTo(postSaveRequestDto.getContent());
    }

    @Test
    void testGetPosts() {
        // given
        PostRequestDto postRequestDtos = buildPostRequestDto(10, PostSearchType.all);
        // when

        // then
    }

    PostRequestDto buildPostRequestDto(int maxPostSize, PostSearchType postSearchType) {
        return PostRequestDto.builder()
                .maxPostsSize(maxPostSize)
                .postSearchType(postSearchType)
                .build();
    }

//    @Test
//    void readPost() {
//        // given
//        Post post = dummyData.getPosts().get(0);
//        PostRequestDto postRequestDto = PostRequestDto.builder().postId(post.getPostId()).build();
//
//        // when
//        PostDto postDto = postService.readPost(postRequestDto);
//
//        // then
//        assertThat(postDto.getTitle()).isEqualTo(post.getTitle());
//        assertThat(postDto.getContent()).isEqualTo(post.getContent());
//
//    }


    @AfterEach
    void afterEach () {
        System.out.println("==== End Test ====");
    }


}