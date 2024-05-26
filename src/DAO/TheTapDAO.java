/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import model.TheTap;
import database.JDBC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.TheTap;

/**
 *
 * @author locmi
 */
public class TheTapDAO implements DAOInterface<TheTap> {
    
    public static TheTapDAO getInstance(){
        return new TheTapDAO();
    }

    @Override
        public int insert(TheTap t) {
           int ketQua = 0;
            Connection conn = null;
            CallableStatement stmt = null;
            try {
                conn = JDBC.getConnection();
                String sqlCall = "{call DangKyTheTap(?,?,?)}";
                stmt = conn.prepareCall(sqlCall);

                stmt.setString(1, t.getId_TTap());
                stmt.setString(2, t.getId_KH());
                stmt.setString(3, t.getId_GT());

                stmt.execute();
                ketQua = 1;

            } catch (SQLException e) {
                if (e.getErrorCode() == 20001) {
                    throw new RuntimeException("Không tìm thấy hoặc khách hàng đã bị xóa.", e);
                }
                else if (e.getErrorCode() == 20002) {
                    throw new RuntimeException("Không tìm thấy hoặc gói tập đã bị xóa.", e);
                }
                else if (e.getErrorCode() == 20003) {
                    throw new RuntimeException("Mỗi khách hàng chỉ được phép có 1 thẻ tập",e);
                }
                else {
                    throw new RuntimeException("Lỗi SQL xảy ra: " + e.getMessage(), e);
                }
            } finally {
                try {
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return ketQua; 
        }

    @Override
    public int update(TheTap t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(TheTap t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TheTap> selectAll() {
        ArrayList<TheTap> ttapList = new ArrayList<>();
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM THETAP ORDER BY Id_TTap ASC";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                String id_TTap = rs.getString("Id_TTap");
                String id_KH = rs.getString("Id_KH");
                String id_GT = rs.getString("Id_GT");
                Date ngayBD = rs.getDate("NgayBD");
                Date ngayKT = rs.getDate("NgayHH");
                
                TheTap ttap = new TheTap(id_TTap, id_KH, id_GT, ngayBD, ngayKT);
                ttapList.add(ttap);
            }
            JDBC.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ttapList;
    }

    @Override
    public TheTap selectById(String t) {
        TheTap ttap = null;
        try {
            Connection conn = JDBC.getConnection();
            String sql = "SELECT * FROM THETAP WHERE Id_TTap = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                String id_TTap = rs.getString("Id_TTap");
                String id_KH = rs.getString("Id_KH");
                String id_GT = rs.getString("Id_GT");
                Date ngayBD = rs.getDate("NgayBD");
                Date ngayKT = rs.getDate("NgayHH");
                
                ttap = new TheTap(id_TTap, id_KH, id_GT, ngayBD, ngayKT);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ttap;
    }
    
}
