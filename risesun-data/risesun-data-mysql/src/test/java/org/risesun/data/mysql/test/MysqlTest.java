package org.risesun.data.mysql.test;

import org.junit.Test;
import org.risesun.data.mysql.test.dao.AccountDao;
import org.risesun.data.mysql.test.model.Account;
import org.risesun.data.mysql.test.repository.AccountRepository;
import org.risesun.data.mysql.test.repository.Repository;
import org.risesun.data.mysql.test.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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

    public static void main(String[] args) {
        Type[] types = AccountRepository.class.getGenericInterfaces();
        ParameterizedType parameterizedType = null;
        for (Type type : types) {
            if (type instanceof ParameterizedType) {
                parameterizedType = (ParameterizedType) type;
                Type rawType = parameterizedType.getRawType();
                if (rawType instanceof Class<?>) {
                    Class<?> $class = (Class<?>) rawType;
                    if (Repository.class.isAssignableFrom($class)) {
                        break;
                    }
                }
            } else if (type instanceof Class<?>) {

            }

            parameterizedType = null;
        }
        Type argument = parameterizedType.getActualTypeArguments()[0];
        System.out.println(argument.getTypeName());
    }
}
