package com.wai.domain.post;

import com.querydsl.core.QueryModifiers;
import com.querydsl.jpa.impl.JPAQueryFactory;
import static com.wai.domain.user.QUser.user;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.wai.domain.post.QPost.post;
/**
 * packageName : com.wai.domain.post
 * fileName : PostCustomRepositoryImpl
 * author : 윤신영
 * date : 2021-12-21
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-21   윤신영     최초 생성
 */
@Repository
public class PostCustomRepositoryImpl implements PostCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public PostCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Post> search() {
        return jpaQueryFactory.selectFrom(post)
                .where(post.content.contains("abc"))
                .orderBy(post.content.desc())
                .fetch();
    }

    @Override
    public List<Post> paging() {
        QueryModifiers queryModifiers = new QueryModifiers(20L, 10L);
        return jpaQueryFactory.selectFrom(post)
                .where(post.content.contains("abc"))
                .orderBy(post.content.desc())
                .offset(10).limit(20)
                .fetch();
    }

    @Override
    public List<Post> join() {
        return jpaQueryFactory.selectFrom(post)
                .join(user, user)
                .where(post.content.contains("abc"))
                .orderBy(post.content.desc())
                .offset(10).limit(20)
                .fetch();
    }
}
