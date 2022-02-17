package com.wai.domain.wiseSaying;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wai.controller.wiseSaying.dto.WiseSayingRequestDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WiseSayingCustomRepositoryImpl implements WiseSayingCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public WiseSayingCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<WiseSaying> getWiseSayings(WiseSayingRequestDto wiseSayingRequestDto) {
        QWiseSaying qWiseSaying = QWiseSaying.wiseSaying1;
        return Optional.ofNullable(
            jpaQueryFactory.selectFrom(qWiseSaying)
            .where(idLessThanLastId(wiseSayingRequestDto))
            .orderBy(qWiseSaying.id.desc())
            .limit(1)
            .fetchOne()
        );
    }

    BooleanExpression idLessThanLastId(WiseSayingRequestDto wiseSayingRequestDto) {
        QWiseSaying qWiseSaying = QWiseSaying.wiseSaying1;
        if (wiseSayingRequestDto.getLastId() == null) {
            return null;
        }
        return qWiseSaying.id.lt(wiseSayingRequestDto.getLastId());
    }
}
