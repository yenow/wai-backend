package com.wai.controller.post;

import com.wai.controller.post.dto.PostRequestDto;
import com.wai.controller.post.dto.PostDto;
import com.wai.controller.post.dto.PostSaveRequestDto;
import com.wai.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping(value = "/api/savePost")
    public PostDto savePost(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        return postService.save(postSaveRequestDto);
    }

    @PostMapping(value = "/api/readPost")
    public PostDto readPost(@RequestBody PostRequestDto postRequestDto) {
        PostDto postDto = postService.readPost(postRequestDto);
        return postDto;
    }

    @PostMapping(value = "/api/readInitPosts")
    public List<PostDto> readInitPosts(@RequestBody PostRequestDto postRequestDto) {

        return postService.readInitPosts(postRequestDto);
    }

    @PostMapping(value = "/api/readMoreNewPosts")
    public List<PostDto> readMoreNewPosts(@RequestBody PostRequestDto postRequestDto) {

        return postService.readMoreNewPosts(postRequestDto);
    }

    @PostMapping(value = "/api/readMoreOldPosts")
    public List<PostDto> readMoreOldPosts(@RequestBody PostRequestDto postRequestDto) {

        return postService.readMoreOldPosts(postRequestDto);
    }


    @PostMapping(value = "/api/initPopularPosts")
    public List<PostDto> initPopularPosts(@RequestBody PostRequestDto postRequestDto) {
        return postService.initPopularPosts(postRequestDto);
    }

    @GetMapping(value = "/api/addLikey/{postId}/{userId}")
    public PostDto addLikey(@PathVariable("postId") Long postId, @PathVariable("userId") Long userId) {
        postService.addLikey(postId, userId);
        return PostDto.builder().build();
    }

    @GetMapping(value = "/api/removeLikey/{postId}/{userId}")
    public PostDto removeLikey(@PathVariable("postId") Long postId, @PathVariable("userId") Long userId) {
        postService.removeLikey(postId, userId);
        return PostDto.builder().build();
    }

    @PostMapping(value = "/api/deletePost")
    public PostDto deletePost(@RequestBody PostRequestDto postRequestDto) {
        return postService.deletePost(postRequestDto);
    }

    @PostMapping(value = "/api/updatePost")
    public PostDto updatePost(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        return postService.updatePost(postSaveRequestDto);
    }
}
