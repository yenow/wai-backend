package com.wai.domain.user;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wai.controller.user.dto.UserDto;
import com.wai.controller.user.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import static com.wai.domain.enneagramTest.QEnneagramTest.enneagramTest;
import static com.wai.domain.post.QPost.post;
import static com.wai.domain.user.QUser.user;
import static com.wai.domain.userEnneagramTest.QUserEnneagramTest.userEnneagramTest;


@RequiredArgsConstructor
@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public User findByEmail(String id) {
        return jpaQueryFactory.selectFrom(user)
                .where(user.email.eq(id))
                .fetchOne();
    }

    @Override
    public Optional<User> findByUserKey(String userKey) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(user)
                .where(user.userKey.eq(userKey))
                .fetchOne());
    }

    @Override
    public Optional<User> findByNickname(String nickname) {
        return Optional.ofNullable(
            jpaQueryFactory.selectFrom(user)
                .where(user.nickname.eq(nickname))
                .fetchOne()
        );
    }

    @Override
    public Optional<User> getUserInformation(UserRequestDto userRequestDto) {
        return Optional.ofNullable(
            jpaQueryFactory.
                    select(user)
                    .from(user)
                    .distinct()
                    .leftJoin(user.posts, post)
                    .leftJoin(user.userEnneagramTests, userEnneagramTest).fetchJoin()
                    .leftJoin(userEnneagramTest.enneagramTest, enneagramTest).fetchJoin()
                    .where(user.userKey.eq(userRequestDto.getUserKey()))
                    .orderBy(enneagramTest.testId.desc())
                    .fetchOne()
        );
    }

    @Override
    public Optional<UserDto> getUserDtoInformation(UserRequestDto userRequestDto) {

        return Optional.ofNullable(
            jpaQueryFactory.
            select(Projections.bean(UserDto.class
                    ,user.userId
                    ,user.userKey
                    ,user.nickname
                    ,user.posts
            )).distinct()
            .from(user)
            .leftJoin(user.posts, post)
            .leftJoin(user.userEnneagramTests, userEnneagramTest)
            .leftJoin(userEnneagramTest.enneagramTest, enneagramTest)
            .where(user.userKey.eq(userRequestDto.getUserKey()))
            .fetchOne()
        );
    }

    @Override
    public void deleteByUserKey(String userKey) {
        QUser user = new QUser("u");

        jpaQueryFactory.delete(user)
                .where(user.userKey.eq(userKey))
                .execute();;
    }
}
