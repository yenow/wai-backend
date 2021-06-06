package com.zootopia.zootopiaspring;

import com.zootopia.zootopiaspring.repository.MemberRepository;
import com.zootopia.zootopiaspring.repository.MemoryMemeberRepository;
import com.zootopia.zootopiaspring.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional   //  테스트가 끝나면 롤백시킴
class MemberServiceIntegrationTest {

	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memeberRepository;

	@Test
	void contextLoads() {
	}

}
