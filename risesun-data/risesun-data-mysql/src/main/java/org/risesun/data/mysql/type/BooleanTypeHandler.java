package org.risesun.data.mysql.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BooleanTypeHandler extends AbstractTypeHandler<Boolean> {
    @Override
    protected void setNullParameter(PreparedStatement ps, int parameterIndex) throws SQLException {
        ps.setNull(parameterIndex, JdbcType.BOOLEAN.getTypeCode());
    }

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int parameterIndex, Boolean parameterValue) throws SQLException {
        ps.setBoolean(parameterIndex, parameterValue);
    }

    @Override
    protected Boolean getNonNull(ResultSet rs, String columnName) throws SQLException {
        return rs.getBoolean(columnName);
    }

    @Override
    protected Boolean getNonNull(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getBoolean(columnIndex);
    }
}
