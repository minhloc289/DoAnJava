/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.HuanLuyenVien;
import database.JDBC;
import java.sql.*;
import java.util.ArrayList;


public class HuanLuyenVienDAO implements DAOInterface<HuanLuyenVien> {
     public static HuanLuyenVienDAO getInstance(){
        return new HuanLuyenVienDAO();
    }

    @Override
    public int insert(HuanLuyenVien t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(HuanLuyenVien t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(HuanLuyenVien t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<HuanLuyenVien> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HuanLuyenVien selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
