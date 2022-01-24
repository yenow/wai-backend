package com.wai.controller.post;

import com.wai.controller.post.dto.PostRequestDto;
import com.wai.controller.post.dto.PostResponseDto;
import com.wai.controller.post.dto.PostSaveRequestDto;
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
        Post post = postService.save(postSaveRequestDto);
        return post.toDto()
                .setUser(post.getUser().toDto());
    }

    @GetMapping(value = "/api/readPost/{postId}")
    public PostResponseDto readPost(@PathVariable("postId") Long postId) {
        Post post = postService.readPost(postId);
        return post.toDto()
                .setUser(post.getUser().toDto());
    }

    @PostMapping(value = "/api/readInitPosts")
    public List<PostResponseDto> readInitPosts(@RequestBody PostRequestDto postRequestDto) {
        List<PostResponseDto> posts = new ArrayList<PostResponseDto>();

        List<Post> findPosts = postService.readInitPosts(postRequestDto);
        findPosts.forEach((post) -> {
            posts.add(post.toDto()
                    .setUser(post.getUser().toDto()));
        });
        return posts;
    }

    @PostMapping(value = "/api/readMoreNewPosts")
    public List<PostResponseDto> readMoreNewPosts(@RequestBody PostRequestDto postRequestDto) {
        List<PostResponseDto> posts = new ArrayList<PostResponseDto>();

        List<Post> findPosts = postService.readMoreNewPosts(postRequestDto);
        findPosts.forEach((post) -> {
            posts.add(post.toDto()
                    .setUser(post.getUser().toDto()));
        });
        return posts;
    }

    @PostMapping(value = "/api/readMoreOldPosts")
    public List<PostResponseDto> readMoreOldPosts(@RequestBody PostRequestDto postRequestDto) {
        List<PostResponseDto> posts = new ArrayList<PostResponseDto>();

        List<Post> findPosts = postService.readMoreOldPosts(postRequestDto);
        findPosts.forEach((post) -> {
            posts.add(post.toDto()
                    .setUser(post.getUser().toDto()));
        });
        return posts;
    }
}
