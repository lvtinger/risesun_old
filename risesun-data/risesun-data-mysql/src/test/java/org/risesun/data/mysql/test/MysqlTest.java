package org.risesun.data.mysql.test;

import org.junit.Test;
import org.risesun.data.mysql.test.model.Account;
import org.risesun.data.mysql.test.service.AccountService;
import org.risesun.data.mysql.test.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MysqlTest {
    @Test
    public void testRepository() {

        Account account = new Account();
        account.setUsername("risesun");
        account.setPassword("123456");
        account.setStatus(1);
        account.setCreateTime(new Date());
        account.setUpdateTime(new Date());

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        AccountService accountService = context.getBean(AccountService.class);
        accountService.create(account);

        UserService userService = context.getBean(UserService.class);
        userService.create(account);
    }
}