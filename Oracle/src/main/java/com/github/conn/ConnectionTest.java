package com.github.conn;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author HAN
 * @version 1.0
 * @since 07-20-18:18
 */
public class ConnectionTest {

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "root";
        String password = "root";
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Test
    public void testInsert() throws SQLException {
        Connection conn = ConnectionTest.getConnection();
        String sql = "insert into t_owners (name) values (?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "papa");
        ps.execute();
    }
}
