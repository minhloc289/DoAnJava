/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;
import DAO.HuanLuyenVienDAO;
import DAO.NhanVienDAO;
import DAO.ThongKeDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import controller.ConvertDate;
import controller.CurrencyUtils;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.DoanhThu;
import model.HuanLuyenVien;
import model.NhanVien;
import model.ThongKeTheTap;


/**
 *
 * @author locmi
 */
public class ThongKe extends javax.swing.JPanel {
    private DefaultTableModel tblModel; 
    private DefaultTableModel tblModel2;
    private DefaultTableModel tblModel3;
    private DefaultTableModel tblModel4;   
    
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
        
        initTableDSHLV();
        loadDataToTableDSHLV(HuanLuyenVienDAO.getInstance().selectAll());
        
        initTableDSNV();
        loadDataToTableDSNV(NhanVienDAO.getInstance().selectAll());
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
        lb_SLKH.setText("Khách hàng: " + tkList.size());
        
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
        double tongTien = 0;
        for (DoanhThu dt : doanhThuList) {
            tblModel2.addRow(new Object[]{
               dt.getId_TToan(), dt.getId_KH(), dt.getTenKH(), dt.getNgayTT(), CurrencyUtils.formatCurrency(dt.getTongTien()), dt.getTenNV()
            });
            tongTien += dt.getTongTien();
        }
        String formattedTongTien = CurrencyUtils.formatCurrency(tongTien);
        lb_DOANHTHU.setText("Tổng doanh thu: " + formattedTongTien);
        
    }
    
    public final void initTableDSHLV() {
        tblModel3 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] headerTbl = new String[]{"Mã huấn luyện viên", "Họ và tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Số điện thoại","Ngày vào làm", "Chuyên môn", "Email", "Giá thuê"};
        tblModel3.setColumnIdentifiers(headerTbl);
        tb_HLV.setModel(tblModel3);
    }
    
    public void loadDataToTableDSHLV(ArrayList<HuanLuyenVien> hlvList) {
        tblModel3.setRowCount(0); 
        for (HuanLuyenVien hlv : hlvList) {
            tblModel3.addRow(new Object[]{
                hlv.getId_HLV(), hlv.getHoTen(), hlv.getNgaySinh(), hlv.getGioiTinh(), hlv.getDiaChi(), hlv.getSoDT(), hlv.getNgayVL(), hlv.getChuyenMon(), hlv.getEmail(), CurrencyUtils.formatCurrency(hlv.getGiaThue())
            });
        }
        lb_HLV.setText("Huấn luyện viên: " + hlvList.size());
    }
    
    public final void initTableDSNV() {
        tblModel4 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] headerTbl = new String[]{"Mã nhân viên", "Họ và tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Số điện thoại","Ngày vào làm","Chức vụ", "Email"};
        tblModel4.setColumnIdentifiers(headerTbl);
        tb_NV.setModel(tblModel4);
    }
    
    public void loadDataToTableDSNV(ArrayList<NhanVien> nvList) {
        tblModel4.setRowCount(0); 
        for (NhanVien nv : nvList) {
            tblModel4.addRow(new Object[]{
                nv.getId_NV(), nv.getHoTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getDiaChi(), nv.getSoDT(), nv.getNgayVL(), nv.getChucVu(), nv.getEmail()
            });
        }
        lb_NV.setText("Nhân viên: " + nvList.size());
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
    
    public void timHuanLuyenVien() throws ParseException {
        ArrayList<HuanLuyenVien> hlvList = new ArrayList<>();
        if (jDateChooserFromHLV.getDate() != null || jDateChooserToHLV.getDate() != null) {
            Date from = null;
            Date to = null;
            if (jDateChooserFromHLV.getDate() != null && jDateChooserToHLV.getDate() == null) {
                from = new Date(jDateChooserFromHLV.getDate().getTime());
                to = new Date(System.currentTimeMillis());
            } else if (jDateChooserToHLV.getDate() != null && jDateChooserFromHLV.getDate() == null) {
                String Date1 = "01/01/2024"; // Đây là ngày mặc định
                from = ConvertDate.getInstance().convertStringToDate(Date1);
                to = new Date(jDateChooserToHLV.getDate().getTime());
            } else {
                from = new Date(jDateChooserFromHLV.getDate().getTime());
                to = new Date(jDateChooserToHLV.getDate().getTime());
                if (from.getTime() > to.getTime()) {
                    JOptionPane.showMessageDialog(this, "Thời gian không hợp lệ !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    jDateChooserFromHLV.setCalendar(null);
                    jDateChooserToHLV.setCalendar(null);
                    return; 
                }
            }
            hlvList = HuanLuyenVienDAO.getInstance().selectAll(from, to);
        } else {
            hlvList = HuanLuyenVienDAO.getInstance().selectAll();
        }
        loadDataToTableDSHLV(hlvList);
    }
    
    public void timNhanVien() throws ParseException {
        ArrayList<NhanVien> nvList = new ArrayList<>();
        if (jDateChooserFromNV.getDate() != null || jDateChooserToNV.getDate() != null) {
            Date from = null;
            Date to = null;
            if (jDateChooserFromNV.getDate() != null && jDateChooserToNV.getDate() == null) {
                from = new Date(jDateChooserFromNV.getDate().getTime());
                to = new Date(System.currentTimeMillis());
            } else if (jDateChooserToNV.getDate() != null && jDateChooserFromNV.getDate() == null) {
                String Date1 = "01/01/2024"; // Đây là ngày mặc định
                from = ConvertDate.getInstance().convertStringToDate(Date1);
                to = new Date(jDateChooserToNV.getDate().getTime());
            } else {
                from = new Date(jDateChooserFromNV.getDate().getTime());
                to = new Date(jDateChooserToNV.getDate().getTime());
                if (from.getTime() > to.getTime()) {
                    JOptionPane.showMessageDialog(this, "Thời gian không hợp lệ !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    jDateChooserFromNV.setCalendar(null);
                    jDateChooserToNV.setCalendar(null);
                    return; 
                }
            }
            nvList = NhanVienDAO.getInstance().selectAll(from, to);
        } else {
            nvList = NhanVienDAO.getInstance().selectAll();
        }
        loadDataToTableDSNV(nvList);
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
        tf_TIMKIEMTHETAP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jDateChooserFromTT = new com.toedter.calendar.JDateChooser();
        jDateChooserToTT = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jb_RESET = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_THONGKETHETAP = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        lb_SLKH = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        tf_TIMKIEMDOANHTHU = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooserFromTToan = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jDateChooserToTToan = new com.toedter.calendar.JDateChooser();
        jb_RESET1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_THONGKETHANHTOAN = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        lb_DOANHTHU = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        tf_TIMKIEMHLV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooserFromHLV = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jDateChooserToHLV = new com.toedter.calendar.JDateChooser();
        jb_RESET2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_HLV = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        lb_HLV = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        tf_TIMKIEMNV = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jDateChooserFromNV = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jDateChooserToNV = new com.toedter.calendar.JDateChooser();
        jb_RESET3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_NV = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        lb_NV = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

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

        tf_TIMKIEMTHETAP.setText("Tìm kiếm...");
        tf_TIMKIEMTHETAP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_TIMKIEMTHETAPFocusGained(evt);
            }
        });
        tf_TIMKIEMTHETAP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_TIMKIEMTHETAPKeyReleased(evt);
            }
        });

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
                .addComponent(tf_TIMKIEMTHETAP, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(tf_TIMKIEMTHETAP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel7.setBackground(new java.awt.Color(255, 102, 102));

        lb_SLKH.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        lb_SLKH.setForeground(new java.awt.Color(255, 255, 255));
        lb_SLKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/rating (1).png"))); // NOI18N
        lb_SLKH.setText("Số lượng khách hàng: ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_SLKH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_SLKH, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Thẻ tập", jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tf_TIMKIEMDOANHTHU.setText("Tìm kiếm...");
        tf_TIMKIEMDOANHTHU.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_TIMKIEMDOANHTHUFocusGained(evt);
            }
        });
        tf_TIMKIEMDOANHTHU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_TIMKIEMDOANHTHUKeyReleased(evt);
            }
        });

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
                .addComponent(tf_TIMKIEMDOANHTHU, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(tf_TIMKIEMDOANHTHU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel8.setBackground(new java.awt.Color(255, 102, 102));

        lb_DOANHTHU.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        lb_DOANHTHU.setForeground(new java.awt.Color(255, 255, 255));
        lb_DOANHTHU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/financial-statement (1).png"))); // NOI18N
        lb_DOANHTHU.setText("Doanh thu: ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_DOANHTHU)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_DOANHTHU, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Doanh thu", jPanel5);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        tf_TIMKIEMHLV.setText("Tìm kiếm...");
        tf_TIMKIEMHLV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_TIMKIEMHLVFocusGained(evt);
            }
        });
        tf_TIMKIEMHLV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_TIMKIEMHLVKeyReleased(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Search.png"))); // NOI18N

        jLabel8.setText("Từ");

        jDateChooserFromHLV.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserFromHLV.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserFromHLVPropertyChange(evt);
            }
        });
        jDateChooserFromHLV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserFromHLVKeyReleased(evt);
            }
        });

        jLabel9.setText("Đến");

        jDateChooserToHLV.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserToHLV.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserToHLVPropertyChange(evt);
            }
        });
        jDateChooserToHLV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserToHLVKeyReleased(evt);
            }
        });

        jb_RESET2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Update.png"))); // NOI18N
        jb_RESET2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_RESET2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_TIMKIEMHLV, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(41, 41, 41)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooserFromHLV, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserToHLV, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_RESET2)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_TIMKIEMHLV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(jDateChooserFromHLV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateChooserToHLV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jb_RESET2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );

        tb_HLV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tb_HLV);

        jPanel11.setBackground(new java.awt.Color(255, 102, 102));

        lb_HLV.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        lb_HLV.setForeground(new java.awt.Color(255, 255, 255));
        lb_HLV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/trainer (1) (1).png"))); // NOI18N
        lb_HLV.setText("Huấn luyện viên: ");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_HLV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_HLV, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Huấn luyện viên", jPanel9);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        tf_TIMKIEMNV.setText("Tìm kiếm...");
        tf_TIMKIEMNV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_TIMKIEMNVFocusGained(evt);
            }
        });
        tf_TIMKIEMNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_TIMKIEMNVKeyReleased(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Search.png"))); // NOI18N

        jLabel11.setText("Từ");

        jDateChooserFromNV.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserFromNV.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserFromNVPropertyChange(evt);
            }
        });
        jDateChooserFromNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserFromNVKeyReleased(evt);
            }
        });

        jLabel12.setText("Đến");

        jDateChooserToNV.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserToNV.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserToNVPropertyChange(evt);
            }
        });
        jDateChooserToNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserToNVKeyReleased(evt);
            }
        });

        jb_RESET3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/ic_Update.png"))); // NOI18N
        jb_RESET3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_RESET3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_TIMKIEMNV, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(41, 41, 41)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooserFromNV, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserToNV, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_RESET3)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_TIMKIEMNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(jDateChooserFromNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateChooserToNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jb_RESET3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );

        tb_NV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tb_NV);

        jPanel14.setBackground(new java.awt.Color(255, 102, 102));
        jPanel14.setFocusCycleRoot(true);

        lb_NV.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        lb_NV.setForeground(new java.awt.Color(255, 255, 255));
        lb_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/staff (1).png"))); // NOI18N
        lb_NV.setText("Nhân viên: ");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_NV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Nhân viên", jPanel12);

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

    private void jDateChooserFromHLVPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserFromHLVPropertyChange
        try {
            // TODO add your handling code here:
            timHuanLuyenVien();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooserFromHLVPropertyChange

    private void jDateChooserFromHLVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFromHLVKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserFromHLVKeyReleased

    private void jDateChooserToHLVPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserToHLVPropertyChange
        try {
            // TODO add your handling code here:
            timHuanLuyenVien();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooserToHLVPropertyChange

    private void jDateChooserToHLVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserToHLVKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserToHLVKeyReleased

    private void jb_RESET2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_RESET2MouseClicked
        jDateChooserFromHLV.setCalendar(null);
        jDateChooserToHLV.setCalendar(null);
        loadDataToTableDSHLV(HuanLuyenVienDAO.getInstance().selectAll());
    }//GEN-LAST:event_jb_RESET2MouseClicked

    private void tf_TIMKIEMTHETAPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_TIMKIEMTHETAPKeyReleased
        String searchText = tf_TIMKIEMTHETAP.getText().trim().toLowerCase();
     
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tb_THONGKETHETAP.getModel());
        tb_THONGKETHETAP.setRowSorter(sorter);
        
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText); 
        sorter.setRowFilter(rowFilter);
    }//GEN-LAST:event_tf_TIMKIEMTHETAPKeyReleased

    private void tf_TIMKIEMDOANHTHUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_TIMKIEMDOANHTHUKeyReleased
        String searchText = tf_TIMKIEMDOANHTHU.getText().trim().toLowerCase();
     
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tb_THONGKETHANHTOAN.getModel());
        tb_THONGKETHANHTOAN.setRowSorter(sorter);
        
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText); 
        sorter.setRowFilter(rowFilter);
    }//GEN-LAST:event_tf_TIMKIEMDOANHTHUKeyReleased

    private void tf_TIMKIEMHLVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_TIMKIEMHLVKeyReleased
        String searchText = tf_TIMKIEMHLV.getText().trim().toLowerCase();
     
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tb_HLV.getModel());
        tb_HLV.setRowSorter(sorter);
        
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText); 
        sorter.setRowFilter(rowFilter);
    }//GEN-LAST:event_tf_TIMKIEMHLVKeyReleased

    private void tf_TIMKIEMNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_TIMKIEMNVKeyReleased
        String searchText = tf_TIMKIEMNV.getText().trim().toLowerCase();
     
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tb_NV.getModel());
        tb_NV.setRowSorter(sorter);
        
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText); 
        sorter.setRowFilter(rowFilter);
    }//GEN-LAST:event_tf_TIMKIEMNVKeyReleased

    private void jDateChooserFromNVPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserFromNVPropertyChange
        try {
            // TODO add your handling code here:
            timNhanVien();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooserFromNVPropertyChange

    private void jDateChooserFromNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFromNVKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserFromNVKeyReleased

    private void jDateChooserToNVPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserToNVPropertyChange
        try {
            // TODO add your handling code here:
            timNhanVien();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooserToNVPropertyChange

    private void jDateChooserToNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserToNVKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserToNVKeyReleased

    private void jb_RESET3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_RESET3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_RESET3MouseClicked

    private void tf_TIMKIEMTHETAPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_TIMKIEMTHETAPFocusGained
        if(tf_TIMKIEMTHETAP.getText().equals("Tìm kiếm ..."))
            tf_TIMKIEMTHETAP.setText("");
    }//GEN-LAST:event_tf_TIMKIEMTHETAPFocusGained

    private void tf_TIMKIEMDOANHTHUFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_TIMKIEMDOANHTHUFocusGained
        if(tf_TIMKIEMDOANHTHU.getText().equals("Tìm kiếm ..."))
            tf_TIMKIEMDOANHTHU.setText("");
    }//GEN-LAST:event_tf_TIMKIEMDOANHTHUFocusGained

    private void tf_TIMKIEMHLVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_TIMKIEMHLVFocusGained
        if(tf_TIMKIEMHLV.getText().equals("Tìm kiếm ..."))
            tf_TIMKIEMHLV.setText("");
    }//GEN-LAST:event_tf_TIMKIEMHLVFocusGained

    private void tf_TIMKIEMNVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_TIMKIEMNVFocusGained
        if(tf_TIMKIEMNV.getText().equals("Tìm kiếm ..."))
            tf_TIMKIEMNV.setText("");
    }//GEN-LAST:event_tf_TIMKIEMNVFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooserFromHLV;
    private com.toedter.calendar.JDateChooser jDateChooserFromNV;
    private com.toedter.calendar.JDateChooser jDateChooserFromTT;
    private com.toedter.calendar.JDateChooser jDateChooserFromTToan;
    private com.toedter.calendar.JDateChooser jDateChooserToHLV;
    private com.toedter.calendar.JDateChooser jDateChooserToNV;
    private com.toedter.calendar.JDateChooser jDateChooserToTT;
    private com.toedter.calendar.JDateChooser jDateChooserToTToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jb_RESET;
    private javax.swing.JLabel jb_RESET1;
    private javax.swing.JLabel jb_RESET2;
    private javax.swing.JLabel jb_RESET3;
    private javax.swing.JLabel lb_DOANHTHU;
    private javax.swing.JLabel lb_HLV;
    private javax.swing.JLabel lb_NV;
    private javax.swing.JLabel lb_SLKH;
    private javax.swing.JLabel lb_Title;
    private javax.swing.JTable tb_HLV;
    private javax.swing.JTable tb_NV;
    private javax.swing.JTable tb_THONGKETHANHTOAN;
    private javax.swing.JTable tb_THONGKETHETAP;
    private javax.swing.JTextField tf_TIMKIEMDOANHTHU;
    private javax.swing.JTextField tf_TIMKIEMHLV;
    private javax.swing.JTextField tf_TIMKIEMNV;
    private javax.swing.JTextField tf_TIMKIEMTHETAP;
    // End of variables declaration//GEN-END:variables
}
