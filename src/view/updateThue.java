/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.ThueDAO;
import javax.swing.JOptionPane;
import model.Thue;

/**
 *
 * @author locmi
 */
public class updateThue extends javax.swing.JFrame {
    private ThueForm panel;
    private Thue thue;
    /**
     * Creates new form updateThue
     */
    public updateThue(ThueForm panel, Thue thue) {
        initComponents();
        setLocationRelativeTo(null);
        this.panel = panel;
        this.thue = thue;
        tf_MAKH.setEditable(false);
        loadData();
    }
    
    private void loadData() {
        tf_MAKH.setText(thue.getId_KH());
        tf_MAHLV.setText(thue.getId_HLV());
        tf_TGIANTHUE.setText(String.valueOf(thue.getThoiGianThue()));
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
        jLabel1 = new javax.swing.JLabel();
        lb_MATB = new javax.swing.JLabel();
        tf_MAKH = new javax.swing.JTextField();
        lb_MATB1 = new javax.swing.JLabel();
        tf_MAHLV = new javax.swing.JTextField();
        lb_MATB2 = new javax.swing.JLabel();
        tf_TGIANTHUE = new javax.swing.JTextField();
        bt_Them = new javax.swing.JButton();
        bt_Huy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 239, 237));

        jPanel2.setBackground(new java.awt.Color(251, 129, 54));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cập nhật thuê huấn luyện viên");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        lb_MATB.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        lb_MATB.setText("Mã khách hàng");

        tf_MAKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_MAKHActionPerformed(evt);
            }
        });

        lb_MATB1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        lb_MATB1.setText("Mã huấn luyện viên");

        tf_MAHLV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_MAHLVActionPerformed(evt);
            }
        });

        lb_MATB2.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        lb_MATB2.setText("Thời gian thuê");

        tf_TGIANTHUE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_TGIANTHUEActionPerformed(evt);
            }
        });

        bt_Them.setBackground(new java.awt.Color(251, 129, 54));
        bt_Them.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        bt_Them.setForeground(new java.awt.Color(255, 255, 255));
        bt_Them.setText("Cập nhật");
        bt_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ThemActionPerformed(evt);
            }
        });

        bt_Huy.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        bt_Huy.setForeground(new java.awt.Color(251, 129, 54));
        bt_Huy.setText("Hủy");
        bt_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_HuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(bt_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_MATB2)
                        .addComponent(lb_MATB1)
                        .addComponent(tf_MAHLV, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_MATB)
                        .addComponent(tf_MAKH, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_TGIANTHUE, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(45, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(119, 119, 119)
                    .addComponent(lb_MATB)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(tf_MAKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lb_MATB1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(tf_MAHLV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lb_MATB2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(tf_TGIANTHUE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(119, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_MAKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_MAKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_MAKHActionPerformed

    private void tf_MAHLVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_MAHLVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_MAHLVActionPerformed

    private void tf_TGIANTHUEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_TGIANTHUEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_TGIANTHUEActionPerformed

    private void bt_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ThemActionPerformed
        String id_KH = tf_MAKH.getText();
        String id_HLV = tf_MAHLV.getText();
        int thoiGianThue;
        try {
            thoiGianThue = Integer.parseInt(tf_TGIANTHUE.getText());
            if (thoiGianThue <= 0) {
                JOptionPane.showMessageDialog(this, "Thời gian thuê phải là số nguyên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là một số nguyên dương", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (id_HLV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }

        Thue thue = new Thue(id_KH, id_HLV, null, null, thoiGianThue, 0);
        try {
            ThueDAO.getInstance().update(thue);
            panel.loadDataToTable(ThueDAO.getInstance().selectAll());
            JOptionPane.showMessageDialog(this, "Cập nhật thuê huấn luyện viên thành công!");
            this.dispose();
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            if (errorMessage.contains("Khách hàng đã thuê huấn luyện viên này.")) {
                JOptionPane.showMessageDialog(this, "Khách hàng đã thuê huấn luyện viên này!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else if (errorMessage.contains("Thời gian thuê huấn luyện viên không được lớn hơn thời gian gói tập.")) {
                JOptionPane.showMessageDialog(this, "Thuê quá thời gian gói tập!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_bt_ThemActionPerformed

    private void bt_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_HuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_bt_HuyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(updateThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThueForm panel = new ThueForm();
                Thue thue = new Thue();
                new updateThue(panel, thue).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Huy;
    private javax.swing.JButton bt_Them;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_MATB;
    private javax.swing.JLabel lb_MATB1;
    private javax.swing.JLabel lb_MATB2;
    private javax.swing.JTextField tf_MAHLV;
    private javax.swing.JTextField tf_MAKH;
    private javax.swing.JTextField tf_TGIANTHUE;
    // End of variables declaration//GEN-END:variables
}
