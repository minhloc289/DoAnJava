/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import model.NhanVien;
import java.sql.*;
import database.JDBC;

        
public class NhanVienDAO implements DAOInterface<NhanVien> {
     public static NhanVienDAO getInstance(){
        return new NhanVienDAO();
    }

    @Override
    public int insert(NhanVien t) {
        int ketQua = 0;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "INSERT INTO NHANVIEN (Id_NV, HoTen, NgaySinh, GioiTinh, DiaChi, SoDT, NgayVL, ChucVu, Email) Values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getId_NV());
            pst.setString(2, t.getHoTen());
            pst.setDate(3, t.getNgaySinh());
            pst.setString(4, t.getGioiTinh());
            pst.setString(5, t.getDiaChi());
            pst.setString(6, t.getSoDT());
            pst.setDate(7, t.getNgayVL());
            pst.setString(8, t.getChucVu());
            pst.setString(9, t.getEmail());
            
            ketQua = pst.executeUpdate();
            
        }
        catch(SQLException e) {
                e.printStackTrace();
            
        }
        return ketQua;
    }

    @Override
    public int update(NhanVien t) {
        int ketQua = 0;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "UPDATE KHACHHANG SET HoTen = ?, NgaySinh = ?, GioiTinh = ?, DiaChi = ?, SoDT = ?, NgayVL = ?,ChucVu = ?, Email = ? WHERE Id_NV = ? AND isDeleted = 0";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getId_NV());
            pst.setString(2, t.getHoTen());
            pst.setDate(3, t.getNgaySinh());
            pst.setString(4, t.getGioiTinh());
            pst.setString(5, t.getDiaChi());
            pst.setString(6, t.getSoDT());
            pst.setDate(7, t.getNgayVL());
            pst.setString(8, t.getChucVu());
            pst.setString(9, t.getEmail());
            
            ketQua = pst.executeUpdate();
            
        } catch (SQLException e) {
            
                e.printStackTrace();
            
        }
        return ketQua;
    }

    
    @Override
    public int delete(NhanVien t) {
        int ketQua = 0;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = JDBC.getConnection();
            String sqlCall = "{call XoaNhanVien(?)}";
            stmt = conn.prepareCall(sqlCall);
            stmt.setString(1, t.getId_NV());
            stmt.execute();
            ArrayList<NhanVien> danhSachNhanVien = selectAll();
            danhSachNhanVien.remove(t);
        ketQua = 1;
    } catch (SQLException e) {
            e.printStackTrace();
    }
    finally {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return ketQua;
}
 
    @Override
    public ArrayList<NhanVien> selectAll() {
        ArrayList<NhanVien> nvList = new ArrayList<>();
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM NHANVIEN WHERE isDeleted = 0 ORDER BY Id_NV ASC";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Id_NV = rs.getString("Id_NV");
                String HoTen = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                String GioiTinh = rs.getString("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String SoDT = rs.getString("SoDT");
                Date NgayVL = rs.getDate("NgayVL");
                String ChucVu = rs.getString("ChucVu");
                String Email = rs.getString("Email");
                NhanVien nv = new NhanVien(Id_NV, HoTen, NgaySinh, GioiTinh, DiaChi, SoDT, NgayVL, ChucVu, Email);
                nvList.add(nv);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nvList;
    }

    @Override
    public NhanVien selectById(String t) {
        NhanVien nv = null;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM NHANVIEN WHERE Id_NV = ? AND isDeleted = 0";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Id_NV = rs.getString("Id_NV");
                String HoTen = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                String GioiTinh = rs.getString("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String SoDT = rs.getString("SoDT");
                Date NgayVL = rs.getDate("NgayVL");
                String ChucVu = rs.getString("ChucVu");
                String Email = rs.getString("Email");
                nv = new NhanVien(Id_NV, HoTen, NgaySinh, GioiTinh, DiaChi, SoDT, NgayVL, ChucVu, Email);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv;
    }
    public NhanVien selectByEmail(String t) {
            NhanVien nv = null;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM NHANVIEN WHERE email = ? AND isDeleted = 0";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Id_NV = rs.getString("Id_NV");
                String HoTen = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                String GioiTinh = rs.getString("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String SoDT = rs.getString("SoDT");
                Date NgayVL = rs.getDate("NgayVL");
                String ChucVu = rs.getString("ChucVu");
                String Email = rs.getString("Email");
                nv = new NhanVien(Id_NV, HoTen, NgaySinh, GioiTinh, DiaChi, SoDT, NgayVL, ChucVu, Email);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv;
}
}
