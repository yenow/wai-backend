package com.wai.domain.follow;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFollow is a Querydsl query type for Follow
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFollow extends EntityPathBase<Follow> {

    private static final long serialVersionUID = -1463804800L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFollow follow = new QFollow("follow");

    public final com.wai.common.QBaseEntity _super = new com.wai.common.QBaseEntity(this);

    public final com.wai.domain.user.QUser followee;

    public final com.wai.domain.user.QUser follower;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> insert_date = _super.insert_date;

    //inherited
    public final StringPath insert_id = _super.insert_id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> update_date = _super.update_date;

    //inherited
    public final StringPath update_id = _super.update_id;

    public QFollow(String variable) {
        this(Follow.class, forVariable(variable), INITS);
    }

    public QFollow(Path<? extends Follow> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFollow(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFollow(PathMetadata metadata, PathInits inits) {
        this(Follow.class, metadata, inits);
    }

    public QFollow(Class<? extends Follow> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.followee = inits.isInitialized("followee") ? new com.wai.domain.user.QUser(forProperty("followee")) : null;
        this.follower = inits.isInitialized("follower") ? new com.wai.domain.user.QUser(forProperty("follower")) : null;
    }

}

