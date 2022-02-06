package com.wai.domain.userEnneagramTest;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserEnneagramTest is a Querydsl query type for UserEnneagramTest
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserEnneagramTest extends EntityPathBase<UserEnneagramTest> {

    private static final long serialVersionUID = 460059522L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserEnneagramTest userEnneagramTest = new QUserEnneagramTest("userEnneagramTest");

    public final com.wai.common.QBaseEntity _super = new com.wai.common.QBaseEntity(this);

    public final com.wai.domain.enneagramTest.QEnneagramTest enneagramTest;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> insertDate = _super.insertDate;

    //inherited
    public final NumberPath<Long> insertId = _super.insertId;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    //inherited
    public final NumberPath<Long> updateId = _super.updateId;

    public final com.wai.domain.user.QUser user;

    public QUserEnneagramTest(String variable) {
        this(UserEnneagramTest.class, forVariable(variable), INITS);
    }

    public QUserEnneagramTest(Path<? extends UserEnneagramTest> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserEnneagramTest(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserEnneagramTest(PathMetadata metadata, PathInits inits) {
        this(UserEnneagramTest.class, metadata, inits);
    }

    public QUserEnneagramTest(Class<? extends UserEnneagramTest> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.enneagramTest = inits.isInitialized("enneagramTest") ? new com.wai.domain.enneagramTest.QEnneagramTest(forProperty("enneagramTest")) : null;
        this.user = inits.isInitialized("user") ? new com.wai.domain.user.QUser(forProperty("user")) : null;
    }

}

