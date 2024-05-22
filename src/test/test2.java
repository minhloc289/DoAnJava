/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import database.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
/**
 *
 * @author locmi
 */
public class test2 {
    public static void main(String[] args) {
        Connection con = JDBC.getConnection();
        int ketQua = 0;
        try{
            String sql = "INSERT INTO NHANVIEN(Id_NV, HoTen, NgaySinh, GioiTinh, DiaChi, SoDT, NgayVL, ChucVu, Email) VALUES (?,?, TO_DATE('28-09-2004', 'dd-MM-RR'),?,?,?,TO_DATE('28-09-2024', 'dd-MM-RR'),?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "NV01");
            pst.setString(2, "Minh Loc");
            pst.setString(3, "Nam");
            pst.setString(4, "Ho Chi Minh");
            pst.setString(5, "1209100391");
            pst.setString(6, "Quan Ly");
            pst.setString(7, "locminh.2809@gmail.com");
            
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }
}
