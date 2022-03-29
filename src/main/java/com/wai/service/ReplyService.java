package com.wai.service;

import com.wai.domain.notice.Notice;
import com.wai.domain.notice.NoticeRepository;
import com.wai.domain.notice.NoticeType;
import com.wai.dto.reply.ReplyRequestDto;
import com.wai.dto.reply.ReplyDto;
import com.wai.domain.post.Post;
import com.wai.domain.post.PostRepository;
import com.wai.domain.reply.Reply;
import com.wai.domain.reply.ReplyRepository;
import com.wai.domain.user.User;
import com.wai.domain.user.UserRepository;
import com.wai.service.reply.ReplyServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ReplyService {

    final private ReplyRepository replyRepository;
    final private NoticeRepository noticeRepository;
    final private ReplyServiceUtil replyServiceUtil;

    @PersistenceContext
    private EntityManager entityManager;

    public List<ReplyDto> readReplysByPostId(Long postId) {
        List<Reply> replies = replyRepository.findAllReplyByPostId(postId);
//        return replies.stream().map(ReplyDto::new).collect(Collectors.toList());
        return replyServiceUtil.hierarchyOrderBy(replies).stream().map(ReplyDto::new).collect(Collectors.toList());
    }

    @Transactional
    public ReplyDto createReply(ReplyRequestDto replyRequestDto) {
        Reply reply = replyRequestDto.toEntity();
        replyRepository.save(reply);
        entityManager.clear();

        createNotice(replyRequestDto, replyRepository.findReplyById(reply.getReplyId()).get());
        return new ReplyDto(reply);
    }

    private void createNotice(ReplyRequestDto replyRequestDto, Reply reply) {
        Notice notice = Notice.builder()
                .noticeType(replyRequestDto.getParentReplyUserId() == null ? NoticeType.reply : NoticeType.parentReply)
                .giver(
                    User.builder()
                    .userId(replyRequestDto.getUserId())
                    .build()
                )
                .recipient(
                    User.builder()
                    .userId(replyRequestDto.getParentReplyUserId() == null ?
                            reply.getPost().getUser().getUserId() :
                            replyRequestDto.getParentReplyUserId())
                    .build()
                )
                .targetPost(
                    Post.builder()
                    .postId(reply.getPost().getPostId())
                    .build()
                )
                .targetReply(reply)
                .content("게시글에 댓글이 달렸습니다.")
                .build();

        noticeRepository.save(notice);
    }

    @Transactional
    public ReplyDto updateReply(ReplyRequestDto replyRequestDto) {
        Reply reply = replyRepository.findById(replyRequestDto.getReplyId()).get();
        reply.updateReply(replyRequestDto);
        return new ReplyDto(reply);
    }

    @Transactional
    public ReplyDto deleteReply(Long replyId) {
        Reply reply = replyRepository.findById(replyId).get();
        reply.deleteReply();
        return new ReplyDto(reply);
    }

    @Transactional
    public ReplyDto reportReply(ReplyRequestDto replyRequestDto) {
        Reply reply = replyRepository.findById(replyRequestDto.getReplyId()).get();
        reply.reportReply();
        return new ReplyDto(reply);
    }

}
