package com.wai.domain.post;

import java.util.List;

/**
 * packageName : com.wai.domain.post
 * fileName : PostCustomRepository
 * author : 윤신영
 * date : 2021-12-21
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-21   윤신영     최초 생성
 */
public interface PostCustomRepository {

    List<Post> search();

    List<Post> paging();

    List<Post> join();
}
