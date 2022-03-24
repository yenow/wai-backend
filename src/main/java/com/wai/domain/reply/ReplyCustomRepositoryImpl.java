package com.wai.domain.reply;

import com.wai.domain.enneagramTest.QEnneagramTest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wai.domain.post.QPost;
import com.wai.domain.user.QUser;
import com.wai.domain.userEnneagramTest.QUserEnneagramTest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.wai.domain.post.QPost.post;
import static com.wai.domain.reply.QReply.reply;
import static com.wai.domain.user.QUser.user;

@Repository
public class ReplyCustomRepositoryImpl implements ReplyCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public ReplyCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<Reply> findReplyById(Long replyId) {
        QReply reply = QReply.reply;
        QUser user = QUser.user;
        QUserEnneagramTest userEnneagramTest = QUserEnneagramTest.userEnneagramTest;
        QEnneagramTest enneagramTest = QEnneagramTest.enneagramTest;

        return Optional.ofNullable(
            jpaQueryFactory.selectFrom(reply)
                .leftJoin(reply.user, user)
                .leftJoin(reply.user.userEnneagramTests, userEnneagramTest)
                .where(reply.replyId.eq(replyId))
                .fetchOne()
        );
    }

    @Override
    public List<Reply> findAllReplyByPostId(Long postId) {
        return jpaQueryFactory.selectFrom(reply)
                .leftJoin(reply.user, user).fetchJoin()
                .leftJoin(reply.post, post).fetchJoin()
                .where(reply.post.postId.eq(postId))
                .fetch();
    }
}
