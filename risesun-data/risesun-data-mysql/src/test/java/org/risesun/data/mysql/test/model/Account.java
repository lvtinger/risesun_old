package org.risesun.data.mysql.test.model;

import lombok.Getter;
import lombok.Setter;
import org.risesun.data.mysql.annotation.Id;
import org.risesun.data.mysql.annotation.Table;

import java.io.Serializable;
import java.util.Date;

@Table
@Getter
@Setter
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
