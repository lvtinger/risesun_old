package org.risesun.data.mysql.proxy;

import org.risesun.common.utils.ClassUtils;
import org.risesun.data.mysql.context.DataContext;
import org.risesun.data.mysql.executor.MysqlStatementMethodFactory;
import org.risesun.data.mysql.executor.StatementMethod;
import org.risesun.data.mysql.executor.StatementMethodFactory;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultRepositoryProxyFactory implements RepositoryProxyFactory {

    private final DataContext context;
    private final ClassLoader classLoader;
    private final StatementMethodFactory statementMethodFactory = new MysqlStatementMethodFactory();

    public DefaultRepositoryProxyFactory(DataContext context) {
        this.context = context;
        this.classLoader = ClassUtils.getDefaultClassLoader();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T instance(Class<?> type) {

        Map<Method, StatementMethod> statementMethodMap = buildStatementMethod(type);
        RepositoryProxy proxy = new RepositoryProxy(this.context, statementMethodMap);
        return (T) Proxy.newProxyInstance(this.classLoader, new Class[]{type}, proxy);

    }

    private Map<Method, StatementMethod> buildStatementMethod(Class<?> type) {
        Map<Method, StatementMethod> cached = new HashMap<>();
        List<Method> methodList = ClassUtils.scanMethod(type);
        for (Method method : methodList) {
            StatementMethod statementMethod = statementMethodFactory.build(this.context, method);
            cached.put(method, statementMethod);
        }
        return cached;
    }
}
