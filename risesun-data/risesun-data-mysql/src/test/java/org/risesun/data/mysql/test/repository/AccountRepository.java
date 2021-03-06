package org.risesun.data.mysql.test.repository;

import org.risesun.data.mysql.annotation.Repository;
import org.risesun.data.mysql.test.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>, Hello {

}