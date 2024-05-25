/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import DAO.ThanhToanDAO;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.ThanhToan;

/**
 *
 * @author locmi
 */
public class ThanhToanForm extends javax.swing.JPanel {
    private DefaultTableModel tblModel;
    private ArrayList<ThanhToan> ttoan;
    /**
     * Creates new form ThanhToan
     */
    public ThanhToanForm() {
        initComponents();
        UIManager.put("Table.showVerticalLines", true);
        setSize(860, 760);
        setBackground(new Color(255, 239, 237));
        tb_THANHTOAN.setDefaultEditor(Object.class, null);
        initTable();
        ttoan = ThanhToanDAO.getInstance().selectAll();
        loadDataToTable(ttoan);
    }
    
    public final void initTable() {
        tblModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] headerTbl = new String[]{"Mã thanh toán", "Mã khách hàng", "Mã nhân viên thực hiện", "Ngày lập", "Tổng tiền", "Trạng thái"};
        tblModel.setColumnIdentifiers(headerTbl);
        tb_THANHTOAN.setModel(tblModel);
    }
    
        public void loadDataToTable(ArrayList<ThanhToan> ttoanList) {
        tblModel.setRowCount(0); 
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        for (ThanhToan ttoan : ttoanList) {
            String formattedTongTien = formatter.format(ttoan.getTongTien());
            tblModel.addRow(new Object[]{
                ttoan.getId_TTOAN(), ttoan.getId_KH(), ttoan.getId_NV(), ttoan.getNgayLap(), formattedTongTien, ttoan.getTrangThai()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        back = new javax.swing.JPanel();
        top = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_SearchBar = new javax.swing.JTextField();
        lb_icSearch = new javax.swing.JLabel();
        lb_icAdd = new javax.swing.JLabel();
        lb_icReset = new javax.swing.JLabel();
        lb_ThanhToan = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_THANHTOAN = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        top.setBackground(new java.awt.Color(251, 129, 54));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THANH TOÁN");

        tf_SearchBar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tf_SearchBar.setToolTipText("");
        tf_SearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_SearchBarActionPerformed(evt);
            }
        });
        tf_SearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_SearchBarKeyReleased(evt);
            }
        });

        lb_icSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Search.png"))); // NOI18N

        lb_icAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Insert.png"))); // NOI18N
        lb_icAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_icAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_icAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_icAddMouseExited(evt);
            }
        });

        lb_icReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Update.png"))); // NOI18N
        lb_icReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_icResetMouseClicked(evt);
            }
        });

        lb_ThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/income (1).png"))); // NOI18N

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(topLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(tf_SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_icSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_icAdd)
                        .addGap(97, 97, 97)
                        .addComponent(lb_ThanhToan)
                        .addGap(92, 92, 92)
                        .addComponent(lb_icReset)
                        .addGap(58, 58, 58))))
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lb_icSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_SearchBar)
                    .addComponent(lb_icAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_icReset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_ThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        back.add(top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, -1));

        tb_THANHTOAN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã thanh toán", "Mã khách hàng", "Mã nhân viên thực hiện", "Ngày lập", "Tổng tiền", "Trạng thái"
            }
        ));
        jScrollPane2.setViewportView(tb_THANHTOAN);

        back.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 850, 640));

        add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 750));
    }// </editor-fold>//GEN-END:initComponents

    private void tf_SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_SearchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_SearchBarActionPerformed

    private void tf_SearchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_SearchBarKeyReleased
        
    }//GEN-LAST:event_tf_SearchBarKeyReleased

    private void lb_icAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_icAddMouseClicked
        addThanhToan click = new addThanhToan(this);
        click.setVisible(true);
    }//GEN-LAST:event_lb_icAddMouseClicked

    private void lb_icAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_icAddMouseEntered

    }//GEN-LAST:event_lb_icAddMouseEntered

    private void lb_icAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_icAddMouseExited

    }//GEN-LAST:event_lb_icAddMouseExited

    private void lb_icResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_icResetMouseClicked
        
    }//GEN-LAST:event_lb_icResetMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_ThanhToan;
    private javax.swing.JLabel lb_icAdd;
    private javax.swing.JLabel lb_icReset;
    private javax.swing.JLabel lb_icSearch;
    private javax.swing.JTable tb_THANHTOAN;
    private javax.swing.JTextField tf_SearchBar;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables
}
