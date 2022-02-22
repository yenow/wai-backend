package com.wai.domain.post;

import com.wai.controller.post.dto.PostRequestDto;
import com.wai.controller.post.dto.PostSearchType;
import com.wai.domain.user.User;
import com.wai.dummyData.DummyData;
import com.wai.testConfig.TestConfig;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


@Transactional
@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;
    @Autowired
    DummyData dummyData;

    @BeforeAll
    void beforeAll() {
        dummyData.initUsers();
        dummyData.initUserEnneagramTests();
        dummyData.initPosts();
    }

    @Test
    void testReadInitPosts() {
        // given
        User user = dummyData.getUsers().get(0);
        // todo, 내가 댓글단 게시글
        // todo, 내 에니어그램 타입 게시글
        Map<PostSearchType,PostRequestDto> testCase = new HashMap<>() {{
            put(PostSearchType.all,PostRequestDto.builder().postSearchType(PostSearchType.all).postsCount(2).build());
            put(PostSearchType.myPosts,PostRequestDto.builder().postSearchType(PostSearchType.myPosts).postsCount(2).userId(user.getUserId()).build());
            put(PostSearchType.content,PostRequestDto.builder().postSearchType(PostSearchType.content).postsCount(2).searchText("content").build());
            put(PostSearchType.title,PostRequestDto.builder().postSearchType(PostSearchType.title).postsCount(2).searchText("title").build());
            put(PostSearchType.author,PostRequestDto.builder().postSearchType(PostSearchType.author).postsCount(2).searchText("nickname").build());
        }};

        // when
        List<Post> findAllPosts = postRepository.readInitPosts(testCase.get(PostSearchType.all));
        List<Post> findMyPosts = postRepository.readInitPosts(testCase.get(PostSearchType.myPosts));
        List<Post> findSearchContentPosts = postRepository.readInitPosts(testCase.get(PostSearchType.content));
        List<Post> findSearchTitlePosts = postRepository.readInitPosts(testCase.get(PostSearchType.title));
        List<Post> findSearchAuthorPosts = postRepository.readInitPosts(testCase.get(PostSearchType.author));


        // then
        assertEquals(testCase.get(PostSearchType.all).getPostsCount(), findAllPosts.size());
        assertEquals(testCase.get(PostSearchType.myPosts).getPostsCount(), findMyPosts.size());
        assertEquals(testCase.get(PostSearchType.content).getPostsCount(), findSearchContentPosts.size());
        assertEquals(testCase.get(PostSearchType.title).getPostsCount(), findSearchTitlePosts.size());
        assertEquals(testCase.get(PostSearchType.author).getPostsCount(), findSearchAuthorPosts.size());
    }

    @Test
    public void loadPost() {
        //given (테스트 상황 설정)
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postRepository.save(Post.builder()
                .content(content)
                .build());

        //when (테스트 대상 실행)
        List<Post> posts = postRepository.findAll();

        //then (결과 검증)
        Post post = posts.get(0);
        System.out.println(post.getPostId());
        System.out.println(post.getContent());
//        assertThat(post.getContent()).isEqualTo(content);
    }

    @DisplayName("QueryDsl을 통해 Post 조회시 Comment를 Fetch Join한다.")
    @Test
    public void findByContent() {

        String content = "name";

        postRepository.save(Post.builder()
                .content(content)
                .build());

        //when
        Post post = postRepository.findByContent("name");
        System.out.println(post.getPostId());
        System.out.println(post.getContent());
//        assertThat(post.getContent()).isEqualTo(content);
    }
}