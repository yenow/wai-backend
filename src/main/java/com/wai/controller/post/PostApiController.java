package com.wai.controller.post;

import com.wai.controller.enneagramTest.dto.EnneagramTestResponseDto;
import com.wai.controller.post.dto.PostRequestDto;
import com.wai.controller.post.dto.PostResponseDto;
import com.wai.controller.post.dto.PostSaveRequestDto;
import com.wai.controller.reply.dto.ReplyResponseDto;
import com.wai.controller.user.dto.UserResponseDto;
import com.wai.domain.post.Post;
import com.wai.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                .setUserDto(post.getUser().toDto());
    }

    @GetMapping(value = "/api/readPost/{postId}")
    public PostResponseDto readPost(@PathVariable("postId") Long postId) {
        PostResponseDto postResponseDto = postService.readPost(postId);
        return postResponseDto;
    }

    @PostMapping(value = "/api/readInitPosts")
    public List<PostResponseDto> readInitPosts(@RequestBody PostRequestDto postRequestDto) {

        return postService.readInitPosts(postRequestDto);
    }

    @PostMapping(value = "/api/readMoreNewPosts")
    public List<PostResponseDto> readMoreNewPosts(@RequestBody PostRequestDto postRequestDto) {

        return postService.readMoreNewPosts(postRequestDto);
    }

    @PostMapping(value = "/api/readMoreOldPosts")
    public List<PostResponseDto> readMoreOldPosts(@RequestBody PostRequestDto postRequestDto) {

        return postService.readMoreOldPosts(postRequestDto);
    }

    @GetMapping(value = "/api/addLikey/{postId}/{userId}")
    public PostResponseDto addLikey(@PathVariable("postId") Long postId, @PathVariable("userId") Long userId) {
        postService.addLikey(postId, userId);
        return PostResponseDto.builder().build();
    }

    @GetMapping(value = "/api/removeLikey/{postId}/{userId}")
    public PostResponseDto removeLikey(@PathVariable("postId") Long postId, @PathVariable("userId") Long userId) {
        postService.removeLikey(postId, userId);
        return PostResponseDto.builder().build();
    }
}
