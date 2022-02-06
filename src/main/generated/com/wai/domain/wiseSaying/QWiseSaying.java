package com.wai.domain.wiseSaying;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWiseSaying is a Querydsl query type for WiseSaying
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWiseSaying extends EntityPathBase<WiseSaying> {

    private static final long serialVersionUID = 600884672L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWiseSaying wiseSaying1 = new QWiseSaying("wiseSaying1");

    public final com.wai.common.QBaseEntity _super = new com.wai.common.QBaseEntity(this);

    public final StringPath author = createString("author");

    public final com.wai.domain.enneagram.QEnneagram enneagram;

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

    public final StringPath wiseSaying = createString("wiseSaying");

    public QWiseSaying(String variable) {
        this(WiseSaying.class, forVariable(variable), INITS);
    }

    public QWiseSaying(Path<? extends WiseSaying> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWiseSaying(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWiseSaying(PathMetadata metadata, PathInits inits) {
        this(WiseSaying.class, metadata, inits);
    }

    public QWiseSaying(Class<? extends WiseSaying> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.enneagram = inits.isInitialized("enneagram") ? new com.wai.domain.enneagram.QEnneagram(forProperty("enneagram")) : null;
        this.user = inits.isInitialized("user") ? new com.wai.domain.user.QUser(forProperty("user")) : null;
    }

}

