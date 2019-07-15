package org.risesun.data.mysql.proxy;

import org.risesun.data.mysql.context.DataContext;
import org.risesun.data.mysql.executor.StatementMethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class RepositoryProxy implements InvocationHandler {

    private final DataContext context;

    private final Map<Method, StatementMethod> cached;

    public RepositoryProxy(DataContext context, Map<Method, StatementMethod> cached) {
        this.context = context;
        this.cached = cached;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (proxy.getClass().equals(method.getDeclaringClass())) {
            try {
                return method.invoke(proxy, args);
            } catch (Throwable t) {
                throw new RuntimeException(t);
            }
        }

        StatementMethod executor = cached.get(method);
        if (null == executor) {
            throw new RuntimeException();
        }
        return null;
    }
}
