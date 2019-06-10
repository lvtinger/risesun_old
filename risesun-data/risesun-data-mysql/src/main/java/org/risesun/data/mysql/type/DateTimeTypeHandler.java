package org.risesun.data.mysql.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTimeTypeHandler extends AbstractTypeHandler<Date> {
    @Override
    protected void setNullParameter(PreparedStatement ps, int parameterIndex) throws SQLException {
        ps.setNull(parameterIndex, JdbcType.DATETIME.getTypeCode());
    }

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int parameterIndex, Date parameterValue) throws SQLException {
        ps.setDate(parameterIndex, new java.sql.Date(parameterValue.getTime()));
    }

    @Override
    protected Date getNonNull(ResultSet rs, String columnName) throws SQLException {
        return rs.getDate(columnName);
    }

    @Override
    protected Date getNonNull(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getDate(columnIndex);
    }
}
