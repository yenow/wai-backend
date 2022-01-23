package com.wai.controller;

import com.wai.controller.dto.ResponseDto;
import com.wai.controller.dto.post.PostRequestDto;
import com.wai.controller.dto.post.PostResponseDto;
import com.wai.controller.dto.post.PostSaveRequestDto;
import com.wai.controller.dto.post.PostSaveResponseDto;
import com.wai.domain.post.Post;
import com.wai.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public PostResponseDto savePost(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        PostResponseDto postResponseDto = PostResponseDto.builder().build();
        Post post = postService.save(postSaveRequestDto);
        postResponseDto.setByPost(post);
        return postResponseDto;
    }

    @GetMapping(value = "/api/readPost/{postId}")
    public PostResponseDto readPost(@PathVariable("postId") Long postId) {
        // @RequestBody PostRequestDto postRequestDto
        Post post = postService.readPost(postId);

        PostResponseDto postResponseDto = PostResponseDto.builder().build();
        postResponseDto.setByPost(post);
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

    @PostMapping(value = "/api/readMoreNewPosts")
    public List<PostResponseDto> readMoreNewPosts(@RequestBody PostRequestDto postRequestDto) {
        List<PostResponseDto> posts = new ArrayList<PostResponseDto>();
        List<Post> findPosts = postService.readMoreNewPosts(postRequestDto);
        findPosts.forEach((post) -> {
            PostResponseDto postResponseDto = new PostResponseDto();
            postResponseDto.setByPost(post);
            posts.add(postResponseDto);
        });
        return posts;
    }//readMoreOldPosts

    @PostMapping(value = "/api/readMoreOldPosts")
    public List<PostResponseDto> readMoreOldPosts(@RequestBody PostRequestDto postRequestDto) {
        List<PostResponseDto> posts = new ArrayList<PostResponseDto>();
        List<Post> findPosts = postService.readMoreOldPosts(postRequestDto);
        findPosts.forEach((post) -> {
            PostResponseDto postResponseDto = new PostResponseDto();
            postResponseDto.setByPost(post);
            posts.add(postResponseDto);
        });
        return posts;
    }
}
