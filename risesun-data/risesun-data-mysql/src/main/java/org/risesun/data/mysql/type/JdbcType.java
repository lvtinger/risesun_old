package org.risesun.data.mysql.type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Types;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum JdbcType {
    BOOLEAN(Types.BOOLEAN),
    INTEGER(Types.INTEGER),
    LONG(Types.BIGINT),
    STRING(Types.VARCHAR),
    DECIMAL(Types.DECIMAL),
    DOUBLE(Types.DOUBLE),
    FLOAT(Types.FLOAT),
    DATETIME(Types.DATE);

    private final int typeCode;

    public static JdbcType safeConvert(int typeValue) {
        JdbcType[] types = JdbcType.values();
        for (JdbcType type : types) {
            if (type.typeCode == typeValue) {
                return type;
            }
        }
        return null;
    }

    public static JdbcType safeConvert(String typeName) {
        JdbcType[] types = JdbcType.values();
        for (JdbcType type : types) {
            if (type.name().equals(typeName)) {
                return type;
            }
        }
        return null;
    }
}
