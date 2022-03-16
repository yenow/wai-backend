package com.wai.controller;

import com.wai.dto.post.PostRequestDto;
import com.wai.dto.post.PostDto;
import com.wai.dto.post.PostSaveRequestDto;
import com.wai.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post/")
public class PostApiController {

    private final PostService postService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value = "/createPost")
    public PostDto createPost(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        postSaveRequestDto.checkValue();
        return postService.createPost(postSaveRequestDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping(value = "/updatePost")
    public PostDto updatePost(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        return postService.updatePost(postSaveRequestDto);
    }

    @PostMapping(value = "/readPost")
    public PostDto readPost(@RequestBody PostRequestDto postRequestDto) {
        PostDto postDto = postService.readPost(postRequestDto);
        return postDto;
    }

    @PostMapping(value = "/readInitPosts")
    public List<PostDto> readInitPosts(@RequestBody PostRequestDto postRequestDto) {

        return postService.readInitPosts(postRequestDto);
    }

    @PostMapping(value = "/readMoreNewPosts")
    public List<PostDto> readMoreNewPosts(@RequestBody PostRequestDto postRequestDto) {

        return postService.readMoreNewPosts(postRequestDto);
    }

    @PostMapping(value = "/readMoreOldPosts")
    public List<PostDto> readMoreOldPosts(@RequestBody PostRequestDto postRequestDto) {

        return postService.readMoreOldPosts(postRequestDto);
    }


    @PostMapping(value = "/initPopularPosts")
    public List<PostDto> initPopularPosts(@RequestBody PostRequestDto postRequestDto) {
        return postService.initPopularPosts(postRequestDto);
    }

    @GetMapping(value = "/addLikey/{postId}/{userId}")
    public PostDto addLikey(@PathVariable("postId") Long postId, @PathVariable("userId") Long userId) {
        postService.addLikey(postId, userId);
        return PostDto.builder().build();
    }

    @GetMapping(value = "/removeLikey/{postId}/{userId}")
    public PostDto removeLikey(@PathVariable("postId") Long postId, @PathVariable("userId") Long userId) {
        postService.removeLikey(postId, userId);
        return PostDto.builder().build();
    }

    @PostMapping(value = "/deletePost")
    public PostDto deletePost(@RequestBody PostRequestDto postRequestDto) {
        return postService.deletePost(postRequestDto);
    }

}
