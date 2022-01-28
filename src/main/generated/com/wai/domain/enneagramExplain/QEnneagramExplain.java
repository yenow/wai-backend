package com.wai.domain.enneagramExplain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEnneagramExplain is a Querydsl query type for EnneagramExplain
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEnneagramExplain extends EntityPathBase<EnneagramExplain> {

    private static final long serialVersionUID = -774208256L;

    public static final QEnneagramExplain enneagramExplain = new QEnneagramExplain("enneagramExplain");

    public final StringPath basicExplains = createString("basicExplains");

    public final StringPath comfortSentences = createString("comfortSentences");

    public final StringPath demerits = createString("demerits");

    public final NumberPath<Integer> enneagramType = createNumber("enneagramType", Integer.class);

    public final StringPath friendWays = createString("friendWays");

    public final StringPath hardWorks = createString("hardWorks");

    public final StringPath humanRelations = createString("humanRelations");

    public final StringPath merits = createString("merits");

    public final StringPath surroundingEvaluations = createString("surroundingEvaluations");

    public QEnneagramExplain(String variable) {
        super(EnneagramExplain.class, forVariable(variable));
    }

    public QEnneagramExplain(Path<? extends EnneagramExplain> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEnneagramExplain(PathMetadata metadata) {
        super(EnneagramExplain.class, metadata);
    }

}

