package test;

import DAO.ThanhToanDAO;
import DAO.ThongKeDAO;
import DAO.ThueDAO;
import database.JDBC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ThanhToanDetail;
import model.ThongKeTheTap;
import model.Thue;

public class test2 {
     public static void main(String[] args) {
        ThueDAO thue = new ThueDAO();
        Thue t = thue.selectById("KH001");
        
    }
}
