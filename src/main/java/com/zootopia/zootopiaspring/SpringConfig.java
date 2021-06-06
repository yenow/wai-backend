package com.zootopia.zootopiaspring;

import com.zootopia.zootopiaspring.repository.JdbcMemberRepository;
import com.zootopia.zootopiaspring.repository.JdbcTemplateMemberRepository;
import com.zootopia.zootopiaspring.repository.MemberRepository;
import com.zootopia.zootopiaspring.repository.MemoryMemeberRepository;
import com.zootopia.zootopiaspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource);
    }
    
    /*
    * 과거에는 XML, 하지만 요즘은 자바코드로 많이 한다고함
    * 
    * */
}
