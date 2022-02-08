package com.example.cellshouse.DAO;

import com.example.cellshouse.Model.Login;
import com.example.cellshouse.MySQLService;

import java.sql.*;
public class LoginDAO {
    public Login checkLogin(String email, String password) throws SQLException{

        Connection connection = MySQLService.getDBConnection();
        String sql = "SELECT * FROM registration WHERE email = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        Login user = null;

        if (result.next()) {
            user = new Login();
            user.setEmail(email);
            user.setId(result.getInt("id"));
        }

        connection.close();

        return user;
    }
}

