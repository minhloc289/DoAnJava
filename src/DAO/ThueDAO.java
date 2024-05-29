/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.JDBC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Thue;

/**
 *
 * @author locmi
 */
public class ThueDAO implements DAOInterface<Thue> {
    public static ThueDAO getInstance(){
        return new ThueDAO();
    }

    @Override
    public int insert(Thue t) {
        int ketQua = 0;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = JDBC.getConnection();
            String sqlCall = "{call ThueHuanLuyenVien(?,?,?)}";
            stmt = conn.prepareCall(sqlCall);

            stmt.setString(1, t.getId_KH());
            stmt.setString(2, t.getId_HLV());
            stmt.setInt(3, t.getThoiGianThue());

            stmt.execute();
            ketQua = 1;

        } catch (SQLException e) {
            if (e.getErrorCode() == 20001) {
                throw new RuntimeException("Khách hàng đã thuê huấn luyện viên này.", e);
            }
            else if (e.getErrorCode() == 20002) {
                throw new RuntimeException("Thời gian thuê huấn luyện viên không được lớn hơn thời gian gói tập.", e);
            }
            else if (e.getErrorCode() == 20003) {
                throw new RuntimeException("Mỗi khách hàng chỉ được thuê 1 huấn luyện viên.",e);
            }
            else {
                throw new RuntimeException("Lỗi SQL xảy ra: " + e.getMessage(), e);
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
    public int update(Thue t) {
        int ketQua = 0;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = JDBC.getConnection();
            String sqlCall = "{call ThayDoiHuanLuyenVien(?,?,?)}";
            stmt = conn.prepareCall(sqlCall);

            stmt.setString(1, t.getId_KH());
            stmt.setString(2, t.getId_HLV());
            stmt.setInt(3, t.getThoiGianThue());

            stmt.execute();
            ketQua = 1; 
        } catch (SQLException e) {
            if (e.getErrorCode() == 20001) {
                throw new RuntimeException("Khách hàng đã thuê huấn luyện viên này.", e);
            } else if (e.getErrorCode() == 20002) {
                throw new RuntimeException("Thời gian thuê huấn luyện viên không được lớn hơn thời gian gói tập.", e);
            }
            else {
                throw new RuntimeException("Lỗi SQL xảy ra: " + e.getMessage(), e);
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
    public int delete(Thue t) {
       int ketQua = 0;
        Connection conn = null;
        try {
            conn = JDBC.getConnection();
            String sql = "DELETE FROM THUE WHERE Id_KH = ?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, t.getId_KH());
            
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(conn);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua; 
    }

    @Override
    public ArrayList<Thue> selectAll() {
        ArrayList<Thue> thueList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = JDBC.getConnection();
            String sql = "SELECT Id_KH, Id_HLV, NGAYBD, NGAYKT, ThoiGianThue, TongTienThue FROM THUE WHERE isDeleted = 0 ORDER BY TO_NUMBER(SUBSTR(Id_KH, 3)) ASC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String id_KH = rs.getString("Id_KH");
                String id_HLV = rs.getString("Id_HLV");
                Date ngayBD = rs.getDate("NGAYBD");
                Date ngayKT = rs.getDate("NGAYKT");
                int thoiGianThue = rs.getInt("ThoiGianThue");
                double tongTien = rs.getDouble("TongTienThue");

                Thue thue = new Thue(id_KH, id_HLV, ngayBD, ngayKT, thoiGianThue, tongTien);
                thueList.add(thue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return thueList;
    }


    @Override
    public Thue selectById(String t) {
        Thue thue = null;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM THUE WHERE Id_KH = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                String id_KH = rs.getString("Id_KH");
                String id_HLV = rs.getString("Id_HLV");
                Date ngayBD = rs.getDate("NGAYBD");
                Date ngayKT = rs.getDate("NGAYHH");
                int thoiGianThue = rs.getInt("ThoiGianThue");
                double tongTien = rs.getDouble("TongTienThue");
                
                thue = new Thue(id_KH, id_HLV, ngayBD, ngayKT, thoiGianThue, tongTien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thue;
    }

}
