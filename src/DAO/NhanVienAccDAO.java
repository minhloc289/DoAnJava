/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import model.NhanVienAcc;
import database.JDBC;
import java.sql.*;
import java.util.ArrayList;
import model.User;


/**
 *
 * @author locmi
 */
public class NhanVienAccDAO implements DAOInterface<NhanVienAcc> {
    public static NhanVienAccDAO getInstance(){
        return new NhanVienAccDAO();
    }

    @Override
    public int insert(NhanVienAcc t) {
        int result = 0;
        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            // Thiết lập kết nối tới cơ sở dữ liệu
            conn = JDBC.getConnection();

            // Câu lệnh SQL để gọi procedure
            String sql = "{CALL ThemTaiKhoanNhanVien(?, ?, ?)}";
            cstmt = conn.prepareCall(sql);

            // Đặt các tham số cho procedure
            cstmt.setString(1, t.getId_NV());
            cstmt.setString(2, t.getTenDN());
            cstmt.setString(3, t.getMatKhau());

            // Thực thi procedure
            result = cstmt.executeUpdate();

            // Commit nếu thực thi thành công
        } catch (SQLException e) {
            if (e.getErrorCode() == 20001) {
                throw new RuntimeException("Nhân viên không tồn tại", e);
            }
            else if (e.getErrorCode() == 20002) {
                throw new RuntimeException("Tên đăng nhập đã tồn tại", e);
            }
            else {
                e.printStackTrace();
            }
        } finally {
            // Đóng các tài nguyên
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int update(NhanVienAcc t) {
        int result = 0;
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            // Thiết lập kết nối tới cơ sở dữ liệu
            conn = JDBC.getConnection();

            // Câu lệnh SQL để gọi procedure
            String sql = "{CALL SuaTaiKhoanNhanVien(?, ?, ?)}";
            cstmt = conn.prepareCall(sql);

            // Đặt các tham số cho procedure
            cstmt.setString(1, t.getId_NV());
            cstmt.setString(2, t.getTenDN());
            cstmt.setString(3, t.getMatKhau());

            // Thực thi procedure
            result = cstmt.executeUpdate();

            // Commit nếu thực thi thành công
        } catch (SQLException e) {
            if (e.getErrorCode() == 20002) {
                throw new RuntimeException("Tên đăng nhập đã tồn tại", e);
            }
            else {
                e.printStackTrace();
            }
        } finally {
            // Đóng các tài nguyên
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int delete(NhanVienAcc t) {
        int ketQua = 0;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "DELETE FROM NHANVIENACC WHERE Id_NV = ?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, t.getId_NV());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<NhanVienAcc> selectAll() {
        ArrayList<NhanVienAcc> ketQua = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = JDBC.getConnection();
            String sql = "SELECT * FROM NHANVIENACC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String id_nv = rs.getString("Id_NV");
                String tenDN = rs.getString("TenDN");
                String matKhau = rs.getString("MatKhau");
                String trangThai = rs.getString("TrangThai");
            
                NhanVienAcc acc = new NhanVienAcc(id_nv, tenDN, matKhau, trangThai);
                ketQua.add(acc);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các tài nguyên kết nối
            JDBC.closeConnection(conn);
        }
        return ketQua;
    }

    @Override
    public NhanVienAcc selectById(String t) {
        NhanVienAcc nhanVien = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = JDBC.getConnection();
            String sql = "SELECT * FROM NHANVIENACC WHERE Id_NV = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            rs = pst.executeQuery();

            while (rs.next()) {
                String id_nv = rs.getString("Id_NV");
                String tenDN = rs.getString("TenDN");
                String matKhau = rs.getString("MatKhau");
                String trangThai = rs.getString("TrangThai");

                nhanVien = new NhanVienAcc(id_nv, tenDN, matKhau, trangThai);
            }
            JDBC.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nhanVien;
    }
    
    public boolean checkLogin (String username, String password){
        try {
            Connection con = JDBC.getConnection();
            
            String sql = "SELECT * FROM NHANVIENACC WHERE TenDN = ? and MatKhau = ?"; 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return false;
    }
    
    public User getUserByUsername(String username) {
        User user = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conn = JDBC.getConnection();

        try {
            String sql = "SELECT nv.*, acc.TenDN FROM NHANVIEN nv JOIN NHANVIENACC acc ON nv.Id_NV = acc.Id_NV WHERE acc.TenDN = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("TenDN"));
                user.setChucVu(rs.getString("ChucVu"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
        return user;
    }

}
