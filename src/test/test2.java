package test;

import database.JDBC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class test2 {
    public static void main(String[] args) {
        int result = 0;
        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            // Thiết lập kết nối tới cơ sở dữ liệu
            conn = JDBC.getConnection();

            // Câu lệnh SQL để gọi procedure
            String sql = "{CALL CapNhatTaiKhoanNhanVien(?, ?, ?)}";
            cstmt = conn.prepareCall(sql);

            // Đặt các tham số cho procedure
            cstmt.setString(1, "22520784");
            cstmt.setString(2, "abc");
            cstmt.setString(3, "28092004");

            // Thực thi procedure
            result = cstmt.executeUpdate();

            // Commit nếu thực thi thành công
            conn.commit();
        } catch (SQLException e) {
            if (e.getErrorCode() == 20002) {
                System.out.println("Tên đăng nhập đã tồn tại!");
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
    }
}
