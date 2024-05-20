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
public class Thue {
    private String id_KH;
    private String id_HLV;
    private Date ngayBD;
    private Date ngayKT;
    private int thoiGianThue;
    
    public Thue(){};
    
    public Thue(String id_KH, String id_HLV, Date ngayBD, Date ngayKT, int thoiGianThue) {
        this.id_KH = id_KH;
        this.id_HLV = id_HLV;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.thoiGianThue = thoiGianThue;
    }

    public String getId_KH() {
        return id_KH;
    }

    public String getId_HLV() {
        return id_HLV;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public int getThoiGianThue() {
        return thoiGianThue;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id_KH);
        hash = 23 * hash + Objects.hashCode(this.id_HLV);
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
        final Thue other = (Thue) obj;
        if (this.thoiGianThue != other.thoiGianThue) {
            return false;
        }
        if (!Objects.equals(this.id_KH, other.id_KH)) {
            return false;
        }
        if (!Objects.equals(this.id_HLV, other.id_HLV)) {
            return false;
        }
        if (!Objects.equals(this.ngayBD, other.ngayBD)) {
            return false;
        }
        return Objects.equals(this.ngayKT, other.ngayKT);
    }

    @Override
    public String toString() {
        return "Thue{" + "id_KH=" + id_KH + ", id_HLV=" + id_HLV + ", ngayBD=" + ngayBD + ", ngayKT=" + ngayKT + ", thoiGianThue=" + thoiGianThue + '}';
    }
    
    
}
