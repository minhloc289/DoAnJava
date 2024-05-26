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
public class ThanhToanDetail extends ThanhToan{
    private String tenNV;
    private String tenKH;
    
    

    public ThanhToanDetail() {};

    public ThanhToanDetail(String id_TTOAN, String id_KH, String id_NV, Date ngayLap, double tongTien, String trangThai, Date ngayTT, String tenKH, String tenNV) {
        super(id_TTOAN, id_KH, id_NV, ngayLap, tongTien, trangThai, ngayTT);
        this.tenNV = tenNV;
        this.tenKH = tenKH;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    @Override
    public String toString() {
        return "ThanhToanDetail{" + "tenNV=" + tenNV + ", tenKH=" + tenKH + '}';
    }
    
    
}
