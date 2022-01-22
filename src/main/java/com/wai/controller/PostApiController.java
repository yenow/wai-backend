package com.wai.controller;

import com.wai.controller.dto.post.PostRequestDto;
import com.wai.controller.dto.post.PostResponseDto;
import com.wai.controller.dto.post.PostSaveRequestDto;
import com.wai.controller.dto.post.PostSaveResponseDto;
import com.wai.domain.post.Post;
import com.wai.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.wai.web
 * fileName : PostApiController
 * author : 윤신영
 * date : 2021-12-03
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-03   윤신영     최초 생성
 */
@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping(value = "/api/savePost")
    public PostSaveResponseDto savePost(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        PostSaveResponseDto postResponseDto = new PostSaveResponseDto();
        Long postId = postService.save(postSaveRequestDto);
        postResponseDto.setPostId(postId);
        return postResponseDto;
    }

    @PostMapping(value = "/api/readInitPosts")
    public List<PostResponseDto> readInitPosts(@RequestBody PostRequestDto postRequestDto) {
        List<PostResponseDto> posts = new ArrayList<PostResponseDto>();
        List<Post> findPosts = postService.readInitPosts(postRequestDto);
        findPosts.forEach((post) -> {
            PostResponseDto postResponseDto = new PostResponseDto();
            postResponseDto.setByPost(post);
            posts.add(postResponseDto);
        });
        return posts;
    }

    @PostMapping(value = "/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }
}
