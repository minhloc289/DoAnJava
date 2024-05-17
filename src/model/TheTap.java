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
public class TheTap {
    private String id_TTap;
    private String id_KH;
    private String id_GT;

    public TheTap(String id_TTap, String id_KH, String id_GT) {
        this.id_TTap = id_TTap;
        this.id_KH = id_KH;
        this.id_GT = id_GT;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id_TTap);
        hash = 83 * hash + Objects.hashCode(this.id_KH);
        hash = 83 * hash + Objects.hashCode(this.id_GT);
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
        return Objects.equals(this.id_GT, other.id_GT);
    }

    @Override
    public String toString() {
        return "TheTap{" + "id_TTap=" + id_TTap + ", id_KH=" + id_KH + ", id_GT=" + id_GT + '}';
    }
    
    
}
