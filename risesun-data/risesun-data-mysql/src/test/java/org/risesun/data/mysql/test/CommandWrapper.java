package org.risesun.data.mysql.test;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandWrapper {
    private String sql;
    private CommandType commandType;
}
