package org.risesun.data.mysql.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvoker implements Invoker {
    private final Method method;
    private final Class<?> type;

    public MethodInvoker(Method method) {
        this.method = method;
        type = method.getParameterTypes().length == 1
                ? method.getParameterTypes()[0]
                : method.getReturnType();
    }

    @Override
    public Object invoke(Object target, Object... args)
            throws IllegalAccessException, InvocationTargetException {
        return this.method.invoke(target, args);
    }

    @Override
    public Class<?> getType() {
        return null;
    }
}
