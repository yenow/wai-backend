package com.wai.domain.wiseSaying;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wai.controller.wiseSaying.dto.WiseSayingRequestDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.wai.domain.wiseSaying.QWiseSaying.wiseSaying1;

@Repository
public class WiseSayingCustomRepositoryImpl implements WiseSayingCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public WiseSayingCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<WiseSaying> getWiseSayings(WiseSayingRequestDto wiseSayingRequestDto) {

        return Optional.ofNullable(
            jpaQueryFactory.selectFrom(wiseSaying1)
            .where(idLessThanLastId(wiseSayingRequestDto))
            .orderBy(wiseSaying1.id.desc())
            .limit(1)
            .fetchOne()
        );
    }

    BooleanExpression idLessThanLastId(WiseSayingRequestDto wiseSayingRequestDto) {
        if (wiseSayingRequestDto.getLastId() == null) {
            return null;
        }
        return wiseSaying1.id.lt(wiseSayingRequestDto.getLastId());
    }
}
