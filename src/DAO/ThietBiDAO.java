/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import database.JDBC;
import java.sql.*;
import java.util.ArrayList;
import model.ThietBi;
/**
 *
 * @author ADMIN
 */
public class ThietBiDAO implements DAOInterface<ThietBi> {
    // Singleton pattern implementation
    private static ThietBiDAO instance;

    private ThietBiDAO() {}

    public static synchronized ThietBiDAO getInstance() {
        if (instance == null) {
            instance = new ThietBiDAO();
        }
        return instance;
    }

    @Override
    public int insert(ThietBi t) {
        String sql = "INSERT INTO THIETBI(Id_TB, TENTB, LOAITB, SOLUONG, TINHTRANG) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = JDBC.getConnection();
             PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, t.getId_TB());
            pstm.setString(2, t.getTenTB());
            pstm.setString(3, t.getLoaiTB());
            pstm.setInt(4, t.getSoLuong());
            pstm.setString(5, t.getTinhTrang());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(ThietBi t) {
        String sql = "UPDATE THIETBI SET TENTB = ?, LOAITB = ?, SOLUONG = ?, TINHTRANG = ? WHERE Id_TB = ? AND ISDELETED = 0";
        try (Connection con = JDBC.getConnection();
             PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, t.getTenTB());
            pstm.setString(2, t.getLoaiTB());
            pstm.setInt(3, t.getSoLuong());
            pstm.setString(4, t.getTinhTrang());
            pstm.setString(5, t.getId_TB());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(ThietBi t) {
        String sql = "DELETE FROM THIETBI WHERE Id_TB = ?";
        try (Connection con = JDBC.getConnection();
             PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, t.getId_TB());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public ArrayList<ThietBi> selectAll() {
        ArrayList<ThietBi> listTB = new ArrayList<>();
        String sql = "SELECT * FROM THIETBI WHERE ISDELETED = 0 ORDER BY Id_TB ASC";
        try (Connection con = JDBC.getConnection();
             PreparedStatement pstm = con.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                String id_TB = rs.getString("Id_TB");
                String tenTB = rs.getString("TenTB");
                String loaiTB = rs.getString("LoaiTB");
                int soluong = rs.getInt("SoLuong");
                String tinhtrang = rs.getString("TinhTrang");
                ThietBi tb = new ThietBi(id_TB, tenTB, loaiTB, soluong, tinhtrang);
                listTB.add(tb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTB;
    }

    @Override
    public ThietBi selectById(String t) {
        ThietBi tb = null;
        String sql = "SELECT * FROM THIETBI WHERE Id_TB = ? AND ISDELETED = 0";
        try (Connection con = JDBC.getConnection();
             PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, t);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String id_TB = rs.getString("Id_TB");
                    String tenTB = rs.getString("TenTB");
                    String loaiTB = rs.getString("LoaiTB");
                    int soluong = rs.getInt("SoLuong");
                    String tinhtrang = rs.getString("TinhTrang");
                    tb = new ThietBi(id_TB, tenTB, loaiTB, soluong, tinhtrang);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tb;
    }
}


