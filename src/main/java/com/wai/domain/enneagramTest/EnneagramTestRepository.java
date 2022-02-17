package com.wai.domain.enneagramTest;

import com.wai.domain.post.Post;
import com.wai.domain.post.PostCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnneagramTestRepository extends JpaRepository<EnneagramTest, Long>  {
}
