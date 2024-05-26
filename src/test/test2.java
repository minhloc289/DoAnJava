package test;

import DAO.ThanhToanDAO;
import database.JDBC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import model.ThanhToanDetail;

public class test2 {
    public static void main(String[] args) {
        int ketQua = 0;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = JDBC.getConnection();
            String sqlCall = "{call DangKyTheTap(?,?,?)}";
            stmt = conn.prepareCall(sqlCall);

            stmt.setString(1, "TT005");
            stmt.setString(2, "KH00124");
            stmt.setString(3, "GT002");

            stmt.execute();
            ketQua = 1;

        } catch (SQLException e) {
            if (e.getErrorCode() == 20001) {
                throw new RuntimeException("Không tìm thấy hoặc khách hàng đã bị xóa.", e);
            }
            else if (e.getErrorCode() == 20002) {
                throw new RuntimeException("Không tìm thấy hoặc gói tập đã bị xóa.", e);
            }
            else if (e.getErrorCode() == 20003) {
                throw new RuntimeException("Mỗi khách hàng chỉ được phép có 1 thẻ tập",e);
            }
            else if (e.getErrorCode() == 20004) {
                throw new RuntimeException("Ngày hết hạn phải lớn hơn ngày bắt đầu", e);
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
