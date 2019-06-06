package org.risesun.data.mysql.reflection;

import java.lang.reflect.Constructor;

public class Reflector {
    private final Class<?> type;
    private Constructor<?> constructor;

    public Reflector(Class<?> type) {
        this.type = type;
        defaultConstructor(type);
    }

    private void defaultConstructor(Class<?> type) {
        Constructor<?>[] constructors = type.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterTypes().length == 0) {
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }

                this.constructor = constructor;
            }
        }
    }
}
