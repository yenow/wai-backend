package com.wai.domain.enneagramTest;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEnneagramTest is a Querydsl query type for EnneagramTest
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEnneagramTest extends EntityPathBase<EnneagramTest> {

    private static final long serialVersionUID = 1986546392L;

    public static final QEnneagramTest enneagramTest = new QEnneagramTest("enneagramTest");

    public final com.wai.common.QBaseEntity _super = new com.wai.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> insert_date = _super.insert_date;

    //inherited
    public final StringPath insert_id = _super.insert_id;

    public final NumberPath<Integer> selectedEnneagramType = createNumber("selectedEnneagramType", Integer.class);

    public final NumberPath<Long> testId = createNumber("testId", Long.class);

    public final EnumPath<TestType> testType = createEnum("testType", TestType.class);

    public final NumberPath<Integer> type1Score = createNumber("type1Score", Integer.class);

    public final NumberPath<Integer> type2Score = createNumber("type2Score", Integer.class);

    public final NumberPath<Integer> type3Score = createNumber("type3Score", Integer.class);

    public final NumberPath<Integer> type4Score = createNumber("type4Score", Integer.class);

    public final NumberPath<Integer> type5Score = createNumber("type5Score", Integer.class);

    public final NumberPath<Integer> type6Score = createNumber("type6Score", Integer.class);

    public final NumberPath<Integer> type7Score = createNumber("type7Score", Integer.class);

    public final NumberPath<Integer> type8Score = createNumber("type8Score", Integer.class);

    public final NumberPath<Integer> type9Score = createNumber("type9Score", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> update_date = _super.update_date;

    //inherited
    public final StringPath update_id = _super.update_id;

    public final ListPath<com.wai.domain.userEnneagramTest.UserEnneagramTest, com.wai.domain.userEnneagramTest.QUserEnneagramTest> userEnneagramTests = this.<com.wai.domain.userEnneagramTest.UserEnneagramTest, com.wai.domain.userEnneagramTest.QUserEnneagramTest>createList("userEnneagramTests", com.wai.domain.userEnneagramTest.UserEnneagramTest.class, com.wai.domain.userEnneagramTest.QUserEnneagramTest.class, PathInits.DIRECT2);

    public QEnneagramTest(String variable) {
        super(EnneagramTest.class, forVariable(variable));
    }

    public QEnneagramTest(Path<? extends EnneagramTest> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEnneagramTest(PathMetadata metadata) {
        super(EnneagramTest.class, metadata);
    }

}

