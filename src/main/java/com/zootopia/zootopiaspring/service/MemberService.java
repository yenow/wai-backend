package com.zootopia.zootopiaspring.service;

import com.zootopia.zootopiaspring.domain.Member;
import com.zootopia.zootopiaspring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;


public class MemberService {
    
    //@Autowired   필드 주입은 별로 좋지 않다고함, 이 객체를 바꿀수 있는 방법이 없기때문
    private final MemberRepository memberRepository;

    //@Autowired  요즘에는 생성자 주입이 많이 사용된다고 한다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    *  회원가입2
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
