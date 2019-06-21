package org.risesun.data.mysql.executor;

import org.risesun.data.mysql.annotation.Query;
import org.risesun.data.mysql.annotation.Repository;
import org.risesun.data.mysql.context.DataContext;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class MysqlStatementMethodFactory implements StatementMethodFactory {
    @Override
    public StatementMethod build(DataContext context, Method method) {

        Class<?> $class = method.getDeclaringClass();
        if (!$class.isAssignableFrom(Repository.class)) {
            throw new RuntimeException();
        }

        ParameterizedType type = (ParameterizedType) $class.getGenericInterfaces()[0];
        Type argument = type.getActualTypeArguments()[0];

        Query query = method.getAnnotation(Query.class);
        if (null != query) {
        }

        String name = method.getName();
        if ("create".equals(name)) {
        } else if ("update".equals(name)) {
        } else if ("delete".equals(name)) {
        } else if (name.startsWith("findBy")) {
        } else {
            throw new RuntimeException();
        }
        return null;
    }
}
