package org.risesun.data.mysql.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface TypeHandler<T> {
    void setParameter(PreparedStatement ps, int parameterIndex, T parameterValue, JdbcType jdbcType) throws SQLException;

    T getResultSet(ResultSet rs, int columnIndex) throws SQLException;

    T getResultSet(ResultSet rs, String columnName) throws SQLException;
}
