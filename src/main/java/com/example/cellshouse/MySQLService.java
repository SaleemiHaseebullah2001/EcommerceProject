package com.example.cellshouse;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLService {
    public static Connection getDBConnection() {
        Connection conn = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolproject?user=asib&password=");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}