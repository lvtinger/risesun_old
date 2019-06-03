package org.risesun.data.mysql.proxy;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class RepositoryFactoryBean<T> implements FactoryBean<T>, InitializingBean {

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

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("INIT");
    }
}
