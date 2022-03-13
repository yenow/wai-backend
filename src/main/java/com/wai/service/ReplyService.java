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
        List<Reply> replys = replyRepository.findAllReplyByPostId(postId).get();

        return replys.stream().map(reply ->
            reply.toDto()
                .setUserDto(reply.getUser().toDto())
        ).collect(Collectors.toList());
    }

    @Transactional
    public ReplyDto saveReply(ReplyRequestDto replyRequestDto) {
        Reply reply = replyRepository.save(replyRequestDto.toEntity());
        User user = userRepository.findById(reply.getUser().getUserId()).get();
        Post post = postRepository.findById(reply.getPost().getPostId()) .get();

        return reply.toDto()
                .setUserDto(user.toDto())
                .setPostDto(post.toDto());
    }


    @Transactional
    public ReplyDto deleteReply(ReplyRequestDto replyRequestDto) {
//        replyRepository.deleteById(replyRequestDto.getReplyId());
        Reply reply = replyRepository.findById(replyRequestDto.getReplyId()).get();
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
