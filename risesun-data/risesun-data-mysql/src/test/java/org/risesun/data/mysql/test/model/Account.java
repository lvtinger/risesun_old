package org.risesun.data.mysql.test.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Account implements Serializable {

    private static final long serialVersionUID = 6429842140751604212L;

    private Long id;
    private String username;
    private String password;
    private Integer status;
    private Date createTime;
    private Date updateTime;

}
