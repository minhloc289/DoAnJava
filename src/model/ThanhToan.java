/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Objects;
import java.util.Date;
/**
 *
 * @author locmi
 */
public class ThanhToan {
    private String id_TTOAN;
    private Date ngayLap;
    private double tongTien;
    private String trangThai;
    private String id_KH;
    private String id_GT;
    private String id_NV;

    public ThanhToan(String id_TTOAN, Date ngayLap, double tongTien, String trangThai, String id_KH, String id_GT, String id_NV) {
        this.id_TTOAN = id_TTOAN;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.id_KH = id_KH;
        this.id_GT = id_GT;
        this.id_NV = id_NV;
    }

    public String getId_TTOAN() {
        return id_TTOAN;
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

    public String getId_KH() {
        return id_KH;
    }

    public String getId_GT() {
        return id_GT;
    }

    public String getId_NV() {
        return id_NV;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id_TTOAN);
        hash = 83 * hash + Objects.hashCode(this.ngayLap);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.tongTien) ^ (Double.doubleToLongBits(this.tongTien) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.trangThai);
        hash = 83 * hash + Objects.hashCode(this.id_KH);
        hash = 83 * hash + Objects.hashCode(this.id_GT);
        hash = 83 * hash + Objects.hashCode(this.id_NV);
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
        if (!Objects.equals(this.trangThai, other.trangThai)) {
            return false;
        }
        if (!Objects.equals(this.id_KH, other.id_KH)) {
            return false;
        }
        if (!Objects.equals(this.id_GT, other.id_GT)) {
            return false;
        }
        if (!Objects.equals(this.id_NV, other.id_NV)) {
            return false;
        }
        return Objects.equals(this.ngayLap, other.ngayLap);
    }

    @Override
    public String toString() {
        return "ThanhToan{" + "id_TTOAN=" + id_TTOAN + ", ngayLap=" + ngayLap + ", tongTien=" + tongTien + ", trangThai=" + trangThai + ", id_KH=" + id_KH + ", id_GT=" + id_GT + ", id_NV=" + id_NV + '}';
    }
    
    
}
