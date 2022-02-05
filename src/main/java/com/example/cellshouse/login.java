package com.example.cellshouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login {
    public static String AutenticaUser(String loginEmail,String loginPassword){
        String querySQL="SELECT * FROM registration WHERE email=?";
        Connection conn = MySQLService.getDBConnection();
        String email="";
        try{
            PreparedStatement pst = null;
            try {
                pst = conn.prepareStatement(querySQL);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            pst.setString(1, loginEmail);
            ResultSet rs = pst.executeQuery();

            System.out.println(rs);
            if (rs.next()){

                if (rs.getString(2).equals(loginPassword)){

                    rs.getString(1);

                    email=rs.getString(1);
                    conn.close();
                }else{
                    conn.close();
                    email="sbagliato";
                }
            }else{
                conn.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        try{
            conn.close();
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return email;
    }

}
