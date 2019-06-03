package org.risesun.data.mysql.test.service.impl;

import org.risesun.data.mysql.test.model.Account;
import org.risesun.data.mysql.test.repository.AccountRepository;
import org.risesun.data.mysql.test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void create(Account account) {
        accountRepository.create(account);
    }
}