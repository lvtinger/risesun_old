package org.risesun.data.mysql.executor;

import java.lang.reflect.Method;

public class MethodExecutorFactory {
    public static StatementMethod build(Method method) {
        return new StatementMethod();
    }
}
