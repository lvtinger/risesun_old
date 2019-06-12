package org.risesun.data.mysql.test;

import org.junit.Test;
import org.risesun.data.mysql.test.dao.AccountDao;
import org.risesun.data.mysql.test.model.Account;
import org.risesun.data.mysql.test.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Date;

public class MysqlTest {
    @Test
    public void testRepository() throws SQLException, ClassNotFoundException {

        Account account = new Account();
        account.setUsername("risesun");
        account.setPassword("123456");
        account.setStatus(1);
        account.setCreateTime(new Date());
        account.setUpdateTime(new Date());
        account.setDisabled(false);

        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        UserService userService = context.getBean(UserService.class);
        userService.register(account);
    }

    @Test
    public void getById() throws SQLException, ClassNotFoundException {
        AccountDao dao = new AccountDao();
        System.out.println(dao.getById(8L));
    }
}
