package org.risesun.data.mysql.test.repository;

import org.risesun.data.mysql.annotation.Repository;
import org.risesun.data.mysql.test.model.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
