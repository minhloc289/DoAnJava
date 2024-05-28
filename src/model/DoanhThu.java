/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
/**
 *
 * @author locmi
 */
public class DoanhThu {
    private String id_TToan;
    private String id_KH;
    private String tenKH;
    private Date ngayTT;
    private double tongTien;
    private String tenNV;
    
    public DoanhThu(){};

    public DoanhThu(String id_TToan, String id_KH, String tenKH, Date ngayTT, double tongTien, String tenNV) {
        this.id_TToan = id_TToan;
        this.id_KH = id_KH;
        this.tenKH = tenKH;
        this.ngayTT = ngayTT;
        this.tongTien = tongTien;
        this.tenNV = tenNV;
    }
    
    
    
    public String getId_TToan() {
        return id_TToan;
    }

    public String getId_KH() {
        return id_KH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public Date getNgayTT() {
        return ngayTT;
    }

    public double getTongTien() {
        return tongTien;
    }

    public String getTenNV() {
        return tenNV;
    }
    
    

    @Override
    public String toString() {
        return "DoanhThu{" + "id_TToan=" + id_TToan + ", id_KH=" + id_KH + ", tenKH=" + tenKH + ", ngayTT=" + ngayTT + ", tongTien=" + tongTien + ", tenNV=" + tenNV + '}';
    }
    
    
}
