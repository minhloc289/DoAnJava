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
public class HuanLuyenVien {
    private String Id_HLV;
    private String HoTen;
    private Date NgaySinh;
    private String GioiTinh;
    private String DiaChi;
    private String soDT;
    private Date NgayVL;
    private String ChuyenMon;
    private String Email;

    public HuanLuyenVien(String Id_HLV, String HoTen, Date NgaySinh, String GioiTinh, String DiaChi, String soDT, Date NgayVL, String ChuyenMon, String Email) {
        this.Id_HLV = Id_HLV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.soDT = soDT;
        this.NgayVL = NgayVL;
        this.ChuyenMon = ChuyenMon;
        this.Email = Email;
    }

    public String getId_HLV() {
        return Id_HLV;
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

    public String getChuyenMon() {
        return ChuyenMon;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.Id_HLV);
        hash = 71 * hash + Objects.hashCode(this.HoTen);
        hash = 71 * hash + Objects.hashCode(this.soDT);
        hash = 71 * hash + Objects.hashCode(this.NgayVL);
        hash = 71 * hash + Objects.hashCode(this.Email);
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
        final HuanLuyenVien other = (HuanLuyenVien) obj;
        if (!Objects.equals(this.Id_HLV, other.Id_HLV)) {
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
        if (!Objects.equals(this.ChuyenMon, other.ChuyenMon)) {
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
        return "HuanLuyenVien{" + "Id_HLV=" + Id_HLV + ", HoTen=" + HoTen + ", NgaySinh=" + NgaySinh + ", GioiTinh=" + GioiTinh + ", DiaChi=" + DiaChi + ", soDT=" + soDT + ", NgayVL=" + NgayVL + ", ChuyenMon=" + ChuyenMon + ", Email=" + Email + '}';
    }
    
    
}
