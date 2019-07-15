package org.risesun.data.mysql.test;

import java.sql.SQLException;

public interface CommandExecutor {
    Object execute(CommandWrapper wrapper) throws SQLException, ClassNotFoundException;
}
