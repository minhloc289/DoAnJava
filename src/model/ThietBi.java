/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Objects;

/**
 *
 * @author locmi
 */
public class ThietBi {
    private String Id_TB;
    private String tenTB;
    private String loaiTB;
    private int SoLuong;
    private String TinhTrang;
    
    public ThietBi(){};
    
    public ThietBi(String Id_TB, String tenTB, String loaiTB, int SoLuong, String TinhTrang) {
        this.Id_TB = Id_TB;
        this.tenTB = tenTB;
        this.loaiTB = loaiTB;
        this.SoLuong = SoLuong;
        this.TinhTrang = TinhTrang;
    }

    public String getId_TB() {
        return Id_TB;
    }

    public String getTenTB() {
        return tenTB;
    }

    public String getLoaiTB() {
        return loaiTB;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.Id_TB);
        hash = 47 * hash + Objects.hashCode(this.tenTB);
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
        final ThietBi other = (ThietBi) obj;
        if (this.SoLuong != other.SoLuong) {
            return false;
        }
        if (!Objects.equals(this.Id_TB, other.Id_TB)) {
            return false;
        }
        if (!Objects.equals(this.tenTB, other.tenTB)) {
            return false;
        }
        if (!Objects.equals(this.loaiTB, other.loaiTB)) {
            return false;
        }
        return Objects.equals(this.TinhTrang, other.TinhTrang);
    }

    @Override
    public String toString() {
        return "ThietBi{" + "Id_TB=" + Id_TB + ", tenTB=" + tenTB + ", loaiTB=" + loaiTB + ", SoLuong=" + SoLuong + ", TinhTrang=" + TinhTrang + '}';
    }
    
    
}
