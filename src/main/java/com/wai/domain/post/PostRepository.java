package com.wai.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * packageName : com.wai.domain.post
 * fileName : PostRepository
 * author : 윤신영
 * date : 2021-12-02
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-02   윤신영     최초 생성
 */
public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository {

    @Query("select b from Post b where b.content = :content")
    Post findByContent(@Param("content") String content);   // 순서를 기반으로

    /* 네이티브 쿼리
    @Query("select b from Post b where b.content = ?1"
    nativeQuery = true
    )
    Post findByContent(String content);
    */
}
