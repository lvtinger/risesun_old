package org.risesun.data.mysql.proxy;

import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;

public class RepositoryFactoryBean<T> implements FactoryBean<T> {

    private Class<T> type;

    @Setter
    private RepositoryProxyFactory factory;

    public RepositoryFactoryBean(Class<T> repositoryClass) {
        this.type = repositoryClass;
    }

    @Override
    public T getObject() {
        return factory.instance(type);
    }

    @Override
    public Class<?> getObjectType() {
        return type;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}