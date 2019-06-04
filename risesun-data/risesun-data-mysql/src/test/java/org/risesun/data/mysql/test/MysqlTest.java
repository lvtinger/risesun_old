package org.risesun.data.mysql.test;

import org.junit.Test;
import org.risesun.common.utils.AnnotationClassFilter;
import org.risesun.common.utils.ClassUtils;
import org.risesun.data.mysql.annotation.Table;

import java.io.IOException;
import java.util.Set;

public class MysqlTest {
    @Test
    public void testRepository() throws IOException {
        AnnotationClassFilter filter = new AnnotationClassFilter(Table.class);
        Set<Class<?>> classes = ClassUtils.doScan(filter, "org.risesun.data.mysql.test.model");
        classes.forEach($class -> System.out.println($class.getName()));

    /*Account account = new Account();
    account.setUsername("risesun");
    account.setPassword("123456");
    account.setStatus(1);
    account.setCreateTime(new Date());
    account.setUpdateTime(new Date());

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
    AccountService accountService = context.getBean(AccountService.class);
    accountService.create(account);

    UserService userService = context.getBean(UserService.class);
    userService.create(account);*/
    }
}
