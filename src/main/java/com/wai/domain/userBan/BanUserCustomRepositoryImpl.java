package com.wai.domain.userBan;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wai.dto.banUser.BanUserDto;
import com.wai.dto.banUser.BanUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.wai.domain.userBan.QBanUser.banUser1;

@Repository
@RequiredArgsConstructor
public class BanUserCustomRepositoryImpl implements BanUserCustomRepository{

    final private JPAQueryFactory jpaQueryFactory;

    @Override
    public List<BanUserDto> getBanUsers(Long userId) {
        return jpaQueryFactory
            .select(
                Projections.fields(
                    BanUserDto.class,
                    banUser1.banUser.userId.as("banUserId")
                    , banUser1.banUser.nickname.as("banNickname")
                )
            )
            .from(banUser1)
            .where(banUser1.user.userId.eq(userId))
            .fetch();
    }

    @Override
    public void deleteBanUser(BanUserRequestDto banUserRequestDto) {
        jpaQueryFactory.delete(banUser1)
            .where(banUser1.user.userId.eq(banUserRequestDto.getUserId())
                .and(banUser1.banUser.userId.eq(banUserRequestDto.getBanUserId())))
            .execute();
    }

    @Override
    public Optional<BanUser> findByUserIdAndBanUserId(BanUserRequestDto banUserRequestDto) {
        return Optional.ofNullable(jpaQueryFactory
            .select(
                banUser1
            )
            .from(banUser1)
            .where(banUser1.user.userId.eq(banUserRequestDto.getUserId())
                    .and(banUser1.banUser.userId.eq(banUserRequestDto.getBanUserId())))
            .fetchOne()
        );
    }
}
