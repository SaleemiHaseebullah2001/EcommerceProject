package com.example.cellshouse.DAO;

import com.example.cellshouse.Model.Product;
import com.example.cellshouse.Model.cart_item;
import com.example.cellshouse.Model.cart_item_row;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
    public static final String driver = "org.mariadb.jdbc.Driver";
    public static final String databaseUrl = "jdbc:mariadb://localhost:3306/schoolproject";
    public static final String user = "asib";
    public static final String pass = "";

    private static final String INSERT_INTO_CART_SQL = "INSERT INTO cart (id_item, id_user, quantity) VALUES(?,?,?) ";
    private static final String GET_CART_BY_ID = "SELECT * FROM cart WHERE id_user=?";

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
    public int insertCartItem(int itemid,int userid,int quantity) throws SQLException {
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

    public  List <cart_item_row> getCartById(int userid){
        List <cart_item_row> cart_item_rows = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_CART_BY_ID)){
            preparedStatement.setInt(1, userid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
              int item_id = resultSet.getInt("id_item");
              int user_id = resultSet.getInt("id_user");
              int quantity = resultSet.getInt("quantity");
              cart_item_rows.add(new cart_item_row(item_id,user_id,quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart_item_rows;
    }
}
