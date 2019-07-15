package org.risesun.data.mysql.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GeneralCommandExecutor implements CommandExecutor {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/cherry_0?useSSL=true", "root", "123456");
        return connection;
    }

    public Object execute(CommandWrapper wrapper) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(wrapper.getSql());
        boolean execute = statement.execute();

        return null;
    }
}
