package org.risesun.data.mysql.test.service.impl;

import org.risesun.data.mysql.test.model.Account;
import org.risesun.data.mysql.test.repository.AccountRepository;
import org.risesun.data.mysql.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServcieImpl implements UserService {

    @Autowired
    private AccountRepository repository;

    @Override
    public void create(Account account) {
        repository.create(account);
    }
}
