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
                    + "WHERE NgayBD BETWEEN ? AND ?";
            
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
                    + "INNER JOIN GOITAP ON THETAP.Id_GT = GOITAP.Id_GT";
                    
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
    
}
