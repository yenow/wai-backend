package com.wai.domain.likey;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.wai.domain.likey.QLikey.likey;

@Repository
public class LikeyCustomRepositoryImpl implements LikeyCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public LikeyCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<Likey> findByUserIdAndPostId(Long userId, Long postId) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(likey)
                .where(likey.user.userId.eq(userId).and(likey.post.postId.eq(postId)))
                .fetchOne());
    }
}
