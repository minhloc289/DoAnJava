
package DAO;

import model.GOITAP;
import database.JDBC;
import java.sql.*;
import java.util.ArrayList;


public class GoiTapDAO implements DAOInterface<GOITAP> {
    
    
     public static GoiTapDAO getInstance(){
        return new GoiTapDAO();
    }

    @Override
    public int insert(GOITAP t) {
        int ketQua = 0;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "INSERT INTO GOITAP (id_GT, tenGoi, moTa, giaTien) Values (?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getId_GT());
            pst.setString(2, t.getTenGoi());
            pst.setString(3, t.getMoTa());
            pst.setDouble(4, t.getGiaTien());
            
            ketQua = pst.executeUpdate();

        }
        catch(SQLException e) {
                e.printStackTrace();
            
        }   
        return ketQua;
    }

    @Override
    public int update(GOITAP t) {
        int ketQua = 0;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "UPDATE GOITAP SET  tenGoi = ?, moTa = ?, giaTien = ? WHERE id_GT = ? AND isDeleted = 0";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(4, t.getId_GT());
            pst.setString(1, t.getTenGoi());
            pst.setString(2, t.getMoTa());
            pst.setDouble(3, t.getGiaTien());
            
            
            ketQua = pst.executeUpdate();
            
        } catch (SQLException e) {
            
                e.printStackTrace();
            
        }
        return ketQua;    }

    @Override
    public int delete(GOITAP t) {
        int ketQua = 0;
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = JDBC.getConnection();
            String sqlCall = "{call XoaGoiTap(?)}";
            stmt = conn.prepareCall(sqlCall);
            stmt.setString(1, t.getId_GT());
            stmt.execute();
            
        ketQua = 1;
    } catch (SQLException e) {
            e.printStackTrace();
    }
    finally {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return ketQua;    
    }

    @Override
    public ArrayList<GOITAP> selectAll() {
        ArrayList<GOITAP> gtList = new ArrayList<>();
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM GOITAP WHERE isDeleted = 0 ORDER BY Id_GT ASC";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Id_GT = rs.getString("Id_GT");
                String MoTa = rs.getString("MoTa");
                String TenGoi = rs.getString("TenGoi");
                Double GiaTien = rs.getDouble("GiaTien");
                
                GOITAP gt = new GOITAP(Id_GT, TenGoi, MoTa, GiaTien);
                gtList.add(gt);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gtList;       }

    @Override
    public GOITAP selectById(String t) {
        GOITAP gt = null;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM GOITAP WHERE Id_GT = ? AND isDeleted = 0";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Id_GT = rs.getString("Id_GT");
                String MoTa = rs.getString("MoTa");
                String TenGoi = rs.getString("TenGoi");
                Double GiaTien = rs.getDouble("GiaTien");
                gt = new GOITAP(Id_GT, MoTa, TenGoi, GiaTien);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gt;    
    }
    
    
}
