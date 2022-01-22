package com.wai.domain.enneagramTest;

import com.wai.domain.post.Post;
import com.wai.domain.post.PostCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : com.wai.domain.enneagramTest
 * fileName : EnneagramTestRepository
 * author : 윤신영
 * date : 2022-01-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-22   윤신영     최초 생성
 */
public interface EnneagramTestRepository extends JpaRepository<EnneagramTest, Long>  {
}
