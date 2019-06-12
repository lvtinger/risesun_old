package org.risesun.data.mysql.proxy;

public interface RepositoryProxyFactory {
    <T> T instance(Class<?> type);
}
