package com.wai.domain.post;

import com.wai.dto.post.PostRequestDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PostCustomRepository {

    Optional<Post> readPost(PostRequestDto postRequestDto);

    List<Post> readInitPosts(PostRequestDto postRequestDto);

    List<Post> readMoreNewPosts(PostRequestDto postRequestDto);

    List<Post> readMoreOldPosts(PostRequestDto postRequestDto);

    @Transactional
    void deleteAllByUserKey(String userKey) ;

    List<Post> initPopularPosts(PostRequestDto postRequestDto);
}

