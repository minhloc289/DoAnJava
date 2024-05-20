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
public class TheTap {
    private String id_TTap;
    private String id_KH;
    private String id_GT;
    private Date ngayBD;
    private Date ngayHH;
    
    public TheTap(){};
    
    public TheTap(String id_TTap, String id_KH, String id_GT, Date ngayBD, Date ngayHH) {
        this.id_TTap = id_TTap;
        this.id_KH = id_KH;
        this.id_GT = id_GT;
        this.ngayBD = ngayBD;
        this.ngayHH = ngayHH;
    }

    public String getId_TTap() {
        return id_TTap;
    }

    public String getId_KH() {
        return id_KH;
    }

    public String getId_GT() {
        return id_GT;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public Date getNgayHH() {
        return ngayHH;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id_TTap);
        hash = 29 * hash + Objects.hashCode(this.id_KH);
        hash = 29 * hash + Objects.hashCode(this.id_GT);
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
        final TheTap other = (TheTap) obj;
        if (!Objects.equals(this.id_TTap, other.id_TTap)) {
            return false;
        }
        if (!Objects.equals(this.id_KH, other.id_KH)) {
            return false;
        }
        if (!Objects.equals(this.id_GT, other.id_GT)) {
            return false;
        }
        if (!Objects.equals(this.ngayBD, other.ngayBD)) {
            return false;
        }
        return Objects.equals(this.ngayHH, other.ngayHH);
    }

    @Override
    public String toString() {
        return "TheTap{" + "id_TTap=" + id_TTap + ", id_KH=" + id_KH + ", id_GT=" + id_GT + ", ngayBD=" + ngayBD + ", ngayHH=" + ngayHH + '}';
    }
    
    
}
