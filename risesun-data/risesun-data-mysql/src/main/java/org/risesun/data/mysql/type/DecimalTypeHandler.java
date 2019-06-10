package org.risesun.data.mysql.type;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DecimalTypeHandler extends AbstractTypeHandler<BigDecimal> {
    @Override
    protected void setNullParameter(PreparedStatement ps, int parameterIndex) throws SQLException {
        ps.setNull(parameterIndex, JdbcType.DECIMAL.getTypeCode());
    }

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int parameterIndex, BigDecimal parameterValue) throws SQLException {
        ps.setBigDecimal(parameterIndex, parameterValue);
    }

    @Override
    protected BigDecimal getNonNull(ResultSet rs, String columnName) throws SQLException {
        return rs.getBigDecimal(columnName);
    }

    @Override
    protected BigDecimal getNonNull(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getBigDecimal(columnIndex);
    }
}
