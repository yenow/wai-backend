package com.wai.domain.reply;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wai.domain.user.QUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.wai.domain.post.QPost.post;
import static com.wai.domain.reply.QReply.reply;
import static com.wai.domain.user.QUser.user;

@RequiredArgsConstructor
@Repository
public class ReplyCustomRepositoryImpl implements ReplyCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Reply> findReplyById(Long replyId) {
        return Optional.ofNullable(jpaQueryFactory
                .select(reply)
                .from(reply)
                .join(reply.user, user).fetchJoin()
                .join(reply.post, post).fetchJoin()
                .where(reply.replyId.eq(replyId))
                .fetchOne()
        );
    }

    @Override
    public List<Reply> findAllReplyByPostId(Long postId) {
        return jpaQueryFactory.selectFrom(reply)
                .leftJoin(reply.user, user).fetchJoin()
                .leftJoin(reply.post, post).fetchJoin()
                .where(
                    reply.post.postId.eq(postId)
                ).orderBy(
                    reply.parentReplyId.asc().nullsFirst(),
                    reply.insertDate.asc()
                )
                .fetch();
    }
}
