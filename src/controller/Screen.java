/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import List.ListDM;
import view.GoiTap;
import view.Home;
import view.HuanLuyenVien;
import view.KhachHang;
import view.NhanVien;
import view.TaiKhoan;
import view.ThanhToan;
import view.TheTap;
import view.ThietBi;
import view.ThongKe;
import view.Thue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 *
 * @author locmi
 */

public class Screen {
    private JPanel root;
    private String kindSelected = "";
    private List<ListDM> listItem = null;

    public Screen(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jblItem){
        kindSelected="Home";
        jpnItem.setBackground(Color.white);
        jblItem.setBackground(Color.white);
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new Home());
        root.validate();
        root.repaint();
    }

    
    public void setEvent(List<ListDM> listItem){
            this.listItem=listItem;
        for(ListDM item: listItem){
            item.getJlb().addMouseListener(new LableEnvent(item.getKind(),item.getJpn(),item.getJlb()));
        }
    }


    class LableEnvent implements MouseListener{
        private JPanel node;
        
        private  String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LableEnvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }


        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind) {
                case "Home":
                    node = new Home();
                    break;
                case "KhachHang":
                    node = new KhachHang();
                    break;
                case "GoiTap":
                    node = new GoiTap();
                    break;
                case "HuanLuyenVien":
                    node = new HuanLuyenVien();
                    break;
                case "TheTap":
                    node = new TheTap();
                    break;
                case "Thue":
                    node = new Thue();
                    break;
                case "ThietBi":
                    node = new ThietBi();
                    break;
                case "ThanhToan":
                    node = new ThanhToan();
                    break;
                case "ThongKe":
                    node = new ThongKe();
                    break;
                case "NhanVien":
                    node = new NhanVien();
                    break;
                case "TaiKhoan":
                    node = new TaiKhoan();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }
        

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(243, 197, 192));
            jlbItem.setBackground(new Color(243, 197, 192));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // Not supported yet
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(Color.white);
            jlbItem.setBackground(Color.white);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(243, 197, 192));
                jlbItem.setBackground(new Color(243, 197, 192));
            }
        }
    }

    private void setChangeBackground(String kind) {
        for (ListDM item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(0, 204, 204));
                item.getJlb().setBackground(new Color(0, 204, 204));
            } else {
                item.getJpn().setBackground(new Color(243, 197, 192));
                item.getJlb().setBackground(new Color(243, 197, 192));
            }
        }
    }
}

