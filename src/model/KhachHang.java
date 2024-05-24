/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
import java.util.Objects;
/**
 *
 * @author locmi
 */
public class KhachHang {
    private String Id_KH;
    private String HoTen;
    private Date NgaySinh;
    private String GioiTinh;
    private String DiaChi;
    private String soDT;
    private String Email;
    
    public KhachHang(){};

    public KhachHang(String Id_KH, String HoTen, Date NgaySinh, String GioiTinh, String DiaChi, String soDT, String Email) {
        this.Id_KH = Id_KH;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.soDT = soDT;
        this.Email = Email;
    }

    public String getId_KH() {
        return Id_KH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.Id_KH);
        hash = 53 * hash + Objects.hashCode(this.HoTen);
        hash = 53 * hash + Objects.hashCode(this.soDT);
        hash = 53 * hash + Objects.hashCode(this.Email);
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
        final KhachHang other = (KhachHang) obj;
        if (!Objects.equals(this.Id_KH, other.Id_KH)) {
            return false;
        }
        if (!Objects.equals(this.HoTen, other.HoTen)) {
            return false;
        }
        if (!Objects.equals(this.GioiTinh, other.GioiTinh)) {
            return false;
        }
        if (!Objects.equals(this.DiaChi, other.DiaChi)) {
            return false;
        }
        if (!Objects.equals(this.soDT, other.soDT)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        return Objects.equals(this.NgaySinh, other.NgaySinh);
    }

    

    @Override
    public String toString() {
        return "KhachHang{" + "Id_KH=" + Id_KH + ", HoTen=" + HoTen + ", NgaySinh=" + NgaySinh + ", GioiTinh=" + GioiTinh + ", DiaChi=" + DiaChi + ", soDT=" + soDT + ", Email=" + Email + '}';
    }
    
    
}
