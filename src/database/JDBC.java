/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
/**
 *
 * @author locmi
 */
public class JDBC {
    public static Connection getConnection() {
        Connection conn = null; 
        try
        {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            //thong so
            String url = "jdbc:oracle:thin:@localhost:1521:orcl21";
            String username = "C##doan_ck";
            String password = "phamhuy2002";
            
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Ket noi thanh cong");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Kết nối cơ sở dữ liệu thất bại", "Thông báo", 1);
            return null;
        }
        return conn;
    }
    public static void closeConnection(Connection c) {
        try {
            if(c!=null) {
		c.close();
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
