package com.wai.domain.enneagramQuestion;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEnneagramQuestion is a Querydsl query type for EnneagramQuestion
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEnneagramQuestion extends EntityPathBase<EnneagramQuestion> {

    private static final long serialVersionUID = -986110848L;

    public static final QEnneagramQuestion enneagramQuestion = new QEnneagramQuestion("enneagramQuestion");

    public final NumberPath<Integer> enneagramType = createNumber("enneagramType", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath question = createString("question");

    public final NumberPath<Integer> questionNumber = createNumber("questionNumber", Integer.class);

    public final EnumPath<com.wai.domain.enneagramTest.TestType> testType = createEnum("testType", com.wai.domain.enneagramTest.TestType.class);

    public final StringPath uniqueString = createString("uniqueString");

    public QEnneagramQuestion(String variable) {
        super(EnneagramQuestion.class, forVariable(variable));
    }

    public QEnneagramQuestion(Path<? extends EnneagramQuestion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEnneagramQuestion(PathMetadata metadata) {
        super(EnneagramQuestion.class, metadata);
    }

}

