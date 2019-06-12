package org.risesun.data.mysql.executor;

import org.risesun.data.mysql.context.DataContext;

import java.lang.reflect.Method;

public interface StatementMethodFactory {
    StatementMethod build(DataContext context, Method method);
}