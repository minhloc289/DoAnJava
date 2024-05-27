/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.KhachHangDAO;
import com.formdev.flatlaf.FlatIntelliJLaf;
import controller.ConvertDate;
import java.sql.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.KhachHang;

/**
 *
 * @author locmi
 */
public class addKhachHang extends javax.swing.JFrame {
    private KhachHangForm panel;
    /**
     * Creates new form addKhachHang
     */
    public addKhachHang(KhachHangForm panel) {
        this.panel = panel;
        initComponents();
        setSize(390, 579);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bt_AddKHACHHANG = new javax.swing.JButton();
        bt_Huy = new javax.swing.JButton();
        lb_MAKH = new javax.swing.JLabel();
        tf_MAKH = new javax.swing.JTextField();
        lb_MAKH1 = new javax.swing.JLabel();
        tf_HOTEN = new javax.swing.JTextField();
        lb_MAKH2 = new javax.swing.JLabel();
        tf_NGAYSINH = new javax.swing.JTextField();
        lb_MAKH3 = new javax.swing.JLabel();
        cb_GIOITINH = new javax.swing.JComboBox<>();
        lb_MAKH4 = new javax.swing.JLabel();
        tf_DIACHI = new javax.swing.JTextField();
        lb_MAKH5 = new javax.swing.JLabel();
        tf_SDT = new javax.swing.JTextField();
        lb_MAKH6 = new javax.swing.JLabel();
        tf_EMAIL = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 239, 237));

        bt_AddKHACHHANG.setBackground(new java.awt.Color(251, 129, 54));
        bt_AddKHACHHANG.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        bt_AddKHACHHANG.setForeground(new java.awt.Color(255, 255, 255));
        bt_AddKHACHHANG.setText("Thêm");
        bt_AddKHACHHANG.setPreferredSize(new java.awt.Dimension(64, 22));
        bt_AddKHACHHANG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_AddKHACHHANGMouseClicked(evt);
            }
        });

        bt_Huy.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        bt_Huy.setForeground(new java.awt.Color(251, 129, 54));
        bt_Huy.setText("Hủy");
        bt_Huy.setPreferredSize(new java.awt.Dimension(64, 22));
        bt_Huy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_HuyMouseClicked(evt);
            }
        });
        bt_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_HuyActionPerformed(evt);
            }
        });

        lb_MAKH.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        lb_MAKH.setText("Mã khách hàng");

        lb_MAKH1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        lb_MAKH1.setText("Họ và tên");

        lb_MAKH2.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        lb_MAKH2.setText("Ngày sinh");

        lb_MAKH3.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        lb_MAKH3.setText("Giới tính");

        cb_GIOITINH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        lb_MAKH4.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        lb_MAKH4.setText("Địa chỉ");

        lb_MAKH5.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        lb_MAKH5.setText("Số điện thoại");

        lb_MAKH6.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        lb_MAKH6.setText("Email");

        jPanel3.setBackground(new java.awt.Color(251, 129, 54));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM MỚI KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_MAKH2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(bt_AddKHACHHANG, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                            .addComponent(bt_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lb_MAKH3)
                                    .addComponent(lb_MAKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_MAKH1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(lb_MAKH4)
                                .addComponent(lb_MAKH5)
                                .addComponent(lb_MAKH6))
                            .addGap(32, 32, 32)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tf_SDT, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tf_DIACHI, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cb_GIOITINH, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                                .addComponent(tf_HOTEN, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tf_MAKH, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tf_NGAYSINH, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tf_EMAIL)))))
                .addContainerGap(29, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_MAKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_MAKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_HOTEN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_MAKH1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_MAKH2)
                    .addComponent(tf_NGAYSINH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_GIOITINH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_MAKH3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_MAKH4)
                    .addComponent(tf_DIACHI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_MAKH5)
                    .addComponent(tf_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_MAKH6))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_AddKHACHHANG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_HuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_bt_HuyActionPerformed

    private void bt_HuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_HuyMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_HuyMouseClicked

    private void bt_AddKHACHHANGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_AddKHACHHANGMouseClicked
        // Lấy dữ liệu từ các trường nhập liệu
        String id_KH = tf_MAKH.getText();
        String hoTen = tf_HOTEN.getText();
        String ngaySinhStr = tf_NGAYSINH.getText();
        String gioiTinh = cb_GIOITINH.getSelectedItem().toString();
        String diaChi = tf_DIACHI.getText();
        String soDT = tf_SDT.getText();
        String email = tf_EMAIL.getText();

        // Kiểm tra các trường không được để trống
        if (id_KH.isEmpty() || hoTen.isEmpty() || ngaySinhStr.isEmpty() || gioiTinh.isEmpty() || diaChi.isEmpty() || soDT.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống thông tin", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Chuyển đổi ngày sinh
        Date ngaySinh = null;
        try {
            ngaySinh = ConvertDate.convertStringToDate(ngaySinhStr);
        } catch (ParseException ex) {
            Logger.getLogger(TestKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return; // Dừng lại nếu ngày sinh không hợp lệ
        }

        // Kiểm tra nếu khách hàng đã tồn tại theo Id_KH
        if (KhachHangDAO.getInstance().selectById(id_KH) != null) {
            JOptionPane.showMessageDialog(this, "Khách hàng đã tồn tại", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Kiểm tra định dạng email
        if (!isValid(email)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Email đúng định dạng!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Tạo đối tượng KhachHang
        KhachHang kh = new KhachHang(id_KH, hoTen, ngaySinh, gioiTinh, diaChi, soDT, email);

        try {
            // Gọi phương thức insert để thêm khách hàng
            KhachHangDAO.getInstance().insert(kh);
            panel.loadDataToTable(KhachHangDAO.getInstance().selectAll());
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!");
            this.dispose();
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            if (e.getMessage().contains("Email đã tồn tại!")) {
                JOptionPane.showMessageDialog(this, "Email đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bt_AddKHACHHANGMouseClicked
    
    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KhachHangForm panel = new KhachHangForm();
                new addKhachHang(panel).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_AddKHACHHANG;
    private javax.swing.JButton bt_Huy;
    private javax.swing.JComboBox<String> cb_GIOITINH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lb_MAKH;
    private javax.swing.JLabel lb_MAKH1;
    private javax.swing.JLabel lb_MAKH2;
    private javax.swing.JLabel lb_MAKH3;
    private javax.swing.JLabel lb_MAKH4;
    private javax.swing.JLabel lb_MAKH5;
    private javax.swing.JLabel lb_MAKH6;
    private javax.swing.JTextField tf_DIACHI;
    private javax.swing.JTextField tf_EMAIL;
    private javax.swing.JTextField tf_HOTEN;
    private javax.swing.JTextField tf_MAKH;
    private javax.swing.JTextField tf_NGAYSINH;
    private javax.swing.JTextField tf_SDT;
    // End of variables declaration//GEN-END:variables
}
