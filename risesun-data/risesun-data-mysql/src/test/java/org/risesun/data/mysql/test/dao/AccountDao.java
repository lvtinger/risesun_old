package org.risesun.data.mysql.test.dao;

import org.risesun.data.mysql.test.model.Account;

import java.sql.*;

public class AccountDao {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cherry_0?useSSL=true", "root", "123456");
        return connection;
    }

    public boolean create(Account account) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO cherry.account(username, password, status, createTime, updateTime, disabled) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, account.getUsername());
        statement.setString(2, account.getPassword());
        statement.setInt(3, account.getStatus());
        statement.setDate(4, new Date(account.getCreateTime().getTime()));
        statement.setDate(5, new Date(account.getUpdateTime().getTime()));
        statement.setBoolean(6, account.getDisabled());
        int i = statement.executeUpdate();
        if (i <= 0) {
            return false;
        }

        ResultSet set = statement.getGeneratedKeys();
        if (set.next()) {
            long id = set.getLong(1);
            account.setId(id);
        }
        set.close();
        statement.close();
        connection.rollback();
        return true;
    }

    public boolean update(Account account) {
        return true;
    }

    public Account getById(Long id) {
        return null;
    }
}
