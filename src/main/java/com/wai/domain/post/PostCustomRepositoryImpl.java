package com.wai.domain.post;

import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.wai.domain.likey.QLikey;
import com.wai.domain.reply.QReply;
import com.wai.domain.user.QUser;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wai.dto.post.PostDto;
import com.wai.dto.post.PostRequestDto;
import com.wai.dto.post.PostSearchType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.querydsl.jpa.JPAExpressions.select;
import static com.wai.domain.likey.QLikey.likey;
import static com.wai.domain.post.QPost.post;
import static com.wai.domain.reply.QReply.reply;
import static com.wai.domain.user.QUser.user;

@RequiredArgsConstructor
@Repository
public class PostCustomRepositoryImpl implements PostCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public Optional<Post> getPost(Long postId) {
        return Optional.ofNullable(
            jpaQueryFactory
            .selectFrom(post)
                .leftJoin(post.user, user).fetchJoin()
                .leftJoin(post.replys, reply).fetchJoin()
                .leftJoin(reply.user, user).fetchJoin()
                .where(post.postId.eq(postId))
                .fetchOne()
        );
    }

    @Override
    public Optional<PostDto> getPostDto(PostRequestDto postRequestDto) {

        return Optional.ofNullable(jpaQueryFactory
                .select(Projections.fields(PostDto.class,
                    post.postId
                    ,post.title
                    ,post.content
                    ,post.author
                    ,post.authorEnneagramType
                    ,post.clickCount
                    ,post.isDeleted
                    ,post.isReported
                    ,post.insertDate
                    ,post.updateDate
                    ,post.insertId
                    ,user.userId
                    ,ExpressionUtils.as(JPAExpressions
                        .select(reply.count())
                        .from(reply)
                        .where(reply.post.postId.eq(postRequestDto.getPostId())), "replyCount")
                    ,ExpressionUtils.as(JPAExpressions
                            .select(likey.count())
                            .from(likey)
                            .where(likey.post.postId.eq(postRequestDto.getPostId())), "likeyCount")
                    ,ExpressionUtils.as(JPAExpressions
                            .select(likey.count().when(1L).then(true)
                                    .otherwise(false))
                            .from(likey)
                            .where(likey.post.postId.eq(postRequestDto.getPostId())
                                    .and(likey.user.userId.eq(postRequestDto.getUserId()))), "isLikey")
                ))
                .from(post)
                .join(post.user, user)
                .where(post.postId.eq(postRequestDto.getPostId()))
                .fetchOne()
        );
    }

    private BooleanExpression greatThanStartPostId(Long startPostId) {
        return startPostId == null ? null : post.postId.gt(startPostId);
    }

    @Override
    public List<Post> getPosts(PostRequestDto postRequestDto) {
        return jpaQueryFactory.selectFrom(post)
                .innerJoin(post.user, user)
                .leftJoin(post.replys, reply)
                .where(post.isDeleted.ne(true)
                        .and(post.isReported.ne(true))
                        ,lessThanEndPostId(postRequestDto.getEndPostId())
                        ,searchTypeEq(postRequestDto))
                .orderBy(post.postId.desc())
                .limit(postRequestDto.getMaxPostsSize())
                .fetch();
    }

    @Override
    public List<PostDto> getPostDtos(PostRequestDto postRequestDto) {
        return jpaQueryFactory
            .select(Projections.fields(PostDto.class,
                    post.postId
                    ,post.title
                    ,post.content
                    ,post.author
                    ,post.authorEnneagramType
                    ,post.clickCount
                    ,post.isDeleted
                    ,post.isReported
                    ,post.insertDate
                    ,post.updateDate
                    ,post.insertId
                    ,user.userId
                    ,ExpressionUtils.as(JPAExpressions
                            .select(reply.count())
                            .from(reply)
                            .where(reply.post.postId.eq(post.postId)), "replyCount")
                    ,ExpressionUtils.as(JPAExpressions
                            .select(likey.count())
                            .from(likey)
                            .where(likey.post.postId.eq(post.postId)), "likeyCount")
            ))
            .from(post)
            .join(post.user, user)
            .where(post.isDeleted.ne(true)
                    .and(post.isReported.ne(true))
                    ,lessThanEndPostId(postRequestDto.getEndPostId())
                    ,searchTypeEq(postRequestDto))
            .orderBy(post.postId.desc())
            .limit(postRequestDto.getMaxPostsSize())
            .fetch();
    }

    private BooleanExpression lessThanEndPostId(Long endPostId) {
        return endPostId == null ? null : post.postId.lt(endPostId);
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

    private OrderSpecifier<Integer> orderPopluar(PostRequestDto postRequestDto) {
        if (postRequestDto.getPostSearchType().equals(PostSearchType.popular)) {
            return post.clickCount.desc();
        }
        return null;
    }
}
