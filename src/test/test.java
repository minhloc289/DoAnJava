/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import DAO.KhachHangDAO;
import DAO.NhanVienAccDAO;
import java.sql.Date;
import model.KhachHang;
import model.NhanVienAcc;
/**
 *
 * @author locmi
 */
public class test {
    public static void main(String[] args) {
        NhanVienAcc nv = new NhanVienAcc(
                "22520784",
                "minhloc",
                "28092004",
                "Hoạt động"
        );
        NhanVienAccDAO acc = NhanVienAccDAO.getInstance();
        int result = acc.insert(nv);

        if (result > 0) {
            System.out.println("Chèn dữ liệu thành công!");
        } else {
            System.out.println("Chèn dữ liệu thất bại.");
        }
    }
}
