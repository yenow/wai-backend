package com.zootopia.zootopiaspring.repository;

import com.zootopia.zootopiaspring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemeberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();
    private static long seqeunce = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++seqeunce);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // null이 반환될 가능성이 있음, 따라서 Optional을 사용
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName()
                .equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
