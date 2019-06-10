package org.risesun.data.mysql.test;

import org.junit.Test;
import org.risesun.data.mysql.test.dao.AccountDao;
import org.risesun.data.mysql.test.model.Account;

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

        AccountDao dao = new AccountDao();
        boolean result = dao.create(account);

        if (result) {
            System.out.println(account);
        }

    /*ApplicationContext context =
            new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
    AccountService accountService = context.getBean(AccountService.class);
    accountService.create(account);

    UserService userService = context.getBean(UserService.class);
    userService.create(account);*/

    }
}
