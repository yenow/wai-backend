package com.wai.domain.post;

import com.querydsl.core.types.OrderSpecifier;
import com.wai.domain.likey.QLikey;
import com.wai.domain.reply.QReply;
import com.wai.domain.user.QUser;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wai.dto.post.PostRequestDto;
import com.wai.dto.post.PostSearchType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.querydsl.jpa.JPAExpressions.select;
import static com.wai.domain.post.QPost.post;
import static com.wai.domain.reply.QReply.reply;
import static com.wai.domain.user.QUser.user;

@Repository
public class PostCustomRepositoryImpl implements PostCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public PostCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Optional<Post> readPost(PostRequestDto postRequestDto) {
        return Optional.ofNullable(
            jpaQueryFactory
            .selectFrom(post)
                .leftJoin(post.user, user).fetchJoin()
                .leftJoin(post.replys, reply).fetchJoin()
                .leftJoin(reply.user, user).fetchJoin()
                .where(post.postId.eq(postRequestDto.getPostId()))
                .fetchOne()
        );
    }

    @Override
    public List<Post> readInitPosts(PostRequestDto postRequestDto) {
        return jpaQueryFactory.selectFrom(post)
                .innerJoin(post.user, user)
                .leftJoin(post.replys, reply)
                .where(post.isDeleted.ne(true)
                    ,searchTypeEq(postRequestDto))
                .orderBy(post.postId.desc())
                .limit(postRequestDto.getPostsCount())
                .fetch();
    }

    @Override
    public List<Post> readMoreNewPosts(PostRequestDto postRequestDto) {
        return jpaQueryFactory.selectFrom(post)
                .innerJoin(post.user, user)
                .leftJoin(post.replys, reply)
                .where(post.isDeleted.ne(true).and(post.postId.gt(postRequestDto.getStartPostId()))
                    ,searchTypeEq(postRequestDto))
                .orderBy(post.postId.desc())
                .limit(postRequestDto.getPostsCount())
                .fetch();
    }

    @Override
    public List<Post> readMoreOldPosts(PostRequestDto postRequestDto) {
        return jpaQueryFactory.selectFrom(post)
                .innerJoin(post.user, user)
                .leftJoin(post.replys, reply)
                .where(post.isDeleted.ne(true).and(post.postId.lt(postRequestDto.getEndPostId()))
                    ,searchTypeEq(postRequestDto))
                .orderBy(post.postId.desc())
                .limit(postRequestDto.getPostsCount())
                .fetch();
    }

    @Override
    public List<Post> initPopularPosts(PostRequestDto postRequestDto) {
        return jpaQueryFactory.selectFrom(post)
                .innerJoin(post.user, user)
                .leftJoin(post.replys, reply)
                .leftJoin(post.likeys, QLikey.likey)
                .where(post.isDeleted.ne(true)
                        .and(post.insertDate.gt(LocalDateTime.now().minusDays(7))))
                .orderBy(post.clickCount.desc())
                .limit(postRequestDto.getPostsCount())
                .fetch();
    }

    private OrderSpecifier<Integer> orderPopluar(PostRequestDto postRequestDto) {
        if (postRequestDto.getPostSearchType().equals(PostSearchType.popular)) {
            return post.clickCount.desc();
        }
        return null;
    }

    private BooleanExpression searchTypeEq(PostRequestDto postRequestDto) {
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
        return enneagramType != null ? post.authorEnneagramType.eq(enneagramType) : null;
    }

    @Override
    public void deleteAllByUserKey(String userKey) {
        QUser subUser = new QUser("u");
        jpaQueryFactory.delete(post)
                .where(post.user.userId.in(select(subUser.userId)
                        .from(subUser)
                        .where(subUser.userKey.eq(userKey))))
                .execute();
    }

}
