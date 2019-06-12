package org.risesun.data.mysql.proxy;

import org.risesun.data.mysql.context.DataContext;

import java.lang.reflect.Proxy;

public class RepositoryProxyFactory {
    public static <T> T instance(Class<T> proxyInterface, DataContext context) {
        ClassLoader classLoader = proxyInterface.getClassLoader();
        Class[] interfaces = new Class[]{proxyInterface};
        RepositoryProxy proxy = new RepositoryProxy(context);
        return (T) Proxy.newProxyInstance(classLoader, interfaces, proxy);
    }
}