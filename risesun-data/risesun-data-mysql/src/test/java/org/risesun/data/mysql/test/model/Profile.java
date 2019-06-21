package org.risesun.data.mysql.test.model;

import lombok.Getter;
import lombok.Setter;
import org.risesun.data.mysql.annotation.Database;
import org.risesun.data.mysql.annotation.Id;
import org.risesun.data.mysql.annotation.Table;

import java.util.Date;

@Database(value = "cherry")
@Table(value = "profile")
@Getter
@Setter
public class Profile {
    @Id
    private Long id;
    private String name;
    private String avatar;
    private Date birthday;
}
