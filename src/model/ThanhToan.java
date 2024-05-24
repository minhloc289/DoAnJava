/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Objects;
import java.sql.Date;
/**
 *
 * @author locmi
 */
public class ThanhToan {
    private String id_TTOAN;
    private String id_KH;
    private String id_NV;
    private Date ngayLap;
    private double tongTien;
    private String trangThai;
    
    
    
    public ThanhToan(){};

    public ThanhToan(String id_TTOAN, String id_KH, String id_NV, Date ngayLap, double tongTien, String trangThai) {
        this.id_TTOAN = id_TTOAN;
        this.id_KH = id_KH;
        this.id_NV = id_NV;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public String getId_TTOAN() {
        return id_TTOAN;
    }

    public String getId_KH() {
        return id_KH;
    }

    public String getId_NV() {
        return id_NV;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id_TTOAN);
        hash = 71 * hash + Objects.hashCode(this.id_KH);
        hash = 71 * hash + Objects.hashCode(this.id_NV);
        hash = 71 * hash + Objects.hashCode(this.ngayLap);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ThanhToan other = (ThanhToan) obj;
        if (Double.doubleToLongBits(this.tongTien) != Double.doubleToLongBits(other.tongTien)) {
            return false;
        }
        if (!Objects.equals(this.id_TTOAN, other.id_TTOAN)) {
            return false;
        }
        if (!Objects.equals(this.id_KH, other.id_KH)) {
            return false;
        }
        if (!Objects.equals(this.id_NV, other.id_NV)) {
            return false;
        }
        if (!Objects.equals(this.trangThai, other.trangThai)) {
            return false;
        }
        return Objects.equals(this.ngayLap, other.ngayLap);
    }

    @Override
    public String toString() {
        return "ThanhToan{" + "id_TTOAN=" + id_TTOAN + ", id_KH=" + id_KH + ", id_NV=" + id_NV + ", ngayLap=" + ngayLap + ", tongTien=" + tongTien + ", trangThai=" + trangThai + '}';
    }

    
    
    
}
