package com.zootopia.zootopiaspring.service;

import com.zootopia.zootopiaspring.domain.Member;
import com.zootopia.zootopiaspring.repository.MemberRepository;
import com.zootopia.zootopiaspring.repository.MemoryMemeberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemeberRepository();

    /*
    *  회원가입
    * */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 X

        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /*
     *  전체 회원 조회
     * */
    public List<Member> findMembers () {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
