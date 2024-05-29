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
            if (e.getErrorCode() == 1) {
                throw new RuntimeException("Email đã tồn tại!",e);
            }
            else {
                e.printStackTrace();
            }
        }
        return ketQua;
    }


    @Override
    public int update(KhachHang t) {
        int ketQua = 0;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "UPDATE KHACHHANG SET HoTen = ?, NgaySinh = ?, GioiTinh = ?, DiaChi = ?, SoDT = ?, Email = ? WHERE Id_KH = ? AND isDeleted = 0";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getHoTen());
            pst.setDate(2, t.getNgaySinh()); 
            pst.setString(3, t.getGioiTinh());
            pst.setString(4, t.getDiaChi());
            pst.setString(5, t.getSoDT());
            pst.setString(6, t.getEmail());
            pst.setString(7, t.getId_KH());
            
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(conn);
        } catch (SQLException e) {
            if (e.getErrorCode() == 1) {
                throw new RuntimeException("Email đã tồn tại!", e);
            }
            else {
                e.printStackTrace();
            }
        }
        return ketQua;
    }

    @Override
    public int delete(KhachHang t) {
        int ketQua = 0;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = JDBC.getConnection();
            String sqlCall = "{call XoaKhachHang(?)}";
            stmt = conn.prepareCall(sqlCall);
            stmt.setString(1, t.getId_KH());
            stmt.execute();
            ketQua = 1;
            
        } catch (SQLException e) {
            if (e.getErrorCode() == 20001) {
                throw new RuntimeException("Không thể xóa khách hàng. Khách hàng đang có thẻ tập!", e);
            }
            else if (e.getErrorCode() == 20002) {
                throw new RuntimeException("Không thể xóa khách hàng. Khách hàng đang thuê huấn luyện viên!, e");
            }
            else e.printStackTrace();
        }
        finally {
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
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> khList = new ArrayList<>();
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM KHACHHANG WHERE isDeleted = 0 ORDER BY TO_NUMBER(SUBSTR(Id_KH, 3)) ASC";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id_KH = rs.getString("Id_KH");
                String HoTen = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                String GioiTinh = rs.getString("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String SDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                KhachHang kh = new KhachHang(id_KH, HoTen, NgaySinh, GioiTinh, DiaChi, SDT, email);
                khList.add(kh);
            }
            JDBC.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khList;
    }

    @Override
    public KhachHang selectById(String t) {
        KhachHang kh = null;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM KHACHHANG WHERE Id_KH = ? AND isDeleted = 0";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id_KH = rs.getString("Id_KH");
                String HoTen = rs.getString("HoTen");
                Date NgaySinh = rs.getDate("NgaySinh");
                String GioiTinh = rs.getString("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String SDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                kh = new KhachHang(id_KH, HoTen, NgaySinh, GioiTinh, DiaChi, SDT, email);
            }
            JDBC.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kh;
    }
    
}
