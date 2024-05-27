/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
/**
 *
 * @author locmi
 */
public class ConvertDate {
    public static ConvertDate getInstance() {
        return new ConvertDate();
    }
    public static Date convertStringToDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = sdf.parse(dateStr);
        return new Date(date.getTime()); // Chuyển đổi java.util.Date sang java.sql.Date
    }
}
