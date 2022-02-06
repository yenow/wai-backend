package com.wai.domain.reply;

import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : com.wai.domain.reply
 * fileName : ReplyCustomRepositoryTest
 * author : 윤신영
 * date : 2022-02-03
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-02-03   윤신영     최초 생성
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ReplyCustomRepositoryTest {

    @Autowired
    ReplyRepository replyRepository;

    @Transactional
    @Test
    public void findReplyById() {
        //given (테스트 상황 설정)

        //when (테스트 대상 실행)
        Reply reply = replyRepository.findReplyById(1L).get();

        //then (결과 검증)
        System.out.println(reply.getUser().getUserId());
        System.out.println(reply.getUser().getUserEnneagramTests().get(0).getId());
        System.out.println(reply.getUser().getUserEnneagramTests().get(0).getInsertDate());
        System.out.println(reply.getUser().getUserEnneagramTests().get(0).getEnneagramTest().getMyEnneagramType());

    }
}