/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import model.KhachHang;
import java.util.ArrayList;
import database.JDBC;
import java.sql.*;
/**
 *
 * @author locmi
 */
public class KhachHangDAO implements DAOInterface<KhachHang> {
    
    public static KhachHangDAO getInstance(){
        return new KhachHangDAO();
    }

    @Override
    public int insert(KhachHang t) {
        int ketQua = 0;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "INSERT INTO KHACHHANG (Id_KH, HoTen, NgaySinh, GioiTinh, DiaChi, SoDT, Email) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getId_KH());
            pst.setString(2, t.getHoTen());
            pst.setDate(3, t.getNgaySinh());
            pst.setString(4, t.getGioiTinh());
            pst.setString(5, t.getDiaChi());
            pst.setString(6, t.getSoDT());
            pst.setString(7, t.getEmail());
            
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(conn);
        } catch (SQLException e) {
         
        }
        return ketQua;
    }

    @Override
    public int update(KhachHang t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(KhachHang t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KhachHang selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
