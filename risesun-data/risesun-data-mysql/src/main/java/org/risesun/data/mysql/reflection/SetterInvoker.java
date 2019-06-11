package org.risesun.data.mysql.reflection;

import java.lang.reflect.Field;

public class SetterInvoker implements Invoker {
    private final Field field;

    public SetterInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object... args) throws IllegalAccessException {
        field.set(target, args);
        return null;
    }

    @Override
    public Class<?> getType() {
        return null;
    }
}
