/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.NhanVienAccDAO;
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.NhanVienAcc;

/**
 *
 * @author ADMIN
 */
public class addTaiKhoan extends javax.swing.JFrame {
    private TaiKhoan panel;
    /**
     * Creates new form addTaiKhoan
     * @param panel
     */
    public addTaiKhoan(TaiKhoan panel) {
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

        jDialog1 = new javax.swing.JDialog();
        back = new javax.swing.JPanel();
        top = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_MANV = new javax.swing.JLabel();
        tf_MANV = new javax.swing.JTextField();
        lb_TENDN = new javax.swing.JLabel();
        tf_TENDN = new javax.swing.JTextField();
        lb_MATKHAU = new javax.swing.JLabel();
        tf_MATKHAU = new javax.swing.JTextField();
        bt_AddTAIKHOAN = new javax.swing.JButton();
        bt_Huy = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        back.setBackground(new java.awt.Color(243, 197, 192));

        top.setBackground(new java.awt.Color(255, 102, 102));
        top.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM MỚI TÀI KHOẢN NHÂN VIÊN");

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        lb_MANV.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        lb_MANV.setText("Mã nhân viên");

        lb_TENDN.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        lb_TENDN.setText("Tên đăng nhập");

        lb_MATKHAU.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        lb_MATKHAU.setText("Mật khẩu");

        bt_AddTAIKHOAN.setBackground(new java.awt.Color(251, 129, 54));
        bt_AddTAIKHOAN.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        bt_AddTAIKHOAN.setForeground(new java.awt.Color(255, 255, 255));
        bt_AddTAIKHOAN.setText("Thêm");
        bt_AddTAIKHOAN.setPreferredSize(new java.awt.Dimension(64, 22));
        bt_AddTAIKHOAN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_AddTAIKHOANMouseClicked(evt);
            }
        });

        bt_Huy.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        bt_Huy.setForeground(new java.awt.Color(251, 129, 54));
        bt_Huy.setText("Hủy");
        bt_Huy.setPreferredSize(new java.awt.Dimension(64, 22));
        bt_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_HuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backLayout = new javax.swing.GroupLayout(back);
        back.setLayout(backLayout);
        backLayout.setHorizontalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_MATKHAU)
                    .addComponent(lb_TENDN)
                    .addComponent(lb_MANV)
                    .addComponent(tf_MANV)
                    .addComponent(tf_TENDN)
                    .addComponent(tf_MATKHAU, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backLayout.createSequentialGroup()
                        .addComponent(bt_AddTAIKHOAN, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        backLayout.setVerticalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backLayout.createSequentialGroup()
                .addComponent(top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(lb_MANV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_MANV, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_TENDN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_TENDN, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_MATKHAU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_MATKHAU, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_AddTAIKHOAN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_HuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_bt_HuyActionPerformed

    private void bt_AddTAIKHOANMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_AddTAIKHOANMouseClicked
        String id_nv = tf_MANV.getText();
        String tenDN = tf_TENDN.getText();
        String matKhau = tf_MATKHAU.getText();
        if (id_nv.isEmpty() || tenDN.isEmpty() || matKhau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        } 
        if (NhanVienAccDAO.getInstance().selectById(id_nv) == null) {
            try {
            NhanVienAcc newAcc = new NhanVienAcc(id_nv, tenDN, matKhau, "Hoạt động");
            NhanVienAccDAO.getInstance().insert(newAcc);
            panel.loadDataToTable(NhanVienAccDAO.getInstance().selectAll());
            JOptionPane.showMessageDialog(this, "Thêm tài khoản thành công!");
            this.dispose();
            } catch (RuntimeException e) {
                String errorMessage = e.getMessage();
                if (errorMessage.contains("Nhân viên không tồn tại")) {
                    JOptionPane.showMessageDialog(this, "Nhân viên không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else if (errorMessage.contains("Tên đăng nhập đã tồn tại")) {
                    JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else {
           JOptionPane.showMessageDialog(this, "Nhân viên đã có tài khoản", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bt_AddTAIKHOANMouseClicked

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
                TaiKhoan panel = new TaiKhoan();
                new addTaiKhoan(panel).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back;
    private javax.swing.JButton bt_AddTAIKHOAN;
    private javax.swing.JButton bt_Huy;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_MANV;
    private javax.swing.JLabel lb_MATKHAU;
    private javax.swing.JLabel lb_TENDN;
    private javax.swing.JTextField tf_MANV;
    private javax.swing.JTextField tf_MATKHAU;
    private javax.swing.JTextField tf_TENDN;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables
}
