package com.wai.service.reply;

import com.wai.dto.reply.ReplyRequestDto;
import com.wai.dummyData.DummyData;
import com.wai.service.ReplyService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReplyServiceTest {

    @Autowired
    private ReplyService replyService;

    @Autowired
    DummyData dummyData;

    @BeforeAll
    void beforeAll() {
        dummyData.initUsers();
        dummyData.initUserEnneagramTests();
        dummyData.initPosts();
        dummyData.initReply();
    }

    @AfterAll
    void afterAll() {

    }

    @BeforeEach
    void beforeEach() {
        System.out.println("==== start Test ====");
    }

    @AfterEach
    void afterEach () {
        System.out.println("==== End Test ====");
    }

    @DisplayName("reply 저장 테스트")
    @Test
    void saveReply() {
        ReplyRequestDto replyRequestDto = ReplyRequestDto.builder()
//                .userId(user.getUserId())
//                .postId(post.getPostId())
                .replyContent("댓글내용입니다.")
                .build();
    }

}