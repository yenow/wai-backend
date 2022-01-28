package com.wai.domain.enneagram;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEnneagram is a Querydsl query type for Enneagram
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEnneagram extends EntityPathBase<Enneagram> {

    private static final long serialVersionUID = 1158207476L;

    public static final QEnneagram enneagram = new QEnneagram("enneagram");

    public final StringPath animalName = createString("animalName");

    public final NumberPath<Integer> enneagramType = createNumber("enneagramType", Integer.class);

    public final StringPath imagePath = createString("imagePath");

    public final StringPath simpleExplain = createString("simpleExplain");

    public final StringPath simpleExplain2 = createString("simpleExplain2");

    public final StringPath subName = createString("subName");

    public QEnneagram(String variable) {
        super(Enneagram.class, forVariable(variable));
    }

    public QEnneagram(Path<? extends Enneagram> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEnneagram(PathMetadata metadata) {
        super(Enneagram.class, metadata);
    }

}

