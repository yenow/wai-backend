package com.wai.domain.post;

import com.querydsl.core.types.OrderSpecifier;
import com.wai.domain.likey.QLikey;
import com.wai.domain.reply.QReply;
import com.wai.domain.user.QUser;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wai.controller.post.dto.PostRequestDto;
import com.wai.controller.post.dto.PostSearchType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.querydsl.jpa.JPAExpressions.select;

@Repository
public class PostCustomRepositoryImpl implements PostCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public PostCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Post> readInitPosts(PostRequestDto postRequestDto) {
        QPost post = QPost.post;
        QUser user = QUser.user;

        return jpaQueryFactory.selectFrom(post)
                .innerJoin(post.user, user)
                .leftJoin(post.replys, QReply.reply)
                .where(post.isDelete.ne(true)
                    ,searchTypeEq(postRequestDto))
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
                .leftJoin(post.replys, QReply.reply)
                .where(post.isDelete.ne(true).and(post.postId.gt(postRequestDto.getStartPostId()))
                    ,searchTypeEq(postRequestDto))
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
                .leftJoin(post.replys, QReply.reply)
                .where(post.isDelete.ne(true).and(post.postId.lt(postRequestDto.getEndPostId()))
                    ,searchTypeEq(postRequestDto))
                .orderBy(post.postId.desc())
                .limit(postRequestDto.getPostsCount())
                .fetch();
    }

    @Override
    public List<Post> initPopularPosts(PostRequestDto postRequestDto) {
        return jpaQueryFactory.selectFrom(QPost.post)
                .innerJoin(QPost.post.user, QUser.user)
                .leftJoin(QPost.post.replys, QReply.reply)
                .leftJoin(QPost.post.likeys, QLikey.likey)
                .where(QPost.post.isDelete.ne(true)
                        .and(QPost.post.insertDate.gt(LocalDateTime.now().minusDays(7))))
                .orderBy(QPost.post.clickCount.desc())
                .limit(postRequestDto.getPostsCount())
                .fetch();
    }

    private OrderSpecifier<Integer> orderPopluar(PostRequestDto postRequestDto) {
        if (postRequestDto.getPostSearchType().equals(PostSearchType.popular)) {
            return QPost.post.clickCount.desc();
        }
        return null;
    }

    private BooleanExpression searchTypeEq(PostRequestDto postRequestDto) {
        QPost post = QPost.post;
        QReply reply = QReply.reply;

        PostSearchType postSearchType = postRequestDto.getPostSearchType();
        String searchText = postRequestDto.getSearchText();

        if (postSearchType.equals(PostSearchType.content)) {

            return searchText != null ? post.content.contains(searchText).or(post.title.contains(searchText)) : null;

        } else if (postSearchType.equals(PostSearchType.title)) {

            return searchText != null ? post.title.contains(searchText) : null;

        } else if (postSearchType.equals(PostSearchType.author)) {

            return searchText != null ? post.author.contains(searchText) : null;

        } else if (postSearchType.equals(PostSearchType.enneagramType)) {

            return enneagramTypeEq(postRequestDto.getMyEnneagramType());

        } else if (postSearchType.equals(PostSearchType.myPosts)) {

            return (post.user.userId.eq(postRequestDto.getUserId()));

        }  else if (postSearchType.equals(PostSearchType.myReplyPosts)) {

            return (QReply.reply.user.userId.eq(postRequestDto.getUserId()));
        }

        return null;
    }

    private BooleanExpression enneagramTypeEq(Integer enneagramType) {
        QPost post = QPost.post;

        return enneagramType != null ? post.authorEnneagramType.eq(enneagramType) : null;
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
