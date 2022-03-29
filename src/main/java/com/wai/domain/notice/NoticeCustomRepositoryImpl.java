package com.wai.domain.notice;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.wai.dto.notice.NoticeDto;
import com.wai.dto.notice.NoticeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.wai.domain.notice.QNotice.notice;
import static com.wai.domain.post.QPost.post;

@RequiredArgsConstructor
@Repository
public class NoticeCustomRepositoryImpl implements NoticeCustomRepository {

    final private JPAQueryFactory jpaQueryFactory;

    @Override
    public List<NoticeDto> getNoticesDto(NoticeRequestDto noticeRequestDto) {

        return jpaQueryFactory
            .select(
                Projections.fields(
                    NoticeDto.class,
                    notice.noticeId
                    ,notice.giver.nickname.as("giverNickname")
                    ,notice.targetPost.postId.as("targetPostId")
                    ,notice.targetReply.replyId.as("targetReplyId")
                    ,notice.noticeType
                    ,notice.content
                    ,notice.insertDate
                    ,notice.isRead
                )
            )
            .from(notice)
            .where(notice.isRead.ne(true)
                .and(notice.recipient.userId.eq(noticeRequestDto.getRecipientUserId()))
                ,lessThanLastNoticeId(noticeRequestDto.getLastNoticeId())
            )
            .limit(noticeRequestDto.getMaxNoticeSize())
            .fetch();
    }

    @Override
    public void clearAll(NoticeRequestDto noticeRequestDto) {
        jpaQueryFactory.update(notice)
                .set(notice.isRead, true)
                .where(notice.recipient.userId.eq(noticeRequestDto.getRecipientUserId()))
                .execute();
    }

    private BooleanExpression lessThanLastNoticeId(Long lastNoticeId) {
        return lastNoticeId == null ? null : notice.noticeId.lt(lastNoticeId);
    }
}
