package com.wai.controller;

import com.wai.common.exception.post.PostAuthorEnneagramTypeNotExistException;
import com.wai.common.exception.post.PostIdNotExistException;
import com.wai.common.exception.user.UserIdNotExistException;
import com.wai.common.exception.user.UserKeyNotExistException;
import com.wai.dto.post.PostRequestDto;
import com.wai.dto.post.PostDto;
import com.wai.dto.post.PostSaveRequestDto;
import com.wai.service.PostService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PostApiController {

    private final PostService postService;

    @PostMapping(value = "/post")
    @PreAuthorize("hasRole('ROLE_USER')")
    public PostDto getPost(@RequestBody PostRequestDto postRequestDto) {
        if (postRequestDto.getPostId() == null) throw new PostIdNotExistException();

        return postService.getPost(postRequestDto);
    }

    @PostMapping(value = "/posts")
    public List<PostDto> posts(@RequestBody PostRequestDto postRequestDto) {
        return postService.posts(postRequestDto);
    }

    @PostMapping(value = "/post/create")
    @PreAuthorize("hasRole('ROLE_USER')")
    public PostDto createPost(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        if (postSaveRequestDto.getUserId() == null) throw new UserIdNotExistException();
        if (StringUtils.isEmpty(postSaveRequestDto.getUserKey())) throw new UserKeyNotExistException();
        if (postSaveRequestDto.getAuthorEnneagramType() == null) throw new PostAuthorEnneagramTypeNotExistException();

        return postService.createPost(postSaveRequestDto);
    }

    @PatchMapping(value = "/post/update")
    @PreAuthorize("hasRole('ROLE_USER')")
    public PostDto updatePost(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        if (postSaveRequestDto.getUserId() == null) throw new UserIdNotExistException();
        if (StringUtils.isEmpty(postSaveRequestDto.getUserKey())) throw new UserKeyNotExistException();
        if (postSaveRequestDto.getPostId() == null) throw new PostIdNotExistException();

        return postService.updatePost(postSaveRequestDto);
    }

    @DeleteMapping(value = "/post/delete")
    @PreAuthorize("hasRole('ROLE_USER')")
    public PostDto deletePost(@RequestBody PostRequestDto postRequestDto) {
        if (postRequestDto.getPostId() == null) throw new PostIdNotExistException();

        return postService.deletePost(postRequestDto);
    }

    @PostMapping(value = "/post/report")
    @PreAuthorize("hasRole('ROLE_USER')")
    public PostDto reportPost(@RequestBody PostRequestDto postRequestDto) {
        if (postRequestDto.getPostId() == null) throw new PostIdNotExistException();

        return postService.reportPost(postRequestDto);
    }


    @PostMapping(value = "/addLikey/{postId}/{userId}")
    public PostDto addLikey(@PathVariable("postId") Long postId, @PathVariable("userId") Long userId) {
        postService.addLikey(postId, userId);
        return PostDto.builder().build();
    }

    @PostMapping(value = "/removeLikey/{postId}/{userId}")
    public PostDto removeLikey(@PathVariable("postId") Long postId, @PathVariable("userId") Long userId) {
        postService.removeLikey(postId, userId);
        return PostDto.builder().build();
    }
}
