package org.risesun.data.mysql.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IntegerTypeHandler extends AbstractTypeHandler<Integer> {
    @Override
    protected void setNullParameter(PreparedStatement ps, int parameterIndex) throws SQLException {
        ps.setNull(parameterIndex, JdbcType.INTEGER.getTypeCode());
    }

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int parameterIndex, Integer parameterValue) throws SQLException {
        ps.setInt(parameterIndex, parameterValue);
    }

    @Override
    protected Integer getNonNull(ResultSet rs, String columnName) throws SQLException {
        return rs.getInt(columnName);
    }

    @Override
    protected Integer getNonNull(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getInt(columnIndex);
    }
}
