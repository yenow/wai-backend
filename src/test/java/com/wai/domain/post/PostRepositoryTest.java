package com.wai.domain.post;

import com.wai.domain.tag.TagRepository;
import com.wai.dto.post.PostDto;
import com.wai.dto.post.PostRequestDto;
import com.wai.dto.post.PostSearchType;
import com.wai.domain.reply.Reply;
import com.wai.domain.user.User;
import com.wai.dummyData.DummyData;
import com.wai.dummyData.DummyPost;
import com.wai.dummyData.DummyUser;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.assertj.core.api.Assertions.*;


@Transactional
@SpringBootTest
@ActiveProfiles("test")
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;
    @Autowired
    TagRepository tagRepository;
    @Autowired
    DummyUser dummyUser;

    List<User> users;
    List<Post> posts;

    @BeforeAll
    static void beforeAll() {
    }

    @AfterAll
    static void AfterAll() {
    }

    @BeforeEach
    void beforeEach() {
        users = dummyUser.createDummyUsers();
        posts = DummyPost.createDummyPosts(users.get(0));
        posts.forEach(post -> postRepository.save(post));

        System.out.println("==== start Test ====");
    }

    @AfterEach
    void afterEach () {
        System.out.println("==== End Test ====");
    }

    @Test
    void testGetPost() {
        // given
        PostRequestDto postRequestDto = PostRequestDto.builder().maxPostsSize(10).postSearchType(PostSearchType.all).build();
        // when
        Post post = postRepository.getPost(posts.get(0).getPostId()).orElseThrow();

        // then
        assertThat(post.getPostId()).isEqualTo(posts.get(0).getPostId());
    }

    @Test
    void testGetPostDto() {
        // given
        PostRequestDto postRequestDto = PostRequestDto.builder().maxPostsSize(10).postSearchType(PostSearchType.all).postId(1L).build();
        // when
        PostDto postDto = postRepository.getPostDto(postRequestDto).orElseThrow();

        // then
        System.out.println("postDto = " + postDto);
        assertThat(postDto.getPostId()).isEqualTo(posts.get(0).getPostId());
    }

    @Test
    void testGetPostDtos() {
        // given
        PostRequestDto postRequestDto = PostRequestDto.builder().maxPostsSize(10).postSearchType(PostSearchType.all).build();
        // when
        List<PostDto> postDtos = postRepository.getPostDtos(postRequestDto);
        // then
        System.out.println("postDto = " + postDtos);
        System.out.println("postDto.size() = " + postDtos.size());
    }

   /* @Test
    void readPost() {
        // given
        Post post = dummyData.getPosts().get(0);
        User user = post.getUser();
        PostRequestDto postRequestDto = PostRequestDto.builder().postId(post.getPostId()).build();

        // when
        Post findPost = postRepository.readPost(postRequestDto).orElse(Post.builder().build());

        // then
        System.out.println("findPost = " + findPost);
        findPost.getReplys().forEach(reply -> System.out.println("reply = " + reply + "user = " + reply.getUser()));

        assertThat(findPost.getPostId()).isEqualTo(post.getPostId());
        assertThat(findPost.getTitle()).isEqualTo(post.getTitle());
        for(Reply reply : findPost.getReplys()) {
            int index = findPost.getReplys().indexOf(reply);
            assertThat(reply.getReplyId()).isEqualTo(post.getReplys().get(index).getReplyId());
            assertThat(reply.getUser().getUserId()).isEqualTo(post.getReplys().get(index).getUser().getUserId());
        }
        assertThat(findPost.getReplys().size()).isGreaterThan(0);
        assertThat(findPost.getReplys().get(0)).isNotNull();
        assertThat(findPost.getReplys().get(0).getUser().getUserKey()).isNotNull();
        assertThat(findPost.getReplys().get(0).getUser().getUserId()).isNotNull();
    }

    @Test
    void testReadInitPosts() {
        // given
        User user = dummyData.getUsers().get(0);
        // todo, ?????? ????????? ?????????
        // todo, ??? ??????????????? ?????? ?????????
        Map<PostSearchType,PostRequestDto> testCase = new HashMap<>() {{
            put(PostSearchType.all,PostRequestDto.builder().postSearchType(PostSearchType.all).maxPostsSize(2).build());
            put(PostSearchType.myPosts,PostRequestDto.builder().postSearchType(PostSearchType.myPosts).maxPostsSize(2).userId(user.getUserId()).build());
            put(PostSearchType.content,PostRequestDto.builder().postSearchType(PostSearchType.content).maxPostsSize(2).searchText("content").build());
            put(PostSearchType.title,PostRequestDto.builder().postSearchType(PostSearchType.title).maxPostsSize(2).searchText("title").build());
            put(PostSearchType.author,PostRequestDto.builder().postSearchType(PostSearchType.author).maxPostsSize(2).searchText("nickname").build());
        }};

        // when
        List<Post> findAllPosts = postRepository.readInitPosts(testCase.get(PostSearchType.all));
        List<Post> findMyPosts = postRepository.readInitPosts(testCase.get(PostSearchType.myPosts));
        List<Post> findSearchContentPosts = postRepository.readInitPosts(testCase.get(PostSearchType.content));
        List<Post> findSearchTitlePosts = postRepository.readInitPosts(testCase.get(PostSearchType.title));
        List<Post> findSearchAuthorPosts = postRepository.readInitPosts(testCase.get(PostSearchType.author));


        // then
//        assertEquals(testCase.get(PostSearchType.all).getPostsCount(), findAllPosts.size());
//        assertEquals(testCase.get(PostSearchType.myPosts).getPostsCount(), findMyPosts.size());
//        assertEquals(testCase.get(PostSearchType.content).getPostsCount(), findSearchContentPosts.size());
//        assertEquals(testCase.get(PostSearchType.title).getPostsCount(), findSearchTitlePosts.size());
//        assertEquals(testCase.get(PostSearchType.author).getPostsCount(), findSearchAuthorPosts.size());
    }*/

}