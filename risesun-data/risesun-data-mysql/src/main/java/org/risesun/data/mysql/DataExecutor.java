package org.risesun.data.mysql;

public interface DataExecutor {
    void commit();

    void rollback();
}