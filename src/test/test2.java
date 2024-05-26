package test;

import DAO.ThanhToanDAO;
import database.JDBC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import model.ThanhToanDetail;

public class test2 {
    public static void main(String[] args) {
        ThanhToanDetail detail = ThanhToanDAO.getInstance().xemThongTinThanhToan("T002");
        if (detail != null) {
            System.out.println("Id_TToan: " + detail.getId_TTOAN());
            System.out.println("Id_KH: " + detail.getId_KH());
            System.out.println("Id_NV: " + detail.getId_NV());
            System.out.println("NgayLap: " + detail.getNgayLap());
            System.out.println("TongTien: " + detail.getTongTien());
            System.out.println("NgayTT: " + detail.getNgayTT());
            System.out.println("TenKH: " + detail.getTenKH());
            System.out.println("TenNV: " + detail.getTenNV());
        } else {
            System.out.println("Không tìm thấy thông tin thanh toán.");
        }
    }
}
