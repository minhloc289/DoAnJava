/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 *
 * @author locmi
 */
public class CurrencyUtils {
    private static final DecimalFormat currencyFormat = new DecimalFormat("###,###,###");

    public static String formatCurrency(double amount) {
        return currencyFormat.format(amount);
    }

    public static double parseCurrency(String currency) throws ParseException {
        return currencyFormat.parse(currency).doubleValue();
    }
}
