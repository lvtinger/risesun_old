package org.risesun.data.mysql.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringTypeHandler extends AbstractTypeHandler<String> {
    @Override
    protected void setNullParameter(PreparedStatement ps, int parameterIndex) throws SQLException {
        ps.setNull(parameterIndex, JdbcType.STRING.getTypeCode());
    }

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int parameterIndex, String parameterValue) throws SQLException {
        ps.setString(parameterIndex, parameterValue);
    }

    @Override
    protected String getNonNull(ResultSet rs, String columnName) throws SQLException {
        return rs.getString(columnName);
    }

    @Override
    protected String getNonNull(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getString(columnIndex);
    }
}
