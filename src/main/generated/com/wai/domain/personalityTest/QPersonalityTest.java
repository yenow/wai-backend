package com.wai.domain.personalityTest;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPersonalityTest is a Querydsl query type for PersonalityTest
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPersonalityTest extends EntityPathBase<PersonalityTest> {

    private static final long serialVersionUID = -230039164L;

    public static final QPersonalityTest personalityTest = new QPersonalityTest("personalityTest");

    public final com.wai.common.QBaseEntity _super = new com.wai.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> insert_date = _super.insert_date;

    //inherited
    public final StringPath insert_id = _super.insert_id;

    public final DateTimePath<java.time.LocalDateTime> testDate = createDateTime("testDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> testId = createNumber("testId", Long.class);

    public final EnumPath<TestType> testType = createEnum("testType", TestType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> update_date = _super.update_date;

    //inherited
    public final StringPath update_id = _super.update_id;

    public QPersonalityTest(String variable) {
        super(PersonalityTest.class, forVariable(variable));
    }

    public QPersonalityTest(Path<? extends PersonalityTest> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPersonalityTest(PathMetadata metadata) {
        super(PersonalityTest.class, metadata);
    }

}

