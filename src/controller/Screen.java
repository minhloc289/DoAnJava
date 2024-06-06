
package controller;
import List.ListDM;
import view.GoiTapForm;
import view.Home;
import view.HuanLuyenVienForm;
import view.KhachHangForm;
import view.NhanVienForm;
import view.TaiKhoan;
import view.ThanhToanForm;
import view.TheTapForm;
import view.ThietBiForm;
import view.ThongKe;
import view.ThueForm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import model.User;

/**
 *
 * @author locmi
 */

public class Screen {
    private JPanel root;
    private String kindSelected = "";
    private List<ListDM> listItem = null;
    private User currentUser;

    public Screen(JPanel jpnRoot, User currentUser) {
        this.root = jpnRoot;
        this.currentUser = currentUser;
    }

    public void setView(JPanel jpnItem, JLabel jblItem) {
        kindSelected = "Home";
        jpnItem.setBackground(Color.white);
        jblItem.setBackground(Color.white);
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new Home());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<ListDM> listItem) {
        this.listItem = listItem;
        for (ListDM item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    public boolean isAccessibleForUser(String kind) {
        if (currentUser != null && "Nhân viên".equals(currentUser.getChucVu())) {
            return !("NhanVien".equals(kind) || "TaiKhoan".equals(kind) || "ThietBi".equals(kind) ||
                    "HuanLuyenVien".equals(kind) || "ThongKe".equals(kind));
        }
        return true;
    }

    class LabelEvent implements MouseListener {
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (isAccessibleForUser(kind)) {
                switch (kind) {
                    case "Home":
                        node = new Home();
                        break;
                    case "KhachHang":
                        node = new KhachHangForm();
                        break;
                    case "GoiTap":
                        node = new GoiTapForm();
                        break;
                    case "HuanLuyenVien":
                        node = new HuanLuyenVienForm();
                        break;
                    case "TheTap":
                        node = new TheTapForm();
                        break;
                    case "Thue":
                        node = new ThueForm();
                        break;
                    case "ThietBi":
                        node = new ThietBiForm();
                        break;
                    case "ThanhToan":
                        node = new ThanhToanForm();
                        break;
                    case "ThongKe":
                        node = new ThongKe();
                        break;
                    case "NhanVien":
                        node = new NhanVienForm();
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
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(243, 197, 192));
            jlbItem.setBackground(new Color(243, 197, 192));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
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
                item.getJpn().setBackground(new Color(255, 255, 255));
                item.getJlb().setBackground(new Color(255, 255, 255));
            } else {
                item.getJpn().setBackground(new Color(243, 197, 192));
                item.getJlb().setBackground(new Color(243, 197, 192));
            }
        }
    }
}
