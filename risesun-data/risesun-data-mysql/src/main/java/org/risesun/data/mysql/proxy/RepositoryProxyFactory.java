package org.risesun.data.mysql.proxy;

import java.lang.reflect.Proxy;

public class RepositoryProxyFactory {
    public static <T> T instance(Class<T> proxyInterface) {
        ClassLoader classLoader = proxyInterface.getClassLoader();
        Class[] interfaces = new Class[]{proxyInterface};
        RepositoryProxy proxy = new RepositoryProxy();
        return (T) Proxy.newProxyInstance(classLoader, interfaces, proxy);
    }
}