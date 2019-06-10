package org.risesun.data.mysql.type;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class TypeHandlerFactory {

    private static final Map<Class<?>, TypeHandler<?>> HOLDER = new HashMap<>();

    static {
        HOLDER.put(Boolean.class, new BooleanTypeHandler());
        HOLDER.put(Integer.class, new IntegerTypeHandler());
        HOLDER.put(Long.class, new LongTypeHandler());
        HOLDER.put(Float.class, new FloatTypeHandler());
        HOLDER.put(Double.class, new DoubleTypeHandler());
        HOLDER.put(BigDecimal.class, new DecimalTypeHandler());
        HOLDER.put(Date.class, new DateTimeTypeHandler());
        HOLDER.put(String.class, new StringTypeHandler());
    }

    public static TypeHandler<?> getTypeHandler(Class<?> type) {
        return HOLDER.get(type);
    }
}
