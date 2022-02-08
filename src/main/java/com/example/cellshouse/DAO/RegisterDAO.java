package com.example.cellshouse.DAO;
import com.example.cellshouse.Model.RegisterBean;
import com.example.cellshouse.MySQLService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
public class RegisterDAO {
    public String registerUser(RegisterBean registerBean) throws SQLException {
        String email = registerBean.getEmail();
        String password = registerBean.getPassword();
        String name = registerBean.getName();
        String surname = registerBean.getSurname();
        String pnumber = registerBean.getPnumber();
        String gender = registerBean.getGender();
        String street = registerBean.getStreet();
        String number = registerBean.getNumber();
        String city = registerBean.getCity();
        String zip = registerBean.getZip();
        String state = registerBean.getState();

        String searchQuery = "SELECT email FROM registration WHERE email=?";
        Connection conn = MySQLService.getDBConnection();
        PreparedStatement pst = conn.prepareStatement(searchQuery);
        pst.setString(1, email);
        try
        {
        ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                conn.close();
                return "A user already exist with this email";
            }else {
                String query = "insert into registration(email,password,name,surname,pnumber,gender,street,number,city,zip,state) values (?,?,?,?,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
                conn.close();
                Connection conn2 = MySQLService.getDBConnection();
                pst = conn2.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
                pst.setString(1, email);
                pst.setString(2, password);
                pst.setString(3, name);
                pst.setString(4, surname);
                pst.setString(5, pnumber);
                pst.setString(6, gender);
                pst.setString(7, street);
                pst.setString(8, number);
                pst.setString(9, city);
                pst.setString(10, zip);
                pst.setString(11, state);

                pst.executeUpdate();


                    conn2.close();
                    return "SUCCESS";
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Oops.. Something went wrong!";  // On failure, send a message from here.
    }
}
