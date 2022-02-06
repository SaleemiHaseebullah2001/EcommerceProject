package com.example.cellshouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login {
    public static int AutenticaUser(String loginEmail,String loginPassword){
        String querySQL="SELECT * FROM registration WHERE email=?";
        Connection conn = MySQLService.getDBConnection();
        int userid = -1;
        try{
            PreparedStatement pst = null;
            try {
                pst = conn.prepareStatement(querySQL);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            pst.setString(2, loginEmail);
            ResultSet rs = pst.executeQuery();

            System.out.println(rs);
            if (rs.next()){

                if (rs.getString(3).equals(loginPassword)){
                    userid=rs.getInt(1);
                    conn.close();
                }else{
                    conn.close();
                    userid = -1;
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
        return userid;
    }

}
