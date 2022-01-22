package com.wai.controller;

import com.wai.controller.dto.post.PostSaveRequestDto;
import com.wai.controller.dto.post.PostSaveResponseDto;
import com.wai.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(value = "/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }
}
