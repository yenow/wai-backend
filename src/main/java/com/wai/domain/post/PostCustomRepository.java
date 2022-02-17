package com.wai.domain.post;

import com.wai.controller.post.dto.PostRequestDto;

import javax.transaction.Transactional;
import java.util.List;

public interface PostCustomRepository {

    List<Post> readInitPosts(PostRequestDto postRequestDto);

    List<Post> readMoreNewPosts(PostRequestDto postRequestDto);

    List<Post> readMoreOldPosts(PostRequestDto postRequestDto);

    @Transactional
    void deleteAllByUserKey(String userKey) ;

    List<Post> initPopularPosts(PostRequestDto postRequestDto);
}

