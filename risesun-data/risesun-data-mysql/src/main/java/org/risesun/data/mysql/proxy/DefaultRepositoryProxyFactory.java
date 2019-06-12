package org.risesun.data.mysql.proxy;

import org.risesun.common.utils.ClassUtils;
import org.risesun.data.mysql.context.DataContext;

import java.lang.reflect.Proxy;

public class DefaultRepositoryProxyFactory implements RepositoryProxyFactory {

    private final DataContext context;
    private final ClassLoader classLoader;

    public DefaultRepositoryProxyFactory(DataContext context) {
        this.context = context;
        this.classLoader = ClassUtils.getDefaultClassLoader();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T instance(Class<?> type) {
        RepositoryProxy proxy = new RepositoryProxy(this.context);
        return (T) Proxy.newProxyInstance(this.classLoader, new Class[]{type}, proxy);
    }
}