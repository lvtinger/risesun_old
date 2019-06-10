package org.risesun.data.mysql.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LongTypeHandler extends AbstractTypeHandler<Long> {
    @Override
    protected void setNullParameter(PreparedStatement ps, int parameterIndex) throws SQLException {
        ps.setNull(parameterIndex, JdbcType.LONG.getTypeCode());
    }

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int parameterIndex, Long parameterValue) throws SQLException {
        ps.setLong(parameterIndex, parameterValue);
    }

    @Override
    protected Long getNonNull(ResultSet rs, String columnName) throws SQLException {
        return rs.getLong(columnName);
    }

    @Override
    protected Long getNonNull(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getLong(columnIndex);
    }
}
