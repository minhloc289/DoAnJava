/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;

import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.io.FileOutputStream;
/**
 *
 * @author locmi
 */
public class ExportToPDF {
    public void exportJFrame(JFrame frame, String path) {
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate template = cb.createTemplate(frame.getWidth(), frame.getHeight());
            Graphics2D g2 = template.createGraphics(frame.getWidth(), frame.getHeight());
            frame.paint(g2);
            g2.dispose();
            cb.addTemplate(template, 0, 0);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
