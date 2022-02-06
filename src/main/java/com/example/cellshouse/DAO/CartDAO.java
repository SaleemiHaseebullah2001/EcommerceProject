package com.example.cellshouse.DAO;

import com.example.cellshouse.Model.cart_item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartDAO {
    public static final String driver = "org.mariadb.jdbc.Driver";
    public static final String databaseUrl = "jdbc:mariadb://localhost:3306/schoolproject";
    public static final String user = "asib";
    public static final String pass = "";

    private static final String INSERT_INTO_CART_SQL = "INSERT INTO cart (id_cart, id_user, quantity) VALUES(?,?,?) ";
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(databaseUrl, user, pass);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public int insertCartItem(int itemid,int quantity,int userid) throws SQLException {
        int result = 0;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CART_SQL)){
            preparedStatement.setInt(1, itemid);
            preparedStatement.setInt(2, userid);
            preparedStatement.setInt(3, quantity);
            result = preparedStatement.executeUpdate();
            if (result != 0){
                System.out.println(result);
            }
        }
        return result;
    }
}
