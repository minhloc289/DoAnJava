/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;
import DAO.ThongKeDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import controller.ConvertDate;
import controller.CurrencyUtils;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DoanhThu;
import model.ThongKeTheTap;


/**
 *
 * @author locmi
 */
public class ThongKe extends javax.swing.JPanel {
    private DefaultTableModel tblModel; 
    private DefaultTableModel tblModel2;
    /**
     * Creates new form ThongKe
     */
    public ThongKe() {
        initComponents();
        jDateChooserFromTT.setDateFormatString("dd/MM/yyyy");
        jDateChooserToTT.setDateFormatString("dd/MM/yyyy");
        jDateChooserFromTToan.setDateFormatString("dd/MM/yyyy");
        jDateChooserToTToan.setDateFormatString("dd/MM/yyyy");

        initTableDSKH();
        loadDataToTableDSKH(ThongKeDAO.getInstance().dsKhachHang());
        
        initTableDSTTOAN();
        loadDataToTableDSTTOAN(ThongKeDAO.getInstance().dsThanhToan());
    }
    
    public final void initTableDSKH() {
        tblModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] headerTbl = new String[]{"Mã thẻ tập", "Mã khách hàng", "Tên khách hàng", "Mã gói tập", "Tên gói tập", "Ngày bắt đầu", "Ngày kết thúc"};
        tblModel.setColumnIdentifiers(headerTbl);
        tb_THONGKETHETAP.setModel(tblModel);
    }
    
    private void loadDataToTableDSKH(ArrayList<ThongKeTheTap> tkList) {
        tblModel.setRowCount(0); 
        for (ThongKeTheTap tk : tkList) {
            tblModel.addRow(new Object[]{
               tk.getId_TTap(), tk.getId_KH(), tk.getHoTen(), tk.getId_GT(), tk.getTenGoiTap(), tk.getNgayBD(), tk.getNgayHH()
            });
        }
        lb_SLKH.setText("Số lượng khách hàng: " + tkList.size());
        
    }
    
    public final void initTableDSTTOAN() {
        tblModel2 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] headerTbl = new String[]{"Mã thanh toán", "Mã khách hàng", "Tên khách hàng", "Ngày thanh toán", "Tổng tiền", "Nhân viên thực hiện"};
        tblModel2.setColumnIdentifiers(headerTbl);
        tb_THONGKETHANHTOAN.setModel(tblModel2);
    }
    
    private void loadDataToTableDSTTOAN(ArrayList<DoanhThu> doanhThuList) {
        tblModel2.setRowCount(0); 
        for (DoanhThu dt : doanhThuList) {
            tblModel2.addRow(new Object[]{
               dt.getId_TToan(), dt.getId_KH(), dt.getTenKH(), dt.getNgayTT(), CurrencyUtils.formatCurrency(dt.getTongTien()), dt.getTenNV()
            });
        }
        
    }
    
    public void timThongTinTheTap() throws ParseException {
    ArrayList<ThongKeTheTap> tk = new ArrayList<>();
        if (jDateChooserFromTT.getDate() != null || jDateChooserToTT.getDate() != null) {
            Date from = null;
            Date to = null;
            if (jDateChooserFromTT.getDate() != null && jDateChooserToTT.getDate() == null) {
                from = new Date(jDateChooserFromTT.getDate().getTime());
                to = new Date(System.currentTimeMillis());
            } else if (jDateChooserToTT.getDate() != null && jDateChooserFromTT.getDate() == null) {
                String Date1 = "01/01/2024"; // Đây là ngày mặc định
                from = ConvertDate.getInstance().convertStringToDate(Date1);
                to = new Date(jDateChooserToTT.getDate().getTime());
            } else {
                from = new Date(jDateChooserFromTT.getDate().getTime());
                to = new Date(jDateChooserToTT.getDate().getTime());
                if (from.getTime() > to.getTime()) {
                    JOptionPane.showMessageDialog(this, "Thời gian không hợp lệ !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    jDateChooserFromTT.setCalendar(null);
                    jDateChooserToTT.setCalendar(null);
                    return; 
                }
            }
            tk = ThongKeDAO.getInstance().dsKhachHang(from, to);
        } else {
            tk = ThongKeDAO.getInstance().dsKhachHang();
        }
        loadDataToTableDSKH(tk);
    }
    
    public void timThanhToan() throws ParseException {
        ArrayList<DoanhThu> dtList = new ArrayList<>();
        if (jDateChooserFromTToan.getDate() != null || jDateChooserToTToan.getDate() != null) {
            Date from = null;
            Date to = null;
            if (jDateChooserFromTToan.getDate() != null && jDateChooserToTToan.getDate() == null) {
                from = new Date(jDateChooserFromTToan.getDate().getTime());
                to = new Date(System.currentTimeMillis());
            } else if (jDateChooserToTToan.getDate() != null && jDateChooserFromTToan.getDate() == null) {
                String Date1 = "01/01/2024"; // Đây là ngày mặc định
                from = ConvertDate.getInstance().convertStringToDate(Date1);
                to = new Date(jDateChooserToTToan.getDate().getTime());
            } else {
                from = new Date(jDateChooserFromTToan.getDate().getTime());
                to = new Date(jDateChooserToTToan.getDate().getTime());
                if (from.getTime() > to.getTime()) {
                    JOptionPane.showMessageDialog(this, "Thời gian không hợp lệ !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    jDateChooserFromTToan.setCalendar(null);
                    jDateChooserToTToan.setCalendar(null);
                    return; 
                }
            }
            dtList = ThongKeDAO.getInstance().dsThanhToan(from, to);
        } else {
            dtList = ThongKeDAO.getInstance().dsThanhToan();
        }
        loadDataToTableDSTTOAN(dtList);
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
        lb_Title = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tf_TIMKIEM = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jDateChooserFromTT = new com.toedter.calendar.JDateChooser();
        jDateChooserToTT = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jb_RESET = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_THONGKETHETAP = new javax.swing.JTable();
        lb_SLKH = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        tf_TIMKIEM1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooserFromTToan = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jDateChooserToTToan = new com.toedter.calendar.JDateChooser();
        jb_RESET1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_THONGKETHANHTOAN = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(251, 129, 54));

        lb_Title.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        lb_Title.setForeground(new java.awt.Color(255, 255, 255));
        lb_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Title.setText("THỐNG KÊ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lb_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(lb_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 46, Short.MAX_VALUE)
                    .addGap(27, 27, 27)))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tf_TIMKIEM.setText("Tìm kiếm...");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Search.png"))); // NOI18N

        jDateChooserFromTT.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserFromTT.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserFromTTPropertyChange(evt);
            }
        });
        jDateChooserFromTT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserFromTTKeyReleased(evt);
            }
        });

        jDateChooserToTT.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserToTT.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserToTTPropertyChange(evt);
            }
        });
        jDateChooserToTT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserToTTKeyReleased(evt);
            }
        });

        jLabel2.setText("Từ");

        jLabel3.setText("Đến");

        jb_RESET.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Update.png"))); // NOI18N
        jb_RESET.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_RESETMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_TIMKIEM, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooserFromTT, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserToTT, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_RESET)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_TIMKIEM, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jDateChooserFromTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateChooserToTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jb_RESET, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );

        tb_THONGKETHETAP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã thẻ tập", "Mã khách hàng", "Mã gói tập", "Tên khách hàng", "Tên gói tập", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ));
        jScrollPane1.setViewportView(tb_THONGKETHETAP);

        lb_SLKH.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        lb_SLKH.setText("Số lượng khách hàng: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lb_SLKH)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_SLKH)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thẻ tập", jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tf_TIMKIEM1.setText("Tìm kiếm...");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Search.png"))); // NOI18N

        jLabel5.setText("Từ");

        jDateChooserFromTToan.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserFromTToan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserFromTToanPropertyChange(evt);
            }
        });
        jDateChooserFromTToan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserFromTToanKeyReleased(evt);
            }
        });

        jLabel6.setText("Đến");

        jDateChooserToTToan.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserToTToan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserToTToanPropertyChange(evt);
            }
        });
        jDateChooserToTToan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserToTToanKeyReleased(evt);
            }
        });

        jb_RESET1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Update.png"))); // NOI18N
        jb_RESET1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_RESET1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_TIMKIEM1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(41, 41, 41)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooserFromTToan, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserToTToan, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_RESET1)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_TIMKIEM1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jDateChooserFromTToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateChooserToTToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jb_RESET1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );

        tb_THONGKETHANHTOAN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã thanh toán", "Mã khách hàng", "Tên khách hàng", "Ngày thanh toán", "Tổng tiền", "Nhân viên thực hiện"
            }
        ));
        jScrollPane2.setViewportView(tb_THONGKETHANHTOAN);
        if (tb_THONGKETHANHTOAN.getColumnModel().getColumnCount() > 0) {
            tb_THONGKETHANHTOAN.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Doanh thu", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooserFromTTPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserFromTTPropertyChange
        try {
            // TODO add your handling code here:
            timThongTinTheTap();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooserFromTTPropertyChange

    private void jDateChooserFromTTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFromTTKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserFromTTKeyReleased

    private void jDateChooserToTTPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserToTTPropertyChange
        try {
            // TODO add your handling code here:
            timThongTinTheTap();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooserToTTPropertyChange

    private void jDateChooserToTTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserToTTKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserToTTKeyReleased

    private void jDateChooserFromTToanPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserFromTToanPropertyChange
       try {
            // TODO add your handling code here:
            timThanhToan();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooserFromTToanPropertyChange

    private void jDateChooserFromTToanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFromTToanKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserFromTToanKeyReleased

    private void jDateChooserToTToanPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserToTToanPropertyChange
        try {
            // TODO add your handling code here:
            timThanhToan();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooserToTToanPropertyChange

    private void jDateChooserToTToanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserToTToanKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserToTToanKeyReleased

    private void jb_RESETMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_RESETMouseClicked
        jDateChooserFromTT.setCalendar(null);
        jDateChooserToTT.setCalendar(null);
        loadDataToTableDSKH(ThongKeDAO.getInstance().dsKhachHang());
    }//GEN-LAST:event_jb_RESETMouseClicked

    private void jb_RESET1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_RESET1MouseClicked
        jDateChooserFromTToan.setCalendar(null);
        jDateChooserToTToan.setCalendar(null);
        loadDataToTableDSTTOAN(ThongKeDAO.getInstance().dsThanhToan());
    }//GEN-LAST:event_jb_RESET1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooserFromTT;
    private com.toedter.calendar.JDateChooser jDateChooserFromTToan;
    private com.toedter.calendar.JDateChooser jDateChooserToTT;
    private com.toedter.calendar.JDateChooser jDateChooserToTToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jb_RESET;
    private javax.swing.JLabel jb_RESET1;
    private javax.swing.JLabel lb_SLKH;
    private javax.swing.JLabel lb_Title;
    private javax.swing.JTable tb_THONGKETHANHTOAN;
    private javax.swing.JTable tb_THONGKETHETAP;
    private javax.swing.JTextField tf_TIMKIEM;
    private javax.swing.JTextField tf_TIMKIEM1;
    // End of variables declaration//GEN-END:variables
}
