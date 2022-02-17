package com.wai.domain.enneagramQuestion;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wai.domain.enneagramTest.TestType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EnneagramQuestionCustomRepositoryImpl implements EnneagramQuestionCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<EnneagramQuestion> findByTestType(TestType testType) {
        QEnneagramQuestion enneagramQuestion = QEnneagramQuestion.enneagramQuestion;

        return jpaQueryFactory
                .selectFrom(enneagramQuestion)
                .where(enneagramQuestion.testType.eq(testType))
                .orderBy(Expressions.numberTemplate(Double.class, "function('rand')").asc())
                .fetch();
    }
}
