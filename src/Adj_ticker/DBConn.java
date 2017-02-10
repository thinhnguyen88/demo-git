/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adj_ticker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tinh
 */
public class DBConn {

    public static Connection getConn() {
        String url = "jdbc:oracle:thin:@192.168.112.164:1522:LRGDB";
        String user = "C##LRGDB_USER";
        String pass = "lrg123";
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
        }
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
        }
        
        return conn;
    }
    
    public static void closeAll(Connection conn, PreparedStatement pstm, ResultSet rs) {
        
        try {
            conn.close();
            pstm.close();
            rs.close();
        } catch (SQLException e) {
        }
    }
}
