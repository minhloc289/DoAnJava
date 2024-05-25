package test;

import database.JDBC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class test2 {
    public static void main(String[] args) {
        int ketQua = 0;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = JDBC.getConnection();
            String sqlCall = "{call ThemThanhToan(?,?,?)}";
            stmt = conn.prepareCall(sqlCall);

            stmt.setString(1, "T001");
            stmt.setString(2, "KH004");
            stmt.setString(3, "22520784");

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
    }
}
