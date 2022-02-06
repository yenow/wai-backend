package com.wai.service.reply;

import com.wai.controller.post.dto.PostResponseDto;
import com.wai.controller.reply.dto.ReplyRequestDto;
import com.wai.controller.reply.dto.ReplyResponseDto;
import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import com.wai.domain.reply.Reply;
import com.wai.domain.reply.ReplyRepository;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName : com.wai.service.reply
 * fileName : ReplyService
 * author : 윤신영
 * date : 2022-01-24
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-24   윤신영     최초 생성
 */
@RequiredArgsConstructor
@Service
public class ReplyService {

    final ReplyRepository replyRepository;
    final UserRepository userRepository;
    final PostRepository postRepository;

    @Transactional
    public ReplyResponseDto saveReply(ReplyRequestDto replyRequestDto) {
        Reply reply = replyRepository.save(replyRequestDto.toEntity());
        User user = userRepository.findById(reply.getUser().getUserId()).get();
        Post post = postRepository.findById(reply.getPost().getPostId()) .get();

        return reply.toDto()
                .setUserDto(user.toDto())
                .setPostDto(post.toDto());
    }

    public List<ReplyResponseDto> readReplysByPostId(Long postId) {
        List<Reply> replys = replyRepository.findAllReplyByPostId(postId).get();

        return replys.stream().map(reply ->
            reply.toDto()
                .setUserDto(reply.getUser().toDto())
        ).collect(Collectors.toList());
    }
}
