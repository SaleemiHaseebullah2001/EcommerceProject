package com.example.ecommerceproject.DAO;

import com.example.ecommerceproject.Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class ProductDAO {
    public static final String driver = "org.mariadb.jdbc.Driver";
    public static final String databaseUrl = "jdbc:mariadb://localhost:3306/schoolproject";
    public static final String user = "asib";
    public static final String pass = "";

    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product (image, name, price, description) VALUES(?,?,?,?) ";
    private static final String SELECT_ALL_SQL = "SELECT * FROM product";
    private static final String SELECT_PRODUCT_BY_ID_SQL = "SELECT id_product,image, name, price, description FROM product WHERE id_product=?";


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

    public List <Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id_product");
                String image = resultSet.getString("image");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                Product product = new Product(id,image, name, price, description);
                products.add(product);
            }
        }
        return products;
    }

    public Product getProductById(int id) throws SQLException {
        Product product = null;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement= connection.prepareStatement(SELECT_PRODUCT_BY_ID_SQL)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String image = resultSet.getString("image");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                product = new Product(id,image, name, price, description);
            }
        }
        return product;
    }
}
