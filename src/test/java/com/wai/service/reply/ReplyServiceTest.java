package com.wai.service.reply;

import com.wai.controller.post.dto.PostRequestDto;
import com.wai.controller.post.dto.PostSaveRequestDto;
import com.wai.controller.reply.dto.ReplyRequestDto;
import com.wai.controller.reply.dto.ReplyResponseDto;
import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import com.wai.domain.reply.Reply;
import com.wai.domain.reply.ReplyRepository;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import com.wai.service.post.PostService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : com.wai.service.reply
 * fileName : ReplyServiceTest
 * author : 윤신영
 * date : 2022-01-24
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-24   윤신영     최초 생성
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ReplyServiceTest {

    @Autowired
    private ReplyService replyService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ReplyRepository replyRepository;

    String userKey;
    User user;
    Post post;
    List<Reply> replies = new ArrayList<>();

    @BeforeEach
    void before() {

        userKey = UUID.randomUUID().toString();
        System.out.println(userKey);
        userRepository.deleteByUserKey(userKey);

        user = User.builder().userKey(userKey).build();
        userRepository.save(user);

        PostSaveRequestDto postSaveRequestDto = PostSaveRequestDto.builder()
                .title("title")
                .content("content")
                .userId(user.getUserId())
                .userKey(userKey)
                .build();

        post = postRepository.save(postSaveRequestDto.toEntity());

        System.out.println("==== end before() ====");
    }

    @DisplayName("reply 저장 테스트")
    @Test
    void saveReply() {
        ReplyRequestDto replyRequestDto = ReplyRequestDto.builder()
                .userId(user.getUserId())
                .postId(post.getPostId())
                .replyContent("댓글내용입니다.")
                .build();

        ReplyResponseDto reply = replyService.saveReply(replyRequestDto);

        assertEquals(replyRequestDto.getReplyContent(), reply.getReplyContent());
    }


    @AfterEach
    void after () {
        System.out.println("==== start after() ====");
        replies.forEach(reply -> {
            replyRepository.deleteById(reply.getReplyId());
        });
        postRepository.deleteAllByUserKey(userKey);
        userRepository.deleteByUserKey(userKey);
    }
}