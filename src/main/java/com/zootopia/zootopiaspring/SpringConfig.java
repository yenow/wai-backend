package com.zootopia.zootopiaspring;

import com.zootopia.zootopiaspring.repository.MemberRepository;
import com.zootopia.zootopiaspring.repository.MemoryMemeberRepository;
import com.zootopia.zootopiaspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemeberRepository();
    }
    
    /*
    * 과거에는 XML, 하지만 요즘은 자바코드로 많이 한다고함
    * 
    * */
}
