/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.JDBC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ThanhToan;
import java.sql.Date;

/**
 *
 * @author locmi
 */
public class ThanhToanDAO implements DAOInterface<ThanhToan> {
    
    public static ThanhToanDAO getInstance(){
        return new ThanhToanDAO();
    }

    @Override
    public int insert(ThanhToan t) {
        int ketQua = 0;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = JDBC.getConnection();
            String sqlCall = "{call ThemThanhToan(?,?,?)}";
            stmt = conn.prepareCall(sqlCall);
            
            stmt.setString(1, t.getId_TTOAN());
            stmt.setString(2, t.getId_KH());
            stmt.setString(3, t.getId_NV());
            
            stmt.execute();
            ketQua = 1;
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20001) {
                throw new RuntimeException("Khách hàng không tồn tại", e);
            }
            else if (e.getErrorCode() == 20002) {
                throw new RuntimeException("Nhân viên không tồn tại, e");
            }
            else {
                e.printStackTrace();
            }
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ketQua;
    }

    @Override
    public int update(ThanhToan t) {
        int ketQua = 0;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = JDBC.getConnection();
            String sqlCall = "{call SuaThanhToan(?,?)";
            stmt = conn.prepareCall(sqlCall);
            
            stmt.setString(1, t.getId_TTOAN());
            stmt.setString(3, t.getId_NV());
            
            stmt.execute();
            ketQua = 1;
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20003) {
                throw new RuntimeException("Nhân viên không tồn tại!");
            }
            else {
                e.printStackTrace();
            }
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ketQua;
    }

    @Override
    public int delete(ThanhToan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ThanhToan> selectAll() {
        ArrayList<ThanhToan> ttoanList = new ArrayList<>();
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM THANHTOAN";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                String id_TToan = rs.getString("Id_TToan");
                Date ngayLap = rs.getDate("NgayLap");
                Double tongTien = rs.getDouble("TongTien");
                String trangThai = rs.getString("TrangThai");
                String id_KH = rs.getString("Id_KH");
                String id_NV = rs.getString("Id_NV");
                
                ThanhToan thanhtoan = new ThanhToan(id_TToan, id_KH, id_NV ,ngayLap, tongTien, trangThai);
                ttoanList.add(thanhtoan);
            }
            JDBC.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ttoanList;
    }

    @Override
    public ThanhToan selectById(String t) {
        ThanhToan ttoan = null;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM THANHTOAN WHERE Id_TToan = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                String id_TToan = rs.getString("Id_TToan");
                Date ngayLap = rs.getDate("NgayLap");
                Double tongTien = rs.getDouble("TongTien");
                String trangThai = rs.getString("TrangThai");
                String id_KH = rs.getString("Id_KH");
                String id_NV = rs.getString("Id_NV");
                
                ttoan = new ThanhToan(id_TToan, id_KH, id_NV , ngayLap, tongTien, trangThai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ttoan;
    }
    
    
}
