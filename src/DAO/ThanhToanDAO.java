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
import model.ThanhToanDetail;

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
                throw new RuntimeException("Nhân viên không tồn tại", e);
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
    public int update(ThanhToan t) {
        int ketQua = 0;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = JDBC.getConnection();
            String sqlCall = "{call SuaThanhToan(?)}";
            stmt = conn.prepareCall(sqlCall);
            
            stmt.setString(1, t.getId_TTOAN());
            
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
            String sql = "SELECT * FROM THANHTOAN ORDER BY Id_TTOAN ASC";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                String id_TToan = rs.getString("Id_TToan");
                Date ngayLap = rs.getDate("NgayLap");
                Double tongTien = rs.getDouble("TongTien");
                String trangThai = rs.getString("TrangThai");
                String id_KH = rs.getString("Id_KH");
                String id_NV = rs.getString("Id_NV");
                Date ngayTT = rs.getDate("NgayTT");
                
                ThanhToan thanhtoan = new ThanhToan(id_TToan, id_KH, id_NV ,ngayLap, tongTien, trangThai, ngayTT);
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
                Date ngayTT = rs.getDate("NgayTT");
                
                ttoan = new ThanhToan(id_TToan, id_KH, id_NV , ngayLap, tongTien, trangThai, ngayTT);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ttoan;
    }
    
    public void CapNhatTrangThaiThanhToan(String idTTOAN) {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = JDBC.getConnection();
            String sql = "UPDATE THANHTOAN SET TrangThai = 'Đã thanh toán', NgayTT = SYSDATE WHERE Id_TTOAN = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, idTTOAN);

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật trạng thái thanh toán thành công!");
            } else {
                System.out.println("Không tìm thấy thanh toán với Id_TTOAN: " + idTTOAN);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public ThanhToanDetail xemThongTinThanhToan(String idTTOAN) {
        Connection conn = null;
        PreparedStatement pst = null;
        ThanhToanDetail ttoan = null;

        try {
            conn = JDBC.getConnection();
            String sql = "SELECT T.Id_TToan, T.Id_KH, T.Id_NV, T.NgayLap, T.TongTien AS TongTien, T.NgayTT, KH.HoTen AS TenKH, NV.HoTen AS TenNV "
                       + "FROM THANHTOAN T "
                       + "JOIN KHACHHANG KH ON T.Id_KH = KH.Id_KH "
                       + "JOIN NHANVIEN NV ON T.Id_NV = NV.Id_NV "
                       + "WHERE T.Id_TToan = ? "
                       + "AND T.TrangThai = 'Đã thanh toán'";
            pst = conn.prepareStatement(sql);
            pst.setString(1, idTTOAN);

            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                String id_TTOAN = rs.getString("Id_TToan");
                String id_KH = rs.getString("Id_KH");
                String id_NV = rs.getString("Id_NV");
                Date ngayLap = rs.getDate("NgayLap");
                double tongTien = rs.getDouble("TongTien");
                Date ngayTT = rs.getDate("NgayTT");
                String tenKH = rs.getString("TenKH");
                String tenNV = rs.getString("TenNV");

                ttoan = new ThanhToanDetail(id_TTOAN, id_KH, id_NV, ngayLap, tongTien, "Đã thanh toán", ngayTT, tenKH, tenNV);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ttoan;
    }
}
