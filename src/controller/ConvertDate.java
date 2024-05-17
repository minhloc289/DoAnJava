/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAO.KhachHangDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author locmi
 */
public class ConvertDate {
    public static ConvertDate getInstance() {
        return new ConvertDate();
    }
    
    private Date convertStringToDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date utilDate = sdf.parse(dateStr);
        return new Date(utilDate.getTime());
    }
}
