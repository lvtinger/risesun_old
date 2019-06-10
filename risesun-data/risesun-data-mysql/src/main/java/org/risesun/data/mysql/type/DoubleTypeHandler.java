package org.risesun.data.mysql.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoubleTypeHandler extends AbstractTypeHandler<Double> {
    @Override
    protected void setNullParameter(PreparedStatement ps, int parameterIndex) throws SQLException {
        ps.setNull(parameterIndex, JdbcType.DOUBLE.getTypeCode());
    }

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int parameterIndex, Double parameterValue) throws SQLException {
        ps.setDouble(parameterIndex, parameterValue);
    }

    @Override
    protected Double getNonNull(ResultSet rs, String columnName) throws SQLException {
        return rs.getDouble(columnName);
    }

    @Override
    protected Double getNonNull(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getDouble(columnIndex);
    }
}
