package org.risesun.data.mysql.test.repository;

import org.risesun.data.mysql.annotation.Repository;
import org.risesun.data.mysql.test.model.Account;

@Repository
public interface AccountRepository {
    void create(Account account);

    void update(Account account);

    void getById(Long id);
    
    void findByUserNameAndPassword(String username, String password);
}