package org.risesun.data.mysql.executor;

import lombok.Getter;
import lombok.Setter;
import org.risesun.data.mysql.enums.CommandType;
import org.risesun.data.mysql.meta.bean.Metadata;

@Getter
@Setter
public class StatementMethod {
    private String commandText;
    private CommandType commandType;
    private Metadata metadata;
}