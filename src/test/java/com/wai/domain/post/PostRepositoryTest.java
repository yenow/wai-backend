package com.wai.domain.post;

import org.junit.After;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : com.wai.domain.post
 * fileName : PostRepositoryTest
 * author : 윤신영
 * date : 2021-12-02
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-02   윤신영     최초 생성
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

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
        assertThat(post.getContent()).isEqualTo(content);
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
        assertThat(post.getContent()).isEqualTo(content);
    }
}