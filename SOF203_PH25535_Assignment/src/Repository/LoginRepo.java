/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sof203_ph25535_assignment1.JDBCUtil;

/**
 *
 * @author PC
 */
public class LoginRepo {
    public Account account(String username, String password){
        String sql = "SELECT * FROM USERS WHERE username=? AND password=?";
        Connection conn = JDBCUtil.getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next() == false){
                return null;
            }
            
            String role = rs.getString("role");
            Account a = new Account(username, password, role);
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
