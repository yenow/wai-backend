package com.wai.domain.tag;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTag is a Querydsl query type for Tag
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTag extends EntityPathBase<Tag> {

    private static final long serialVersionUID = 928201848L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTag tag = new QTag("tag");

    public final com.wai.common.QBaseEntity _super = new com.wai.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> insert_date = _super.insert_date;

    //inherited
    public final StringPath insert_id = _super.insert_id;

    public final com.wai.domain.post.QPost post;

    public final NumberPath<Long> tagId = createNumber("tagId", Long.class);

    public final StringPath tagName = createString("tagName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> update_date = _super.update_date;

    //inherited
    public final StringPath update_id = _super.update_id;

    public QTag(String variable) {
        this(Tag.class, forVariable(variable), INITS);
    }

    public QTag(Path<? extends Tag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTag(PathMetadata metadata, PathInits inits) {
        this(Tag.class, metadata, inits);
    }

    public QTag(Class<? extends Tag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new com.wai.domain.post.QPost(forProperty("post"), inits.get("post")) : null;
    }

}

