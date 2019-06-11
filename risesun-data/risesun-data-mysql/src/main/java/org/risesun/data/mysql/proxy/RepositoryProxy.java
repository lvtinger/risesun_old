package org.risesun.data.mysql.proxy;

import org.risesun.data.mysql.executor.MethodExecutor;
import org.risesun.data.mysql.executor.MethodExecutorFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RepositoryProxy implements InvocationHandler {

    private Map<Method, MethodExecutor> cached = new ConcurrentHashMap<>();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (proxy.getClass().equals(method.getDeclaringClass())) {
            try {
                return method.invoke(proxy, args);
            } catch (Throwable t) {
                throw new RuntimeException(t);
            }
        }

        MethodExecutor executor = cachedMethod(method);
        return executor.execute(args);
    }

    private MethodExecutor cachedMethod(Method method) {
        MethodExecutor executor = cached.get(method);
        if (null == executor) {
            executor = MethodExecutorFactory.build();
            cached.put(method, executor);
        }
        return executor;
    }
}