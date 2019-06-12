package org.risesun.data.mysql.test.service.impl;

import org.risesun.data.mysql.test.model.Account;
import org.risesun.data.mysql.test.model.Profile;
import org.risesun.data.mysql.test.repository.AccountRepository;
import org.risesun.data.mysql.test.repository.ProfileRepository;
import org.risesun.data.mysql.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void register(Account account) {
        accountRepository.create(account);
    }

    @Override
    public void safeProfile(Profile profile) {
        profileRepository.create(profile);
    }
}