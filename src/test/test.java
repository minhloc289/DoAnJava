/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import DAO.KhachHangDAO;
import java.sql.Date;
import model.KhachHang;
/**
 *
 * @author locmi
 */
public class test {
    public static void main(String[] args) {
        KhachHang khachHang = new KhachHang(
                "KH002",
                "Tran Van B",
                Date.valueOf("1992-05-12"),
                "Nam",
                "456 Đường XYZ, Quận 2, TP.HCM",
                "0987654321",
                "tranvanb@example.com"
        );
        System.out.println('ABC');

        KhachHangDAO khachHangDAO = KhachHangDAO.getInstance();
        int result = khachHangDAO.insert(khachHang);

        if (result > 0) {
            System.out.println("Chèn dữ liệu thành công!");
        } else {
            System.out.println("Chèn dữ liệu thất bại.");
        }
    }
}
