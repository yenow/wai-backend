package com.zootopia.zootopiaspring.member.repository;

import com.zootopia.zootopiaspring.member.domain.Member;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaMemberRepositoryTest {

    @Autowired
    SpringDataJpaMemberRepository springDataJpaMemberRepository;

//    @Autowired
//    MemberRepository memberRepository;

    @After
    public void cleanup() {
       springDataJpaMemberRepository.deleteAll();
    }

    @Test
    public void 멤버저장_불러오기() {
        
        String email = "phantom_ysy@naver.com";
        String password = "tlsdud5089";
        String nickname = "띠용";
        String name = "윤신영";

        // save
        springDataJpaMemberRepository.save(Member.builder()
                .email(email)
                .nickname(nickname)
                .password(password)
                .name(name)
                .build());

        List<Member> memberList = springDataJpaMemberRepository.findAll();  // 모든 데이터 조회

        /* 검증 */
         Member member = memberList.get(0);
        // 메서드() 까지하면 스태틱 메서드가 찾아진다.
         assertThat(email,is(member.getEmail()));
         assertThat(password,is(member.getPassword()));;
    }
}