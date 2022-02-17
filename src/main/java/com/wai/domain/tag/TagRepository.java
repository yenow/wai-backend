package com.wai.domain.tag;

import com.wai.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("select b from Post b where b.content = :content")
    Post findByContent(@Param("content") String content);   // 순서를 기반으로

//    @Query("select b from Post b where b.content = ?1"
//    nativeQuery = true
//    )
//    Post findByContent(String content);
}
