package com.wai.service;

import com.wai.dto.reply.ReplyRequestDto;
import com.wai.dto.reply.ReplyDto;
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


@RequiredArgsConstructor
@Service
public class ReplyService {

    final ReplyRepository replyRepository;
    final UserRepository userRepository;
    final PostRepository postRepository;

    public List<ReplyDto> readReplysByPostId(Long postId) {
        List<Reply> replies = replyRepository.findAllReplyByPostId(postId);

        return replies.stream().map(ReplyDto::new).collect(Collectors.toList());
    }

    @Transactional
    public ReplyDto createReply(ReplyRequestDto replyRequestDto) {
        Reply reply = replyRequestDto.toEntity();
        replyRepository.save(reply);

        return new ReplyDto(reply);
    }

    @Transactional
    public ReplyDto deleteReply(Long replyId) {
        Reply reply = replyRepository.findById(replyId).get();
        reply.deleteReply();
        return ReplyDto.builder().build();
    }

    @Transactional
    public ReplyDto reportReply(ReplyRequestDto replyRequestDto) {
        Reply reply = replyRepository.findById(replyRequestDto.getReplyId()).get();
        reply.reportReply();
        return ReplyDto.builder().build();
    }
}
