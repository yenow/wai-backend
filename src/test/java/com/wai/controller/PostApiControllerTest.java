package com.wai.controller;

import com.wai.dto.post.PostSaveRequestDto;
import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostRepository postRepository;

    @After
    public void tearDown() throws Exception {
        postRepository.deleteAll();
    }

    @Test
    public void savePost() throws Exception {
        //given
        String content = "content";
        PostSaveRequestDto requestDto = PostSaveRequestDto.builder()
                .content(content)
                .build();

        String baseUrl = "http://localhost:" + port + "/api/v1/post";
        // URI url = new URI(baseUrl);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(baseUrl, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Post> all = postRepository.findAll();
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }
}