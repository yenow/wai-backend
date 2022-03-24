package com.wai.domain.post;

import com.wai.dto.post.PostDto;
import com.wai.dto.post.PostRequestDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PostCustomRepository {

    Optional<Post> getPost(Long postId);
    Optional<PostDto> getPostDto(PostRequestDto postRequestDto);

    List<Post> getPosts(PostRequestDto postRequestDto);
    List<PostDto> getPostDtos(PostRequestDto postRequestDto);


}

