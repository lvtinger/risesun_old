package org.risesun.data.mysql.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FloatTypeHandler extends AbstractTypeHandler<Float> {
    @Override
    protected void setNullParameter(PreparedStatement ps, int parameterIndex) throws SQLException {
        ps.setNull(parameterIndex, JdbcType.FLOAT.getTypeCode());
    }

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int parameterIndex, Float parameterValue)
            throws SQLException {
        ps.setFloat(parameterIndex, parameterValue);
    }

    @Override
    protected Float getNonNull(ResultSet rs, String columnName) throws SQLException {
        return rs.getFloat(columnName);
    }

    @Override
    protected Float getNonNull(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getFloat(columnIndex);
    }
}
