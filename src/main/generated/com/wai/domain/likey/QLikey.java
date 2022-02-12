package com.wai.domain.likey;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLikey is a Querydsl query type for Likey
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLikey extends EntityPathBase<Likey> {

    private static final long serialVersionUID = -1803756856L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLikey likey = new QLikey("likey");

    public final com.wai.common.QBaseEntity _super = new com.wai.common.QBaseEntity(this);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> insertDate = _super.insertDate;

    //inherited
    public final NumberPath<Long> insertId = _super.insertId;

    public final com.wai.domain.post.QPost post;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    //inherited
    public final NumberPath<Long> updateId = _super.updateId;

    public final com.wai.domain.user.QUser user;

    public QLikey(String variable) {
        this(Likey.class, forVariable(variable), INITS);
    }

    public QLikey(Path<? extends Likey> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLikey(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLikey(PathMetadata metadata, PathInits inits) {
        this(Likey.class, metadata, inits);
    }

    public QLikey(Class<? extends Likey> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new com.wai.domain.post.QPost(forProperty("post"), inits.get("post")) : null;
        this.user = inits.isInitialized("user") ? new com.wai.domain.user.QUser(forProperty("user")) : null;
    }

}

