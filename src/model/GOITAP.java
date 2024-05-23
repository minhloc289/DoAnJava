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
public class GoiTap {
    private String id_GT;
    private String tenGoi;
    private String moTa;
    private double giaTien;
    
    public GoiTap(){};
    
    public GoiTap(String id_GT, String tenGoi, String moTa, double giaTien) {
        this.id_GT = id_GT;
        this.tenGoi = tenGoi;
        this.moTa = moTa;
        this.giaTien = giaTien;
    }

    public String getId_GT() {
        return id_GT;
    }

    public String getTenGoi() {
        return tenGoi;
    }

    public String getMoTa() {
        return moTa;
    }

    public double getGiaTien() {
        return giaTien;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id_GT);
        hash = 17 * hash + Objects.hashCode(this.tenGoi);
        hash = 17 * hash + Objects.hashCode(this.moTa);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.giaTien) ^ (Double.doubleToLongBits(this.giaTien) >>> 32));
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
        if (Double.doubleToLongBits(this.giaTien) != Double.doubleToLongBits(other.giaTien)) {
            return false;
        }
        if (!Objects.equals(this.id_GT, other.id_GT)) {
            return false;
        }
        if (!Objects.equals(this.tenGoi, other.tenGoi)) {
            return false;
        }
        return Objects.equals(this.moTa, other.moTa);
    }

    @Override
    public String toString() {
        return "GoiTap{" + "id_GT=" + id_GT + ", tenGoi=" + tenGoi + ", moTa=" + moTa + ", giaTien=" + giaTien + '}';
    }
    
}
