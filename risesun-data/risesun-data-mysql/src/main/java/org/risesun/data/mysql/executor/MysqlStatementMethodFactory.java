package org.risesun.data.mysql.executor;

import org.risesun.data.mysql.context.DataContext;

import java.lang.reflect.Method;

public class MysqlStatementMethodFactory implements StatementMethodFactory {
    @Override
    public StatementMethod build(DataContext context, Method method) {
        return null;
    }
}