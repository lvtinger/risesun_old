package org.risesun.data.mysql.context;

import org.risesun.data.mysql.meta.bean.Metadata;

import java.sql.Connection;

public interface DataContext {
    Metadata getMetadata(Class<?> type);

    Connection getConnection(String name);
}