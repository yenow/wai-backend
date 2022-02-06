package com.wai.domain.likey;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * packageName : com.wai.domain.likey
 * fileName : LikeyCustomRepositoryImpl
 * author : 윤신영
 * date : 2022-02-04
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-02-04   윤신영     최초 생성
 */
@Repository
public class LikeyCustomRepositoryImpl implements LikeyCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public LikeyCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<Likey> findByUserIdAndPostId(Long userId, Long postId) {
        QLikey likey = QLikey.likey;

        return Optional.ofNullable(jpaQueryFactory.selectFrom(likey)
                .where(likey.user.userId.eq(userId).and(likey.post.postId.eq(postId)))
                .fetchOne());
    }
}
