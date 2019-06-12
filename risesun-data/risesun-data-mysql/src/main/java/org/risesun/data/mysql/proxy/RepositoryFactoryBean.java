package org.risesun.data.mysql.proxy;

import lombok.Setter;
import org.risesun.data.mysql.context.DataContext;
import org.springframework.beans.factory.FactoryBean;

public class RepositoryFactoryBean<T> implements FactoryBean<T> {

    private Class<T> repositoryClass;

    @Setter
    private DataContext context;

    public RepositoryFactoryBean(Class<T> repositoryClass) {
        this.repositoryClass = repositoryClass;
    }

    @Override
    public T getObject() {
        return RepositoryProxyFactory.instance(repositoryClass, context);
    }

    @Override
    public Class<?> getObjectType() {
        return repositoryClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}