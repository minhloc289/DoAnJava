/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import model.ThongKeTheTap;
import java.sql.Date;
import database.JDBC;
import java.sql.*;
import model.DoanhThu;


/**
 *
 * @author locmi
 */
public class ThongKeDAO {
    public static ThongKeDAO getInstance() {
        return new ThongKeDAO();
    }
    
    public ArrayList<ThongKeTheTap> dsKhachHang(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<ThongKeTheTap> ketQua = new ArrayList<>();
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT Id_TTap, KHACHHANG.Id_KH, THETAP.Id_GT, NgayBD, NgayHH, KHACHHANG.HoTen, GOITAP.TenGoi "
                    + "FROM THETAP "
                    + "INNER JOIN KHACHHANG ON THETAP.Id_KH = KHACHHANG.Id_KH "
                    + "INNER JOIN GOITAP ON THETAP.Id_GT = GOITAP.Id_GT "
                    + "WHERE NgayBD BETWEEN ? AND ? "
                    + "ORDER BY TO_NUMBER(SUBSTR(Id_TTap, 3)) ASC";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDate(1, ngayBatDau);
            pst.setDate(2, ngayKetThuc);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id_TTap = rs.getString("Id_TTap");
                String id_KH = rs.getString("Id_KH");
                String id_GT = rs.getString("Id_GT");
                Date ngayBD = rs.getDate("NgayBD");
                Date ngayKT = rs.getDate("NgayHH");
                String hoTen = rs.getString("HoTen");
                String tenGoi = rs.getString("TenGoi");
                
                ThongKeTheTap tk = new ThongKeTheTap(id_TTap, id_KH, id_GT, ngayBD, ngayKT, hoTen, tenGoi);
                ketQua.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public ArrayList<ThongKeTheTap> dsKhachHang() {
        ArrayList<ThongKeTheTap> ketQua = new ArrayList<>();
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT Id_TTap, KHACHHANG.Id_KH, THETAP.Id_GT, NgayBD, NgayHH, KHACHHANG.HoTen, GOITAP.TenGoi "
                    + "FROM THETAP "
                    + "INNER JOIN KHACHHANG ON THETAP.Id_KH = KHACHHANG.Id_KH "
                    + "INNER JOIN GOITAP ON THETAP.Id_GT = GOITAP.Id_GT "
                    + "ORDER BY TO_NUMBER(SUBSTR(Id_TTap, 3)) ASC";
                    
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id_TTap = rs.getString("Id_TTap");
                String id_KH = rs.getString("Id_KH");
                String id_GT = rs.getString("Id_GT");
                Date ngayBD = rs.getDate("NgayBD");
                Date ngayKT = rs.getDate("NgayHH");
                String hoTen = rs.getString("HoTen");
                String tenGoi = rs.getString("TenGoi");
                
                ThongKeTheTap tk = new ThongKeTheTap(id_TTap, id_KH, id_GT, ngayBD, ngayKT, hoTen, tenGoi);
                ketQua.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public ArrayList<DoanhThu> dsThanhToan(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<DoanhThu> ketQua = new ArrayList<>();
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT Id_TToan, KHACHHANG.Id_KH, KHACHHANG.HoTen AS TenKH, NgayTT, TongTien, NHANVIEN.HoTen AS TenNV "
                    + "FROM THANHTOAN "
                    + "INNER JOIN KHACHHANG ON THANHTOAN.Id_KH = KHACHHANG.Id_KH "
                    + "INNER JOIN NHANVIEN ON THANHTOAN.Id_NV = NHANVIEN.Id_NV "
                    + "WHERE NgayTT BETWEEN ? AND ? AND TrangThai = 'Đã thanh toán' "
                    + "ORDER BY TO_NUMBER(SUBSTR(Id_TToan, 2)) ASC";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDate(1, ngayBatDau);
            pst.setDate(2, ngayKetThuc);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                String id_TToan = rs.getString("Id_TToan");
                String id_KH = rs.getString("Id_KH");
                String tenKH = rs.getString("TenKH");
                Date ngayTT = rs.getDate("NgayTT");
                double tongTien = rs.getDouble("TongTien");
                String tenNV = rs.getString("TenNV");
                DoanhThu doanhThu = new DoanhThu(id_TToan, id_KH, tenKH, ngayTT, tongTien, tenNV);
                ketQua.add(doanhThu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    

    public ArrayList<DoanhThu> dsThanhToan() {
        ArrayList<DoanhThu> ketQua = new ArrayList<>();
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT Id_TToan, KHACHHANG.Id_KH, KHACHHANG.HoTen AS TenKH, NgayTT, TongTien, NHANVIEN.HoTen AS TenNV "
                    + "FROM THANHTOAN "
                    + "INNER JOIN KHACHHANG ON THANHTOAN.Id_KH = KHACHHANG.Id_KH "
                    + "INNER JOIN NHANVIEN ON THANHTOAN.Id_NV = NHANVIEN.Id_NV "
                    + "WHERE TrangThai = 'Đã thanh toán' "
                    + "ORDER BY TO_NUMBER(SUBSTR(Id_TToan, 2)) ASC";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                String id_TToan = rs.getString("Id_TToan");
                String id_KH = rs.getString("Id_KH");
                String tenKH = rs.getString("TenKH");
                Date ngayTT = rs.getDate("NgayTT");
                double tongTien = rs.getDouble("TongTien");
                String tenNV = rs.getString("TenNV");
                DoanhThu doanhThu = new DoanhThu(id_TToan, id_KH, tenKH, ngayTT, tongTien, tenNV);
                ketQua.add(doanhThu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
}
