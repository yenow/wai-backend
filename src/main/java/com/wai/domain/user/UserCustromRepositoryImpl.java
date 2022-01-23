package com.wai.domain.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * packageName : com.wai.domain.user
 * fileName : UserCustromRepositoryImpl
 * author : 윤신영
 * date : 2021-12-22
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2021-12-22   윤신영     최초 생성
 */
@RequiredArgsConstructor
@Repository
public class UserCustromRepositoryImpl implements UserCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public User findByEmail(String id) {
        QUser user = new QUser("u");

        return jpaQueryFactory.selectFrom(user)
                .where(user.email.eq(id))
                .fetchOne();
    }

    @Override
    public User findByPhoneNumber(String id) {
        QUser user = new QUser("u");

        return jpaQueryFactory.selectFrom(user)
                .where(user.phoneNumber.eq(id))
                .fetchOne();
    }

    @Override
    public User findByUserKey(String userKey) {
        QUser user = new QUser("u");

        return jpaQueryFactory.selectFrom(user)
                .where(user.userKey.eq(userKey))
                .fetchOne();
    }

    @Override
    public void deleteByUserKey(String userKey) {
        QUser user = new QUser("u");

        jpaQueryFactory.delete(user)
                .where(user.userKey.eq(userKey))
                .execute();;
    }
}
