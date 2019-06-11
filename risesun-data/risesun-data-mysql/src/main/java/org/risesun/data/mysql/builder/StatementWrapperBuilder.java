package org.risesun.data.mysql.builder;

import org.risesun.data.mysql.ApplicationDataContext;
import org.risesun.data.mysql.annotation.Mapper;
import org.risesun.data.mysql.meta.bean.Metadata;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

public final class StatementWrapperBuilder {
    private final ApplicationDataContext context;

    public StatementWrapperBuilder(ApplicationDataContext context) {
        this.context = context;
    }

    public StatementWrapper build(Method method) {
        Mapper mapper = method.getAnnotation(Mapper.class);
        if (null != mapper) {
            return dynamicStatementWrapper(method);
        }

        String name = method.getName();
        if ("create".equals(name)) {
            return createStatementWrapper(method);
        } else if ("update".equals(name)) {
            return updateStatementWrapper(method);
        } else if ("delete".equals(name)) {
            return deleteStatementWrapper(method);
        }

        return selectStatementWrapper(method);
    }

    private StatementWrapper dynamicStatementWrapper(Method method) {
        return null;
    }

    private StatementWrapper createStatementWrapper(Method method) {
        Metadata metadata = getMetadata(method);

        return null;
    }

    private StatementWrapper updateStatementWrapper(Method method) {
        return null;
    }

    private StatementWrapper deleteStatementWrapper(Method method) {
        return null;
    }

    private StatementWrapper selectStatementWrapper(Method method) {
        return null;
    }

    private Metadata getMetadata(Method method) {
        ParameterizedType type = (ParameterizedType) method.getDeclaringClass().getGenericSuperclass();
        Class<?> metaType = (Class<?>) type.getActualTypeArguments()[0];
        Metadata metadata = this.context.getMetadata(metaType);
        return metadata;
    }
}
