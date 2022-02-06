package com.wai.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1716522752L;

    public static final QUser user = new QUser("user");

    public final com.wai.common.QBaseEntity _super = new com.wai.common.QBaseEntity(this);

    public final StringPath birthDay = createString("birthDay");

    public final StringPath email = createString("email");

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> insertDate = _super.insertDate;

    //inherited
    public final NumberPath<Long> insertId = _super.insertId;

    public final ListPath<com.wai.domain.likey.Likey, com.wai.domain.likey.QLikey> likeys = this.<com.wai.domain.likey.Likey, com.wai.domain.likey.QLikey>createList("likeys", com.wai.domain.likey.Likey.class, com.wai.domain.likey.QLikey.class, PathInits.DIRECT2);

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final ListPath<com.wai.domain.post.Post, com.wai.domain.post.QPost> posts = this.<com.wai.domain.post.Post, com.wai.domain.post.QPost>createList("posts", com.wai.domain.post.Post.class, com.wai.domain.post.QPost.class, PathInits.DIRECT2);

    public final ListPath<com.wai.domain.reply.Reply, com.wai.domain.reply.QReply> replys = this.<com.wai.domain.reply.Reply, com.wai.domain.reply.QReply>createList("replys", com.wai.domain.reply.Reply.class, com.wai.domain.reply.QReply.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    //inherited
    public final NumberPath<Long> updateId = _super.updateId;

    public final ListPath<com.wai.domain.userEnneagramTest.UserEnneagramTest, com.wai.domain.userEnneagramTest.QUserEnneagramTest> userEnneagramTests = this.<com.wai.domain.userEnneagramTest.UserEnneagramTest, com.wai.domain.userEnneagramTest.QUserEnneagramTest>createList("userEnneagramTests", com.wai.domain.userEnneagramTest.UserEnneagramTest.class, com.wai.domain.userEnneagramTest.QUserEnneagramTest.class, PathInits.DIRECT2);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userKey = createString("userKey");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

