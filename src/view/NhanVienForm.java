
package view;

import java.awt.Color;

import model.NhanVien;
import DAO.NhanVienDAO;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;




public class NhanVienForm extends javax.swing.JPanel {

    private DefaultTableModel tblModel;
    private ArrayList<NhanVien> nv;
    
    
    public NhanVienForm() {
        UIManager.put("Table.showVerticalLines", true);
        initComponents();
        setSize(860, 760);
        setBackground(new Color(255, 239, 237));
        jTable1.setDefaultEditor(Object.class, null);
        initTable();
        nv = NhanVienDAO.getInstance().selectAll();
        loadDataToTable(nv);
    }
    public final void initTable() {
        tblModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
<<<<<<< Updated upstream
        String[] headerTbl = new String[]{"Mã nhân viên", "Họ và tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Số điện thoại","Ngày vào làm","Chức vụ", "Email"};
=======
        String[] headerTbl = new String[]{"Mã khách hàng", "Họ và tên", "Ngày sinh", "Giới tính", "Địa chỉ", "SĐT","Ngày vào làm", "Chức vụ", "Email"};
>>>>>>> Stashed changes
        tblModel.setColumnIdentifiers(headerTbl);
        jTable1.setModel(tblModel);
    }

    public void loadDataToTable(ArrayList<NhanVien> nvList) {
        tblModel.setRowCount(0); 
        for (NhanVien nv : nvList) {
            tblModel.addRow(new Object[]{
                nv.getId_NV(), nv.getHoTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getDiaChi(), nv.getSoDT(), nv.getNgayVL(), nv.getChucVu(), nv.getEmail()
            });
        }
    }
    
    public void refreshTableData() {
        ArrayList<NhanVien> nvList = NhanVienDAO.getInstance().selectAll(); 
        loadDataToTable(nvList); 
    }
    private NhanVien getNhanVienSelect() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        String id_KH = jTable1.getValueAt(selectedRow, 0).toString();
        String hoTen = jTable1.getValueAt(selectedRow, 1).toString();
        Date ngaySinh = (Date) jTable1.getValueAt(selectedRow, 2);
        String gioiTinh = jTable1.getValueAt(selectedRow, 3).toString();
        String diaChi = jTable1.getValueAt(selectedRow, 4).toString();
        String soDT = jTable1.getValueAt(selectedRow, 5).toString();
        Date ngayVL = (Date) jTable1.getValueAt(selectedRow, 6);
        String chucVu = jTable1.getValueAt(selectedRow, 7).toString();
        String email = jTable1.getValueAt(selectedRow, 8).toString();

        return new NhanVien(id_KH, hoTen, ngaySinh, gioiTinh, diaChi, soDT,ngayVL, chucVu, email);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TextTimKiem = new javax.swing.JTextField();
        labelSearch = new javax.swing.JLabel();
        labelInsert = new javax.swing.JLabel();
        labelDelete = new javax.swing.JLabel();
        labelUpdate = new javax.swing.JLabel();
        labelResert = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        TextTimKiem.setText("Tìm kiếm ...");
        TextTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextTimKiemFocusGained(evt);
            }
        });
        TextTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextTimKiemKeyReleased(evt);
            }
        });

        labelSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Search.png"))); // NOI18N

        labelInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Insert.png"))); // NOI18N
        labelInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelInsertMouseClicked(evt);
            }
        });

        labelDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Delete.png"))); // NOI18N
        labelDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelDeleteMouseClicked(evt);
            }
        });

        labelUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/pencil (1) (1).png"))); // NOI18N
        labelUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelUpdateMouseClicked(evt);
            }
        });

        labelResert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Update.png"))); // NOI18N
        labelResert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelResertMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                                         Danh sách nhân viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(TextTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelSearch)
                .addGap(60, 60, 60)
                .addComponent(labelInsert)
                .addGap(70, 70, 70)
                .addComponent(labelDelete)
                .addGap(73, 73, 73)
                .addComponent(labelUpdate)
                .addGap(65, 65, 65)
                .addComponent(labelResert)
<<<<<<< Updated upstream
                .addContainerGap(198, Short.MAX_VALUE))
=======
                .addContainerGap(140, Short.MAX_VALUE))
>>>>>>> Stashed changes
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUpdate)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(labelSearch)
                        .addComponent(TextTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelInsert)
                        .addComponent(labelDelete))
                    .addComponent(labelResert))
                .addGap(18, 18, 18))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Họ và tên", "NS", "GT", "Địa chỉ", "SĐT", "Ngày VL", "Email", "Giá thuê"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(50);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TextTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextTimKiemFocusGained
        if(TextTimKiem.getText().equals("Tìm kiếm ..."))
            TextTimKiem.setText("");
    }//GEN-LAST:event_TextTimKiemFocusGained

    private void TextTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextTimKiemKeyReleased
        String searchText = TextTimKiem.getText().trim().toLowerCase();
     
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) jTable1.getModel());
        jTable1.setRowSorter(sorter);
        
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText); 
        sorter.setRowFilter(rowFilter);
    }//GEN-LAST:event_TextTimKiemKeyReleased

    private void labelInsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelInsertMouseClicked
        addEmployee add = new addEmployee(this);
        add.setVisible(true);
    }//GEN-LAST:event_labelInsertMouseClicked

    private void refreshTable() {
        ArrayList<NhanVien> nv = NhanVienDAO.getInstance().selectAll();
        loadDataToTable(nv);
    }
    
    private void labelDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelDeleteMouseClicked
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần xóa!");
        } 
        else {
<<<<<<< Updated upstream
        NhanVien select = getNhanVienSelect();
        int chk = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này?", "Xác nhận xóa nhân viên", JOptionPane.YES_NO_OPTION);
        
        if (chk == JOptionPane.YES_OPTION) {
            try {
                int res = NhanVienDAO.getInstance().delete(select);
                if (res > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công!");
                        // Tải lại danh sách nhân viên trên table
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(jTable1.getSelectedRow());
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } catch (RuntimeException e) {
                String errorMessage = e.getMessage();
                if (errorMessage.contains("Nhân viên đang có tài khoản")) {
                    JOptionPane.showMessageDialog(this, "Không thể xóa nhân viên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                }
=======
            NhanVien select = getNhanVienSelect();
            int chk = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này ?", "Xác nhận xóa tài khoản", JOptionPane.YES_NO_OPTION);
            if (chk == JOptionPane.YES_OPTION) {
                    int res = NhanVienDAO.getInstance().delete(select);
                    if (res > 0) {
                        JOptionPane.showMessageDialog(this, "Xoá nhân viên thành công!");
                        loadDataToTable(NhanVienDAO.getInstance().selectAll());
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "Xóa nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
>>>>>>> Stashed changes
            }
        }
    }
    }//GEN-LAST:event_labelDeleteMouseClicked

    private void labelResertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResertMouseClicked
        refreshTable();
    }//GEN-LAST:event_labelResertMouseClicked

    private void labelUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelUpdateMouseClicked
        NhanVien select = getNhanVienSelect();
        if (select != null) {
            updateEmployee update = new updateEmployee(select, this);
            update.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhân vi để chỉnh sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_labelUpdateMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelDelete;
    private javax.swing.JLabel labelInsert;
    private javax.swing.JLabel labelResert;
    private javax.swing.JLabel labelSearch;
    private javax.swing.JLabel labelUpdate;
    // End of variables declaration//GEN-END:variables
}
