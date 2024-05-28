package test;

import DAO.ThanhToanDAO;
import DAO.ThongKeDAO;
import database.JDBC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ThanhToanDetail;
import model.ThongKeTheTap;

public class test2 {
     public static void main(String[] args) {
        // Tạo kết nối đến cơ sở dữ liệu
        Connection conn = JDBC.getConnection();

        // Tạo đối tượng ThongKeDAO
        ThongKeDAO thongKeDAO = new ThongKeDAO();

        // Gọi phương thức dsKhachHang
        ArrayList<ThongKeTheTap> ketQua = thongKeDAO.dsKhachHang();

        // In ra kết quả
        for (ThongKeTheTap tk : ketQua) {
            System.out.println(tk);
        }
    }
}
