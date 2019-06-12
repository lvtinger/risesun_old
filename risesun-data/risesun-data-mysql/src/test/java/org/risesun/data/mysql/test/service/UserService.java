package org.risesun.data.mysql.test.service;

import org.risesun.data.mysql.test.model.Account;
import org.risesun.data.mysql.test.model.Profile;

public interface UserService {
    void register(Account account);

    void safeProfile(Profile profile);
}
