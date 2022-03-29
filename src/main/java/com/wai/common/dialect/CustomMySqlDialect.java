package com.wai.common.dialect;

import org.hibernate.dialect.MySQL8Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class CustomMySqlDialect extends MySQL8Dialect {

    public CustomMySqlDialect() {
        registerFunction("getTagString", new StandardSQLFunction("getTagString", StandardBasicTypes.STRING));
    }
}
