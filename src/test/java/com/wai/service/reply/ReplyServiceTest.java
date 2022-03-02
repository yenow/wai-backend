package com.wai.service.reply;

import com.wai.controller.post.dto.PostSaveRequestDto;
import com.wai.controller.reply.dto.ReplyRequestDto;
import com.wai.controller.reply.dto.ReplyDto;
import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import com.wai.domain.reply.Reply;
import com.wai.domain.reply.ReplyRepository;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import com.wai.dummyData.DummyData;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

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