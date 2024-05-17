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
public class NhanVien {
    private String Id_NV;
    private String HoTen;
    private Date NgaySinh;
    private String GioiTinh;
    private String DiaChi;
    private String soDT;
    private Date NgayVL;
    private String ChucVu;
    private String Email;

    public NhanVien(String Id_NV, String HoTen, Date NgaySinh, String GioiTinh, String DiaChi, String soDT, Date NgayVL, String ChucVu, String Email) {
        this.Id_NV = Id_NV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.soDT = soDT;
        this.NgayVL = NgayVL;
        this.ChucVu = ChucVu;
        this.Email = Email;
    }

    public String getId_NV() {
        return Id_NV;
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

    public Date getNgayVL() {
        return NgayVL;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.Id_NV);
        hash = 29 * hash + Objects.hashCode(this.HoTen);
        hash = 29 * hash + Objects.hashCode(this.soDT);
        hash = 29 * hash + Objects.hashCode(this.NgayVL);
        hash = 29 * hash + Objects.hashCode(this.ChucVu);
        hash = 29 * hash + Objects.hashCode(this.Email);
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
        final NhanVien other = (NhanVien) obj;
        if (!Objects.equals(this.Id_NV, other.Id_NV)) {
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
        if (!Objects.equals(this.ChucVu, other.ChucVu)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.NgaySinh, other.NgaySinh)) {
            return false;
        }
        return Objects.equals(this.NgayVL, other.NgayVL);
    }

    @Override
    public String toString() {
        return "NhanVien{" + "Id_NV=" + Id_NV + ", HoTen=" + HoTen + ", NgaySinh=" + NgaySinh + ", GioiTinh=" + GioiTinh + ", DiaChi=" + DiaChi + ", soDT=" + soDT + ", NgayVL=" + NgayVL + ", ChucVu=" + ChucVu + ", Email=" + Email + '}';
    }
    
    
}
