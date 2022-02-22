package com.wai.domain.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@RequiredArgsConstructor
@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public User findByEmail(String id) {
        QUser user = new QUser("u");

        return jpaQueryFactory.selectFrom(user)
                .where(user.email.eq(id))
                .fetchOne();
    }

    @Override
    public Optional<User> findByUserKey(String userKey) {
        QUser user = new QUser("u");

        return Optional.ofNullable(jpaQueryFactory.selectFrom(user)
                .where(user.userKey.eq(userKey))
                .fetchOne());
    }

    @Override
    public Optional<User> findByNickname(String nickname) {
        QUser user = QUser.user;

        return Optional.ofNullable(
            jpaQueryFactory.selectFrom(user)
                .where(user.nickname.eq(nickname))
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