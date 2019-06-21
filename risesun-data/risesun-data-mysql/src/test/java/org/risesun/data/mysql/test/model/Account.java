package org.risesun.data.mysql.test.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.risesun.data.mysql.annotation.Database;
import org.risesun.data.mysql.annotation.Id;
import org.risesun.data.mysql.annotation.Table;

import java.io.Serializable;
import java.util.Date;

@Database(value = "cherry")
@Table(value = "account")
@Getter
@Setter
@ToString
public class Account implements Serializable {

    private static final long serialVersionUID = 6429842140751604212L;

    @Id
    private Long id;
    private String username;
    private String password;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Boolean disabled;

}
