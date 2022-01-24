package com.wai.domain.reply;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReply is a Querydsl query type for Reply
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReply extends EntityPathBase<Reply> {

    private static final long serialVersionUID = -41649384L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReply reply = new QReply("reply");

    public final com.wai.common.QBaseEntity _super = new com.wai.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> insert_date = _super.insert_date;

    //inherited
    public final NumberPath<Long> insert_id = _super.insert_id;

    public final NumberPath<Long> parentReplyId = createNumber("parentReplyId", Long.class);

    public final com.wai.domain.post.QPost post;

    public final StringPath replyContent = createString("replyContent");

    public final NumberPath<Long> replyId = createNumber("replyId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> update_date = _super.update_date;

    //inherited
    public final NumberPath<Long> update_id = _super.update_id;

    public final com.wai.domain.user.QUser user;

    public QReply(String variable) {
        this(Reply.class, forVariable(variable), INITS);
    }

    public QReply(Path<? extends Reply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReply(PathMetadata metadata, PathInits inits) {
        this(Reply.class, metadata, inits);
    }

    public QReply(Class<? extends Reply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new com.wai.domain.post.QPost(forProperty("post"), inits.get("post")) : null;
        this.user = inits.isInitialized("user") ? new com.wai.domain.user.QUser(forProperty("user")) : null;
    }

}

