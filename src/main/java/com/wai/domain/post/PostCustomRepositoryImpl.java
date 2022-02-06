package com.wai.domain.post;

import com.querydsl.core.QueryModifiers;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.querydsl.jpa.JPAExpressions.select;
import static com.wai.domain.user.QUser.user;

import com.wai.controller.post.dto.PostRequestDto;
import com.wai.domain.enneagramTest.QEnneagramTest;
import com.wai.domain.reply.QReply;
import com.wai.domain.user.QUser;
import com.wai.domain.userEnneagramTest.QUserEnneagramTest;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        QPost post = new QPost("p");

        return jpaQueryFactory.selectFrom(post)
                .where(post.content.contains("abc"))
                .orderBy(post.content.desc())
                .fetch();
    }

    @Override
    public List<Post> paging() {
        QPost post = new QPost("p");

        QueryModifiers queryModifiers = new QueryModifiers(20L, 10L);
        return jpaQueryFactory.selectFrom(post)
                .where(post.content.contains("abc"))
                .orderBy(post.content.desc())
                .offset(10).limit(20)
                .fetch();
    }

    @Override
    public List<Post> join() {
        QPost post = new QPost("p");

        return jpaQueryFactory.selectFrom(post)
                .join(user, user)
                .where(post.content.contains("abc"))
                .orderBy(post.content.desc())
                .offset(10).limit(20)
                .fetch();
    }

    @Override
    public List<Post> readPostsInit(PostRequestDto postRequestDto) {
        QPost post = QPost.post;
        QUser user = QUser.user;

        return jpaQueryFactory.selectFrom(post)
                .innerJoin(post.user, user)
                .where(post.isDelete.ne(true))
                .orderBy(post.postId.desc())
                .limit(postRequestDto.getPostsCount())
                .fetch();
    }

    @Override
    public List<Post> readMoreNewPosts(PostRequestDto postRequestDto) {
        QPost post = QPost.post;
        QUser user = QUser.user;

        return jpaQueryFactory.selectFrom(post)
                .innerJoin(post.user, user)
                .where(post.isDelete.ne(true)
                        .and(post.postId.gt(postRequestDto.getStartPostId())))
                .orderBy(post.postId.desc())
                .limit(postRequestDto.getPostsCount())
                .fetch();
    }

    @Override
    public List<Post> readMoreOldPosts(PostRequestDto postRequestDto) {
        QPost post = QPost.post;
        QUser user = QUser.user;

        return jpaQueryFactory.selectFrom(post)
                .innerJoin(post.user, user)
                .where(post.isDelete.ne(true)
                        .and(post.postId.lt(postRequestDto.getEndPostId())))
                .orderBy(post.postId.desc())
                .limit(postRequestDto.getPostsCount())
                .fetch();
    }

    @Override
    public void deleteAllByUserKey(String userKey) {
        QPost post = new QPost("p");
        QUser subUser = new QUser("u");

        jpaQueryFactory.delete(post)
                .where(post.user.userId.in(select(subUser.userId)
                                            .from(subUser)
                                            .where(subUser.userKey.eq(userKey))))
                .execute();
    }
}
