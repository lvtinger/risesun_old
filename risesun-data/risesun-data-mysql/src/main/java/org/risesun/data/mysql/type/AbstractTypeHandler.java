package org.risesun.data.mysql.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractTypeHandler<T> implements TypeHandler<T> {
    @Override
    public void setParameter(PreparedStatement ps, int parameterIndex, T parameterValue, JdbcType jdbcType)
            throws SQLException {
        if (null == parameterValue) {
            setNullParameter(ps, parameterIndex);
        } else {
            setNonNullParameter(ps, parameterIndex, parameterValue);
        }
    }

    protected abstract void setNullParameter(PreparedStatement ps, int parameterIndex) throws SQLException;

    protected abstract void setNonNullParameter(PreparedStatement ps, int parameterIndex, T parameterValue)
            throws SQLException;

    @Override
    public T getResultSet(ResultSet rs, int columnIndex) throws SQLException {
        T result = getNonNull(rs, columnIndex);

        return rs.wasNull() ? null : result;
    }

    @Override
    public T getResultSet(ResultSet rs, String columnName) throws SQLException {
        T result = getNonNull(rs, columnName);

        return rs.wasNull() ? null : result;
    }

    protected abstract T getNonNull(ResultSet rs, String columnName) throws SQLException;

    protected abstract T getNonNull(ResultSet rs, int columnIndex) throws SQLException;
}