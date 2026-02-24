package com.jdbc.td1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection getConnection() {
        try {
            String jdbcURl = System.getenv("URL_JDBC");
            String user = System.getenv("USER");
            String password = System.getenv("SECRET_WORD");
            return DriverManager.getConnection(jdbcURl, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
