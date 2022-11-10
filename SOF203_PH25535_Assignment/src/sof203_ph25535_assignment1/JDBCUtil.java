/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sof203_ph25535_assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class JDBCUtil {
    private static Connection conn;
    
    public static Connection getConnection(){
        if(JDBCUtil.conn == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser = "sa", dbPass = "123456", dbURl = "jdbc:sqlserver://localhost:1433"
                        + ";databaseName=SOF203_ASSIGNMENT";
                JDBCUtil.conn = DriverManager.getConnection(dbURl, dbUser, dbPass);
                
                System.out.println("Kết nối thành công");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
