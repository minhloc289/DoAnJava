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
public class NhanVienAcc {
    private String id_NV;
    private String tenDN;
    private String matKhau;
    private String trangThai;

    public NhanVienAcc(String id_NV, String tenDN, String matKhau, String trangThai) {
        this.id_NV = id_NV;
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public String getId_NV() {
        return id_NV;
    }

    public String getTenDN() {
        return tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getTrangThai() {
        return trangThai;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id_NV);
        hash = 97 * hash + Objects.hashCode(this.tenDN);
        hash = 97 * hash + Objects.hashCode(this.matKhau);
        hash = 97 * hash + Objects.hashCode(this.trangThai);
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
        final NhanVienAcc other = (NhanVienAcc) obj;
        if (!Objects.equals(this.id_NV, other.id_NV)) {
            return false;
        }
        if (!Objects.equals(this.tenDN, other.tenDN)) {
            return false;
        }
        if (!Objects.equals(this.matKhau, other.matKhau)) {
            return false;
        }
        return Objects.equals(this.trangThai, other.trangThai);
    }

    @Override
    public String toString() {
        return "NhanVienAcc{" + "id_NV=" + id_NV + ", tenDN=" + tenDN + ", matKhau=" + matKhau + ", trangThai=" + trangThai + '}';
    }
    
    
}
