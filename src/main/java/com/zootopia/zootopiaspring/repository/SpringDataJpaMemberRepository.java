package com.zootopia.zootopiaspring.repository;

import com.zootopia.zootopiaspring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Spring이 자동으로 구현체를 만들고, 스프링 빈에 등록해줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {

    // select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
