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

    public final NumberPath<Long> Id = createNumber("Id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> insert_date = _super.insert_date;

    //inherited
    public final NumberPath<Long> insert_id = _super.insert_id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> update_date = _super.update_date;

    //inherited
    public final NumberPath<Long> update_id = _super.update_id;

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
        this.user = inits.isInitialized("user") ? new com.wai.domain.user.QUser(forProperty("user")) : null;
    }

}

