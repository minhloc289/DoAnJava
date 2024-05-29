/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.HuanLuyenVien;
import database.JDBC;
import java.sql.*;
import java.util.ArrayList;


public class HuanLuyenVienDAO implements DAOInterface<HuanLuyenVien> {
     public static HuanLuyenVienDAO getInstance(){
        return new HuanLuyenVienDAO();
    }

    @Override
    public int insert(HuanLuyenVien t) {
       int ketQua = 0;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "INSERT INTO HUANLUYENVIEN (Id_HLV, HoTen, NgaySinh, GioiTinh, DiaChi, SoDT, NgayVL, ChuyenMon, Email, GiaThue) Values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getId_HLV());
            pst.setString(2, t.getHoTen());
            pst.setDate(3, t.getNgaySinh());
            pst.setString(4, t.getGioiTinh());
            pst.setString(5, t.getDiaChi());
            pst.setString(6, t.getSoDT());
            pst.setDate(7, t.getNgayVL());
            pst.setString(8, t.getChuyenMon());
            pst.setString(9, t.getEmail());
            pst.setDouble(10, t.getGiaThue());
            
            
            ketQua = pst.executeUpdate();
            
        }
        catch(SQLException e) {
                e.printStackTrace();
            
        }
        return ketQua;
    }

    @Override
    public int update(HuanLuyenVien t) {
        int ketQua = 0;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "UPDATE HUANLUYENVIEN SET HoTen = ?, NgaySinh = ?, GioiTinh = ?, DiaChi = ?, SoDT = ?, NgayVL = ?,ChuyenMon = ?, Email = ?, GiaThue = ? WHERE Id_HLV = ? AND isDeleted = 0";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(10, t.getId_HLV());
            pst.setString(1, t.getHoTen());
            pst.setDate(2, t.getNgaySinh());
            pst.setString(3, t.getGioiTinh());
            pst.setString(4, t.getDiaChi());
            pst.setString(5, t.getSoDT());
            pst.setDate(6, t.getNgayVL());
            pst.setString(7, t.getChuyenMon());
            pst.setString(8, t.getEmail());
            pst.setDouble(9, t.getGiaThue());
            ketQua = pst.executeUpdate();
            
        } catch (SQLException e) {
            
                e.printStackTrace();
            
        }
        return ketQua;
    }

    @Override
    public int delete(HuanLuyenVien t) {
        int ketQua = 0;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = JDBC.getConnection();
            String sqlCall = "{call XoaHuanLuyenVien(?)}";
            stmt = conn.prepareCall(sqlCall);
            stmt.setString(1, t.getId_HLV());
            stmt.execute();
            
        ketQua = 1;
        } catch (SQLException e) {
                if (e.getErrorCode() == 20003) {
                    throw new RuntimeException("Không thể xóa huấn luyện viên. Huấn luyện viên đang được thuê.", e);
                }
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
    public ArrayList<HuanLuyenVien> selectAll() {
        ArrayList<HuanLuyenVien> hlvList = new ArrayList<>();
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM HUANLUYENVIEN WHERE isDeleted = 0 ORDER BY TO_NUMBER(SUBSTR(Id_HLV, 4)) ASC";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Id_HLV = rs.getString("Id_HLV");
                String HoTen = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                String GioiTinh = rs.getString("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String SoDT = rs.getString("SoDT");
                Date NgayVL = rs.getDate("NgayVL");
                String ChuyenMon = rs.getString("ChuyenMon");
                String Email = rs.getString("Email");
                Double GiaThue = rs.getDouble("GiaThue");
                
                HuanLuyenVien hlv = new HuanLuyenVien(Id_HLV, HoTen, NgaySinh, GioiTinh, DiaChi, SoDT, NgayVL, ChuyenMon, Email,GiaThue);
                hlvList.add(hlv);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hlvList;    
    }

    @Override
    public HuanLuyenVien selectById(String t) {
        HuanLuyenVien hlv = null;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM HUANLUYENVIEN WHERE Id_HLV = ? AND isDeleted = 0";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Id_HLV = rs.getString("Id_HLV");
                String HoTen = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                String GioiTinh = rs.getString("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String SoDT = rs.getString("SoDT");
                Date NgayVL = rs.getDate("NgayVL");
                String ChuyenMon = rs.getString("ChuyenMon");
                String Email = rs.getString("Email");
                Double GiaThue = rs.getDouble("GiaThue");
                hlv = new HuanLuyenVien(Id_HLV, HoTen, NgaySinh, GioiTinh, DiaChi, SoDT, NgayVL, ChuyenMon, Email,GiaThue);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hlv;
    }
    public HuanLuyenVien selectByEmail(String t) {
            HuanLuyenVien hlv = null;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM HUANLUYENVIEN WHERE email = ? AND isDeleted = 0";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Id_HLV = rs.getString("Id_HLV");
                String HoTen = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                String GioiTinh = rs.getString("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String SoDT = rs.getString("SoDT");
                Date NgayVL = rs.getDate("NgayVL");
                String ChuyenMon = rs.getString("ChuyenMon");
                String Email = rs.getString("Email");
                Double GiaThue = rs.getDouble("GiaThue");
                hlv = new HuanLuyenVien(Id_HLV, HoTen, NgaySinh, GioiTinh, DiaChi, SoDT, NgayVL, ChuyenMon, Email,GiaThue);            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hlv;
    }
    
    public ArrayList<HuanLuyenVien> selectAll(Date ngayBD, Date ngayKT) {
        ArrayList<HuanLuyenVien> hlvList = new ArrayList<>();
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM HUANLUYENVIEN "
                    + "WHERE isDeleted = 0 AND NgayVL BETWEEN ? AND ? "
                    + "ORDER BY TO_NUMBER(SUBSTR(Id_HLV, 4)) ASC";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDate(1, ngayBD);
            pst.setDate(2, ngayKT);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Id_HLV = rs.getString("Id_HLV");
                String HoTen = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                String GioiTinh = rs.getString("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String SoDT = rs.getString("SoDT");
                Date NgayVL = rs.getDate("NgayVL");
                String ChuyenMon = rs.getString("ChuyenMon");
                String Email = rs.getString("Email");
                Double GiaThue = rs.getDouble("GiaThue");
                
                HuanLuyenVien hlv = new HuanLuyenVien(Id_HLV, HoTen, NgaySinh, GioiTinh, DiaChi, SoDT, NgayVL, ChuyenMon, Email, GiaThue);
                hlvList.add(hlv);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hlvList;    
    }
}

