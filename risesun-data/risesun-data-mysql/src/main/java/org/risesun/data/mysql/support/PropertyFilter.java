package org.risesun.data.mysql.support;

import org.risesun.common.utils.FieldFilter;
import org.risesun.data.mysql.annotation.Ignore;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PropertyFilter implements FieldFilter {

    private final List<Class<?>> allowedTypes = new ArrayList<>();

    public PropertyFilter() {
        allowedTypes.add(Boolean.class);
        allowedTypes.add(String.class);
        allowedTypes.add(Integer.class);
        allowedTypes.add(Long.class);
        allowedTypes.add(Double.class);
        allowedTypes.add(Float.class);
        allowedTypes.add(BigDecimal.class);
        allowedTypes.add(Date.class);
    }

    @Override
    public boolean math(Field field) {
        int modifiers = field.getModifiers();
        if (Modifier.isStatic(modifiers)
                || Modifier.isTransient(modifiers)
                || Modifier.isFinal(modifiers)) {
            return false;
        }

        Ignore ignore = field.getDeclaredAnnotation(Ignore.class);
        if (null != ignore) {
            return false;
        }

        Class<?> type = field.getType();

        return allowedTypes.contains(type);
    }
}
