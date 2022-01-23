package com.wai.service.post;

import com.wai.controller.dto.post.PostRequestDto;
import com.wai.controller.dto.post.PostSaveRequestDto;
import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * packageName : com.wai.service.post
 * fileName : PostService
 * author : 윤신영
 * date : 2021-12-03
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-03   윤신영     최초 생성
 */
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post save(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity());
    }

    public Post readPost(Long postId) {
        return postRepository.findById(postId).get();
    }

    public List<Post> readInitPosts(PostRequestDto postRequestDto) {
        List<Post> posts =  postRepository.readPostsInit(postRequestDto);
        return posts;
    }

    public List<Post> readMoreNewPosts(PostRequestDto postRequestDto) {
        List<Post> posts =  postRepository.readMoreNewPosts(postRequestDto);
        return posts;
    }

    public List<Post> readMoreOldPosts(PostRequestDto postRequestDto) {
        List<Post> posts =  postRepository.readMoreOldPosts(postRequestDto);
        return posts;
    }
}