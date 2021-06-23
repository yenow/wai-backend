package com.zootopia.zootopiaspring.member.repository;

import com.zootopia.zootopiaspring.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Spring이 자동으로 구현체를 만들고, 스프링 빈에 등록해줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {

    @Override
    Member save(Member member);

    @Override
    List<Member> findAllById(Iterable<Long> longs);

    @Override
    Optional<Member> findByName(String name);

    @Override
    List<Member> findAll();


}
