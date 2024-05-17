/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
import java.util.Objects;
/**
 *
 * @author locmi
 */
public class GoiTap {
    private String Id_GT;
    private String TenGoi;
    private String MoTa;
    private Date NgayBD;
    private Date NgayHH;
    private float GiaTien;

    public GoiTap(String Id_GT, String TenGoi, String MoTa, Date NgayBD, Date NgayHH, float GiaTien) {
        this.Id_GT = Id_GT;
        this.TenGoi = TenGoi;
        this.MoTa = MoTa;
        this.NgayBD = NgayBD;
        this.NgayHH = NgayHH;
        this.GiaTien = GiaTien;
    }

    public String getId_GT() {
        return Id_GT;
    }

    public String getTenGoi() {
        return TenGoi;
    }

    public String getMoTa() {
        return MoTa;
    }

    public Date getNgayBD() {
        return NgayBD;
    }

    public Date getNgayHH() {
        return NgayHH;
    }

    public float getGiaTien() {
        return GiaTien;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.Id_GT);
        hash = 89 * hash + Objects.hashCode(this.TenGoi);
        hash = 89 * hash + Objects.hashCode(this.MoTa);
        hash = 89 * hash + Objects.hashCode(this.NgayBD);
        hash = 89 * hash + Objects.hashCode(this.NgayHH);
        hash = 89 * hash + Float.floatToIntBits(this.GiaTien);
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
        final GoiTap other = (GoiTap) obj;
        if (Float.floatToIntBits(this.GiaTien) != Float.floatToIntBits(other.GiaTien)) {
            return false;
        }
        if (!Objects.equals(this.Id_GT, other.Id_GT)) {
            return false;
        }
        if (!Objects.equals(this.TenGoi, other.TenGoi)) {
            return false;
        }
        if (!Objects.equals(this.MoTa, other.MoTa)) {
            return false;
        }
        if (!Objects.equals(this.NgayBD, other.NgayBD)) {
            return false;
        }
        return Objects.equals(this.NgayHH, other.NgayHH);
    }

    @Override
    public String toString() {
        return "GoiTap{" + "Id_GT=" + Id_GT + ", TenGoi=" + TenGoi + ", MoTa=" + MoTa + ", NgayBD=" + NgayBD + ", NgayHH=" + NgayHH + ", GiaTien=" + GiaTien + '}';
    }
    
    
}
