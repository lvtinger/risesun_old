package org.risesun.data.mysql.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RepositoryProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        return null;
    }

    public static <T> T instance(Class<T> proxyInterface) {
        ClassLoader classLoader = proxyInterface.getClassLoader();
        Class[] interfaces = new Class[]{proxyInterface};
        RepositoryProxy proxy = new RepositoryProxy();
        return (T) Proxy.newProxyInstance(classLoader, interfaces, proxy);
    }
}
