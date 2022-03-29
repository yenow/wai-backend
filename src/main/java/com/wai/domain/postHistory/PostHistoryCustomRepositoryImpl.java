package com.wai.domain.postHistory;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.wai.domain.postHistory.QPostHistory.postHistory;

@RequiredArgsConstructor
@Repository
public class PostHistoryCustomRepositoryImpl implements PostHistoryCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<PostHistory> findOneByPostIdAndUserId(Long postId, Long userId) {

        return Optional.ofNullable(jpaQueryFactory
            .select(postHistory)
            .from(postHistory)
            .where(postHistory.post.postId.eq(postId)
                .and(postHistory.user.userId.eq(userId))
            ).orderBy(postHistory.id.desc())
            .limit(1)
            .fetchOne()
        );
    }
}
