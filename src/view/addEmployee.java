/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.NhanVienDAO;
import com.formdev.flatlaf.FlatIntelliJLaf;
import controller.ConvertDate;
import java.sql.Date;
import java.time.LocalDate;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.NhanVien;

public class addEmployee extends javax.swing.JFrame {

    
    private NhanVienForm panel;
    public addEmployee(NhanVienForm panel) {
        this.panel = panel;
        initComponents();
        setSize(480,600);
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

        nen = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cb_gt = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        tf_ns = new javax.swing.JTextField();
        tf_dc = new javax.swing.JTextField();
        tf_ten = new javax.swing.JTextField();
        tf_sdt = new javax.swing.JTextField();
        tf_nvl = new javax.swing.JTextField();
        tf_cv = new javax.swing.JTextField();
        bt_XacNhan = new javax.swing.JButton();
        bt_Huy = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tf_email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(243, 197, 192));

        nen.setBackground(new java.awt.Color(243, 197, 192));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                THÊM MỚI NHÂN VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã nhân viên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Họ và tên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày sinh");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Giới tính");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Địa chỉ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("SĐT");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Ngày vào làm");

        cb_gt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cb_gt.setSelectedItem("Nam");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Chức vụ");

        tf_dc.setToolTipText("");

        bt_XacNhan.setBackground(new java.awt.Color(255, 102, 102));
        bt_XacNhan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_XacNhan.setForeground(new java.awt.Color(255, 255, 255));
        bt_XacNhan.setText("Xác nhận");
        bt_XacNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_XacNhanMouseClicked(evt);
            }
        });
        bt_XacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_XacNhanActionPerformed(evt);
            }
        });

        bt_Huy.setBackground(new java.awt.Color(255, 102, 102));
        bt_Huy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_Huy.setForeground(new java.awt.Color(255, 255, 255));
        bt_Huy.setText("Hủy");
        bt_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_HuyActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Email");

        javax.swing.GroupLayout nenLayout = new javax.swing.GroupLayout(nen);
        nen.setLayout(nenLayout);
        nenLayout.setHorizontalGroup(
            nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(nenLayout.createSequentialGroup()
                .addGroup(nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(nenLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_ns, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_gt, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_dc, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_nvl, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_cv, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(nenLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(bt_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        nenLayout.setVerticalGroup(
            nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nenLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(17, 17, 17)
                .addGroup(nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tf_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ns, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_gt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_dc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_nvl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(nenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_HuyActionPerformed
                this.dispose();
    }//GEN-LAST:event_bt_HuyActionPerformed

    private void bt_XacNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_XacNhanMouseClicked
        //lấy dữ liệu
        String id_NV = tf_id.getText();
        String hoTen = tf_ten.getText();
        String ngaySinhStr = tf_ns.getText();
        String gioiTinh = cb_gt.getSelectedItem().toString();
        String diaChi = tf_dc.getText();
        String soDT = tf_sdt.getText();
        String ngayVLStr = tf_nvl.getText();
        String chucVu = tf_cv.getText();
        String email = tf_email.getText();

        // Kiểm tra các trường không được để trống
        if (id_NV.isEmpty() || hoTen.isEmpty() || ngaySinhStr.isEmpty() || gioiTinh.isEmpty() || diaChi.isEmpty() || soDT.isEmpty() || ngayVLStr.isEmpty() || email.isEmpty() || chucVu.isEmpty()) {
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
        Date ngayVL = null;
        try {
            ngayVL = ConvertDate.convertStringToDate(ngayVLStr);
        } catch (ParseException ex) {
            Logger.getLogger(TestKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ngày vào làm không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return; // Dừng lại nếu ngày sinh không hợp lệ
        }

        
        if (ngaySinh.after(ngayVL)) {
            JOptionPane.showMessageDialog(this, "Ngày sinh phải nhỏ hơn ngày vào làm", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
            return;
            }        
        if (NhanVienDAO.getInstance().selectById(id_NV) != null) {
            JOptionPane.showMessageDialog(this, "Nhân viên đã tồn tại", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (NhanVienDAO.getInstance().selectByEmail(email) != null) {
            JOptionPane.showMessageDialog(this, "Email đã tồn tại", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Kiểm tra định dạng email
        if (!isValid(email)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Email đúng định dạng!", "Cảnh báo!", JOptionPane.WARNING_MESSAGE);
            return;
        }


        
        NhanVien nv = new NhanVien(id_NV, hoTen, ngaySinh, gioiTinh, diaChi, soDT,ngayVL, chucVu, email);

        try {
            
            NhanVienDAO.getInstance().insert(nv);
            panel.loadDataToTable(NhanVienDAO.getInstance().selectAll());
            JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
            this.dispose();
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            if (e.getMessage().contains("Email đã tồn tại!")) {
                JOptionPane.showMessageDialog(this, "Email đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else if (errorMessage.contains("INVALID_DOB")) {
                JOptionPane.showMessageDialog(this, "Ngày vào làm phải lớn hơn ngày sinh", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bt_XacNhanMouseClicked

    private void bt_XacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_XacNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_XacNhanActionPerformed

    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVienForm panel = new NhanVienForm();
                new addEmployee(panel).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Huy;
    private javax.swing.JButton bt_XacNhan;
    private javax.swing.JComboBox<String> cb_gt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel nen;
    private javax.swing.JTextField tf_cv;
    private javax.swing.JTextField tf_dc;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_ns;
    private javax.swing.JTextField tf_nvl;
    private javax.swing.JTextField tf_sdt;
    private javax.swing.JTextField tf_ten;
    // End of variables declaration//GEN-END:variables
}
