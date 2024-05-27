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
public class ThongKeTheTap extends TheTap {
    private String hoTen;
    private String tenGoiTap;

    public ThongKeTheTap() {}

    public ThongKeTheTap(String id_TTap, String id_KH, String id_GT, Date ngayBD, Date ngayHH, String hoTen, String tenGoiTap) {
        super(id_TTap, id_KH, id_GT, ngayBD, ngayHH);
        this.hoTen = hoTen;
        this.tenGoiTap = tenGoiTap;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTenGoiTap() {
        return tenGoiTap;
    }

    public void setTenGoiTap(String tenGoiTap) {
        this.tenGoiTap = tenGoiTap;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(hoTen, tenGoiTap);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ThongKeTheTap other = (ThongKeTheTap) obj;
        return Objects.equals(hoTen, other.hoTen) && Objects.equals(tenGoiTap, other.tenGoiTap);
    }

    @Override
    public String toString() {
        return "ThongKeTheTap{" +
                "id_TTap=" + getId_TTap() +
                ", id_KH=" + getId_KH() +
                ", id_GT=" + getId_GT() +
                ", ngayBD=" + getNgayBD() +
                ", ngayHH=" + getNgayHH() +
                ", hoTen='" + hoTen + '\'' +
                ", tenGoiTap='" + tenGoiTap + '\'' +
                '}';
    }
}
