package com.example.ecommerceproject;

import java.sql.*;
class register {
    public static String registraAccount(String signEmail, String signPassword) {

        try {
            String searchQuery = "SELECT email FROM registration WHERE email=?";
            Connection conn = MySQLService.getDBConnection();
            PreparedStatement pst = conn.prepareStatement(searchQuery);
            pst.setString(1, signEmail);
            ResultSet rs = pst.executeQuery();

            System.out.println("1");
            if (rs.next()) {
                conn.close();
                System.out.println("E' gia' presente un account con questa email!");
            } else {
                String addQuery = "INSERT INTO registration (email, password) VALUES (?, ?)";
                Connection conn2 = MySQLService.getDBConnection();
                pst = conn2.prepareStatement(addQuery);
                pst.setString(1, signEmail);
                pst.setString(2, signPassword);
                pst.executeUpdate();
                conn2.close();
                return "si";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "no";
    }
}
