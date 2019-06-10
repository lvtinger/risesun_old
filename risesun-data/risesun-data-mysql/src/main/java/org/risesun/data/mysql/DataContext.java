package org.risesun.data.mysql;

import java.sql.Connection;

public interface DataContext {
    Connection connection();

    void commit();

    void rollback();
}