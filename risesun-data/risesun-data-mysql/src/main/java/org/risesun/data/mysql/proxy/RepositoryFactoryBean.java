package org.risesun.data.mysql.proxy;

import org.springframework.beans.factory.FactoryBean;

public class RepositoryFactoryBean<T> implements FactoryBean<T> {

    private Class<T> repositoryClass;

    public RepositoryFactoryBean(Class<T> repositoryClass) {
        this.repositoryClass = repositoryClass;
    }

    @Override
    public T getObject() throws Exception {
        return RepositoryProxy.instance(repositoryClass);
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