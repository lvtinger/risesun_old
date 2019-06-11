package org.risesun.data.mysql.executor;

public class MethodExecutorFactory {
    public static MethodExecutor build() {
        return new MethodExecutor();
    }
}
