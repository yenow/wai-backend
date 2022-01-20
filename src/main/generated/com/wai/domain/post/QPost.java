package com.wai.domain.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = -53236192L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final com.wai.common.QBaseEntity _super = new com.wai.common.QBaseEntity(this);

    public final NumberPath<Integer> clickCount = createNumber("clickCount", Integer.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> insert_date = _super.insert_date;

    //inherited
    public final StringPath insert_id = _super.insert_id;

    public final BooleanPath isDelete = createBoolean("isDelete");

    public final NumberPath<Long> postId = createNumber("postId", Long.class);

    public final ListPath<com.wai.domain.reply.Reply, com.wai.domain.reply.QReply> replys = this.<com.wai.domain.reply.Reply, com.wai.domain.reply.QReply>createList("replys", com.wai.domain.reply.Reply.class, com.wai.domain.reply.QReply.class, PathInits.DIRECT2);

    public final ListPath<com.wai.domain.tag.Tag, com.wai.domain.tag.QTag> tags = this.<com.wai.domain.tag.Tag, com.wai.domain.tag.QTag>createList("tags", com.wai.domain.tag.Tag.class, com.wai.domain.tag.QTag.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> update_date = _super.update_date;

    //inherited
    public final StringPath update_id = _super.update_id;

    public final com.wai.domain.user.QUser user;

    public QPost(String variable) {
        this(Post.class, forVariable(variable), INITS);
    }

    public QPost(Path<? extends Post> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPost(PathMetadata metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.wai.domain.user.QUser(forProperty("user")) : null;
    }

}

