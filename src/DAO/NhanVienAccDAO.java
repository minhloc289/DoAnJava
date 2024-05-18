/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import model.NhanVienAcc;
import database.JDBC;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author locmi
 */
public class NhanVienAccDAO implements DAOInterface<NhanVienAcc> {
    public static NhanVienAccDAO getInstance(){
        return new NhanVienAccDAO();
    }

    @Override
    public int insert(NhanVienAcc t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(NhanVienAcc t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(NhanVienAcc t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<NhanVienAcc> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NhanVienAcc selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    boolean checkLogin (String username, String password) {
        try {
            Connection con = JDBC.getConnection();
            
            String sql = "SELECT * FROM NHANVIENACC WHERE UserName = ? AND Password = ?"; 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return false;
    }

}
