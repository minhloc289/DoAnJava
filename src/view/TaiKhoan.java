/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Color;
import model.NhanVienAcc;
import DAO.NhanVienAccDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author locmi
 */
public class TaiKhoan extends javax.swing.JPanel {
    private DefaultTableModel tblModel;
    private ArrayList<NhanVienAcc> acc;
    /**
     * Creates new form TaiKhoan
     */
    public TaiKhoan() {
        initComponents();
        setSize(860, 760);
        setBackground(new Color(255, 239, 237));
        UIManager.put("Table.showVerticalLines", true);
        tb_TAIKHOAN.setDefaultEditor(Object.class, null);
        initTable();
        acc = NhanVienAccDAO.getInstance().selectAll();
        loadDataToTable(acc);
    }
    
    public final void initTable() {
        tblModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] headerTbl = new String[]{"Mã nhân viên", "Tên đăng nhập", "Mật khẩu", "Trạng thái"};
        tblModel.setColumnIdentifiers(headerTbl);
        tb_TAIKHOAN.setModel(tblModel);
    }
    
    public void loadDataToTable(ArrayList<NhanVienAcc> nvAccList) {
        tblModel.setRowCount(0); 
        for (NhanVienAcc acc : nvAccList) {
            tblModel.addRow(new Object[]{
                acc.getId_NV(), acc.getTenDN(), acc.getMatKhau(), acc.getTrangThai()
            });
        }
    }
    
    private NhanVienAcc getNhanVienAccSelected() {
        int selectedRow = tb_TAIKHOAN.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        String id_NV = tb_TAIKHOAN.getValueAt(selectedRow, 0).toString();
        String tenDN = tb_TAIKHOAN.getValueAt(selectedRow, 1).toString();
        String matKhau = tb_TAIKHOAN.getValueAt(selectedRow, 2).toString();
        String trangThai = tb_TAIKHOAN.getValueAt(selectedRow, 3).toString();

        return new NhanVienAcc(id_NV, tenDN, matKhau, trangThai);
    }
    
//    private DefaultTableModel createDefaultTableModel() {
//        return new DefaultTableModel() {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
//    }
    
//    private void loadNhanVienData(DefaultTableModel model) {
//        model.addColumn("Mã nhân viên");
//        model.addColumn("Tên đăng nhập");
//        model.addColumn("Mật khẩu");
//        model.addColumn("Trạng thái");
//
//        // Lấy danh sách nhân viên từ cơ sở dữ liệu
//        acc = NhanVienAccDAO.getInstance().selectAll();
//
//        // Thêm dữ liệu từ danh sách nhân viên vào bảng
//        for (NhanVienAcc nhanVienAcc : acc) {
//            Object[] rowData = {
//                nhanVienAcc.getId_NV(),
//                nhanVienAcc.getTenDN(),
//                nhanVienAcc.getMatKhau(),
//                nhanVienAcc.getTrangThai()
//            };
//            model.addRow(rowData);
//        }
//    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JPanel();
        top = new javax.swing.JPanel();
        tf_SearchBar = new javax.swing.JTextField();
        lb_icSearch = new javax.swing.JLabel();
        lb_icAdd = new javax.swing.JLabel();
        lb_icDelete = new javax.swing.JLabel();
        lb_icReset = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lb_Update = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_TAIKHOAN = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(860, 760));

        back.setBackground(new java.awt.Color(255, 255, 255));

        top.setBackground(new java.awt.Color(251, 129, 54));
        top.setPreferredSize(new java.awt.Dimension(100, 180));

        tf_SearchBar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tf_SearchBar.setToolTipText("");
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

        lb_icDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Delete.png"))); // NOI18N
        lb_icDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_icDeleteMouseClicked(evt);
            }
        });

        lb_icReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Update.png"))); // NOI18N
        lb_icReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_icResetMouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ TÀI KHOẢN");

        lb_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/pencil (1) (1).png"))); // NOI18N
        lb_Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_UpdateMouseClicked(evt);
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
                        .addComponent(tf_SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lb_icSearch)
                        .addGap(79, 79, 79)
                        .addComponent(lb_icAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(lb_icDelete)
                        .addGap(71, 71, 71)
                        .addComponent(lb_Update)
                        .addGap(73, 73, 73)
                        .addComponent(lb_icReset)
                        .addGap(109, 109, 109))
                    .addGroup(topLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34))))
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topLayout.createSequentialGroup()
                        .addComponent(tf_SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topLayout.createSequentialGroup()
                        .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_icReset)
                            .addComponent(lb_icDelete)
                            .addComponent(lb_icSearch)
                            .addComponent(lb_icAdd)
                            .addComponent(lb_Update))
                        .addContainerGap())))
        );

        tb_TAIKHOAN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên đăng nhập", "Mật khẩu", "Trạng thái"
            }
        ));
        jScrollPane2.setViewportView(tb_TAIKHOAN);

        javax.swing.GroupLayout backLayout = new javax.swing.GroupLayout(back);
        back.setLayout(backLayout);
        backLayout.setHorizontalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
            .addGroup(backLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        backLayout.setVerticalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backLayout.createSequentialGroup()
                .addComponent(top, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lb_icAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_icAddMouseClicked
        addTaiKhoan click = new addTaiKhoan(this);
        click.setVisible(true);
    }//GEN-LAST:event_lb_icAddMouseClicked

    private void lb_icAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_icAddMouseEntered
        lb_icAdd.setBackground(Color.white);
    }//GEN-LAST:event_lb_icAddMouseEntered

    private void lb_icAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_icAddMouseExited
        lb_icAdd.setBackground(new Color(251,129,54));
    }//GEN-LAST:event_lb_icAddMouseExited

    private void lb_icResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_icResetMouseClicked
        refreshTable();
    }//GEN-LAST:event_lb_icResetMouseClicked

    private void lb_icDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_icDeleteMouseClicked
        if (tb_TAIKHOAN.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản cần xóa !");
        }
        else {
            NhanVienAcc select = getNhanVienAccSelected();
            int chk = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa tài khoản này ?", "Xác nhận xóa tài khoản", JOptionPane.YES_NO_OPTION);
            if (chk == JOptionPane.YES_OPTION) {
                int res = NhanVienAccDAO.getInstance().delete(select);
                if (res > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                    loadDataToTable(NhanVienAccDAO.getInstance().selectAll());
                }
                else {
                    JOptionPane.showMessageDialog(this, "Xóa tài khoản thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_lb_icDeleteMouseClicked

    private void lb_UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_UpdateMouseClicked
        NhanVienAcc select = getNhanVienAccSelected();
        if (select != null) {
            updateTaiKhoan update = new updateTaiKhoan(select, this);
            update.setVisible(true);
        }
        else {
           JOptionPane.showMessageDialog(this, "Vui lòng chọn một tài khoản để chỉnh sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_lb_UpdateMouseClicked

    private void tf_SearchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_SearchBarKeyReleased
        String searchText = tf_SearchBar.getText().trim().toLowerCase();
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tb_TAIKHOAN.getModel());
        tb_TAIKHOAN.setRowSorter(sorter);
        
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText); // Sử dụng biểu thức chính quy không phân biệt hoa thường
        sorter.setRowFilter(rowFilter);  
    }//GEN-LAST:event_tf_SearchBarKeyReleased
    
    public void refreshTable() {
        ArrayList<NhanVienAcc> acc = NhanVienAccDAO.getInstance().selectAll(); // Gọi hàm lấy tất cả khách hàng không bị xóa
        loadDataToTable(acc);
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_Update;
    private javax.swing.JLabel lb_icAdd;
    private javax.swing.JLabel lb_icDelete;
    private javax.swing.JLabel lb_icReset;
    private javax.swing.JLabel lb_icSearch;
    private javax.swing.JTable tb_TAIKHOAN;
    private javax.swing.JTextField tf_SearchBar;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables
}
