package com.raven.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;

public class Background extends JPanel {

//    public boolean isShowPaint() {
//        return showPaint;
//    }
//
//    public void setShowPaint(boolean showPaint) {
//        this.showPaint = showPaint;
//    }
//
//    public float getAnimate() {
//        return animate;
//    }
//
//    public void setAnimate(float animate) {
//        this.animate = animate;
//        repaint();
//    }
//    // su dung hieu ung chuyen dong (ease out cubic)
//    private float easeOutQuint(float x) {
//        return (float) (1 - Math.pow(1 - x, 5));
//    }
//
//    private float easeInOutCirc(float x) {
//        double v = x < 0.5 ? (1 - Math.sqrt(1 - Math.pow(2 * x, 2))) / 2 : (Math.sqrt(1 - Math.pow(-2 * x + 2, 2)) + 1) / 2;
//        return (float) v;
//    }
//
//    private float animate;
//    private int header = 50;
//    private boolean showPaint;

    public Background() {
        setOpaque(false);
    }

    @Override
    public void paint(Graphics grphcs) {
//        if (!showPaint) {
            super.paint(grphcs);
//        }
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int height = 600;
        // 1
        g2.setColor(new Color(255, 239, 237));
        g2.fill(createShape(height, 150, 50, 70, 145));
        //2
        g2.setColor(new Color(243, 197, 192));
        g2.fill(createShape(height, 100, 70, 50, 100));
        // 3
        g2.setColor(new Color(251, 130, 54));
        g2.fill(createShape(height, 80, 50, 100, 50, 100, 50));
        //4
        g2.setColor(new Color(63, 39, 90));
        g2.fill(createShape(height, 70, 20, 60, 20, 70));
        
        
        
//        int bgHeight = (int) (getHeight() * (1f - easeInOutCirc(animate)));
//        bgHeight += header;
        //mau nen
//        g2.setColor(new Color(255, 239, 237));
//        g2.fillRect(0, bgHeight, getWidth(), getHeight());
        
        g2.dispose();
//        if (showPaint) {
            super.paint(grphcs);
//        }
    }

    private Shape createShape(int location, int startInit, int... points) {
        
        // tao khoi giao dien
        int width = getWidth();
        int height = getHeight();
        int ss = width / points.length;
        int size = location;
        GeneralPath p = new GeneralPath();
        int space = 0;
        int xs = 0;
        int ys = location - startInit;
        for (int point : points) {
            point = size - point;
            int s = space + ss / 2;
            p.append(new CubicCurve2D.Double(xs, ys, s, ys, s, point, xs + ss, point), true);
            space += ss;
            xs += ss;
            ys = point;
        }
        p.lineTo(width, ys);
        p.lineTo(width, height);
        p.lineTo(0, height);
        return p;
    }
}
