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
            String sqlCall = "{call XoaKhachHang(?)}";
            stmt = conn.prepareCall(sqlCall);
            stmt.setString(1, "KH001");
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
    }
}
