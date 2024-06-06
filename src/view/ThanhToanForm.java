/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import DAO.ThanhToanDAO;
import controller.CurrencyUtils;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.ThanhToan;
import java.sql.Date;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import model.ThanhToanDetail;
import view.viewThanhToan;

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
        String[] headerTbl = new String[]{"Mã thanh toán", "Mã khách hàng", "Mã nhân viên thực hiện", "Ngày lập", "Tổng tiền", "Trạng thái", "Ngày thanh toán"};
        tblModel.setColumnIdentifiers(headerTbl);
        tb_THANHTOAN.setModel(tblModel);
    }
    
    public void loadDataToTable(ArrayList<ThanhToan> ttoanList) {
        tblModel.setRowCount(0); 
        for (ThanhToan ttoan : ttoanList) {
            tblModel.addRow(new Object[]{
                ttoan.getId_TTOAN(), ttoan.getId_KH(), ttoan.getId_NV(), ttoan.getNgayLap(), 
                CurrencyUtils.formatCurrency(ttoan.getTongTien()), ttoan.getTrangThai(), ttoan.getNgayTT()
            });
        }
    }
    
    public void refreshTableData() {
        ArrayList<ThanhToan> ttoan = ThanhToanDAO.getInstance().selectAll(); 
        loadDataToTable(ttoan); 
    }
    
    
        
    private ThanhToan getThanhToanSelect() {
        int selectedRow = tb_THANHTOAN.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }

        String id_TTOAN = tb_THANHTOAN.getValueAt(selectedRow, 0).toString();
        String id_KH = tb_THANHTOAN.getValueAt(selectedRow, 1).toString();
        String id_NV = tb_THANHTOAN.getValueAt(selectedRow, 2).toString();
        Date ngayLap = (Date) tb_THANHTOAN.getValueAt(selectedRow, 3);
        String tongTienStr = tb_THANHTOAN.getValueAt(selectedRow, 4).toString();
        String trangThai = tb_THANHTOAN.getValueAt(selectedRow, 5).toString();
        Date ngayTT = (Date) tb_THANHTOAN.getValueAt(selectedRow, 6);

        double tongTien = 0;
        try {
            tongTien = CurrencyUtils.parseCurrency(tongTienStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ThanhToan(id_TTOAN, id_KH, id_NV, ngayLap, tongTien, trangThai, ngayTT);
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
        lb_SuaThanhToan = new javax.swing.JLabel();
        lb_View = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_THANHTOAN = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        top.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THANH TOÁN");

        tf_SearchBar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tf_SearchBar.setToolTipText("");
        tf_SearchBar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_SearchBarFocusGained(evt);
            }
        });
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
        lb_ThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_ThanhToanMouseClicked(evt);
            }
        });

        lb_SuaThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/pencil (1) (1).png"))); // NOI18N
        lb_SuaThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_SuaThanhToanMouseClicked(evt);
            }
        });

        lb_View.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/view (1).png"))); // NOI18N
        lb_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_ViewMouseClicked(evt);
            }
        });

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
                        .addGap(63, 63, 63)
                        .addComponent(lb_icAdd)
                        .addGap(57, 57, 57)
                        .addComponent(lb_SuaThanhToan)
                        .addGap(65, 65, 65)
                        .addComponent(lb_ThanhToan)
                        .addGap(70, 70, 70)
                        .addComponent(lb_icReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_View)
                        .addGap(61, 61, 61))))
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 16, Short.MAX_VALUE)
                        .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_icSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_SearchBar)
                            .addComponent(lb_icAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_icReset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_ThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_SuaThanhToan))
                        .addContainerGap())
                    .addGroup(topLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_View, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        back.add(top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, -1));

        tb_THANHTOAN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã thanh toán", "Mã khách hàng", "Mã nhân viên thực hiện", "Ngày lập", "Tổng tiền", "Trạng thái", "Ngày thanh toán"
            }
        ));
        jScrollPane2.setViewportView(tb_THANHTOAN);

        back.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 860, 640));

        add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 750));
    }// </editor-fold>//GEN-END:initComponents

    private void tf_SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_SearchBarActionPerformed
        String keyword = tf_SearchBar.getText().trim();
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        ThanhToan ttoan =  ThanhToanDAO.getInstance().selectById(keyword);
        tblModel.setRowCount(0); 
        
        if (ttoan != null) {
            Object[] row = {ttoan.getId_TTOAN(), ttoan.getId_KH(), ttoan.getId_NV(), ttoan.getNgayLap(), 
                CurrencyUtils.formatCurrency(ttoan.getTongTien()), ttoan.getTrangThai(), ttoan.getNgayTT()};
            tblModel.addRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }    }//GEN-LAST:event_tf_SearchBarActionPerformed

    private void tf_SearchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_SearchBarKeyReleased
//        String searchText = tf_SearchBar.getText().trim().toLowerCase();
//        
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tb_THANHTOAN.getModel());
//        tb_THANHTOAN.setRowSorter(sorter);
//        
//        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText); // Sử dụng biểu thức chính quy không phân biệt hoa thường
//        sorter.setRowFilter(rowFilter);
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
        refreshTableData();
    }//GEN-LAST:event_lb_icResetMouseClicked

    private void lb_ThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ThanhToanMouseClicked
        ThanhToan select = getThanhToanSelect();
        if (select != null) {
            int chk = JOptionPane.showConfirmDialog(this, "Xác nhận thanh toán cho khách hàng này ?", "Xác nhận thanh toán", JOptionPane.YES_NO_OPTION);
            if (chk == JOptionPane.YES_OPTION) {
                String idTTOAN = select.getId_TTOAN();
                ThanhToanDAO.getInstance().CapNhatTrangThaiThanhToan(idTTOAN);
            
                loadDataToTable(ThanhToanDAO.getInstance().selectAll());
                JOptionPane.showMessageDialog(this, "Cập nhật trạng thái thanh toán thành công!");
            }    
        }
        else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một thanh toán để cập nhật trạng thái!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_lb_ThanhToanMouseClicked

    private void lb_SuaThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_SuaThanhToanMouseClicked
        ThanhToan select = getThanhToanSelect();
        if (select != null) {
            int chk = JOptionPane.showConfirmDialog(this, "Cập nhật lại thanh toán cho khách hàng này ?", "Xác nhận thanh toán", JOptionPane.YES_NO_OPTION);
            if (chk == JOptionPane.YES_OPTION) {
                String idTTOAN = select.getId_TTOAN();
                ThanhToanDAO.getInstance().update(select);
            
                loadDataToTable(ThanhToanDAO.getInstance().selectAll());
                JOptionPane.showMessageDialog(this, "Cập nhật thanh toán thành công!");
            }    
        }
        else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một thanh toán để cập nhật!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_lb_SuaThanhToanMouseClicked

    private void lb_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ViewMouseClicked
        int selectedRow = tb_THANHTOAN.getSelectedRow();
        if (selectedRow != -1) { 
            String idTTOAN = tb_THANHTOAN.getValueAt(selectedRow, 0).toString(); 
            ThanhToanDetail detail = ThanhToanDAO.getInstance().xemThongTinThanhToan(idTTOAN); 
            if (detail != null) {
                viewThanhToan detailFrame = new viewThanhToan(detail); 
                detailFrame.setVisible(true); 
            } else {
                
                JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin thanh toán cho ID: " + idTTOAN);
            }
        } else {
            // Hiển thị thông báo nếu không có hàng nào được chọn
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng trong bảng để xem thông tin chi tiết!");
        }
    }//GEN-LAST:event_lb_ViewMouseClicked

    private void tf_SearchBarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_SearchBarFocusGained
        if(tf_SearchBar.getText().equals("Tìm kiếm ..."))
            tf_SearchBar.setText("");
    }//GEN-LAST:event_tf_SearchBarFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_SuaThanhToan;
    private javax.swing.JLabel lb_ThanhToan;
    private javax.swing.JLabel lb_View;
    private javax.swing.JLabel lb_icAdd;
    private javax.swing.JLabel lb_icReset;
    private javax.swing.JLabel lb_icSearch;
    private javax.swing.JTable tb_THANHTOAN;
    private javax.swing.JTextField tf_SearchBar;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables
}
