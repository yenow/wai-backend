package com.wai.domain.user;

import com.wai.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {

}
