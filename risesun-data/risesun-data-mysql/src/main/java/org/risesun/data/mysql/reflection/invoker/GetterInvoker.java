package org.risesun.data.mysql.reflection.invoker;

import java.lang.reflect.Field;

public class GetterInvoker implements Invoker {
    private final Field field;

    public GetterInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws IllegalAccessException {
        return this.field.get(target);
    }

    @Override
    public Class<?> getType() {
        return this.field.getType();
    }
}
