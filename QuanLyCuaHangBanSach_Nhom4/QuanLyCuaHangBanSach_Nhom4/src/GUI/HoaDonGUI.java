package GUI;

import BUS.ChiTietChuongTrinhGiamGiaBUS;
import BUS.ChiTietHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.SachBUS;
import BUS.ValidatorBUS;
import BUS.outBill;
import POJO.ChiTietChuongTrinhGiamGiaPOJO;
import POJO.ChiTietHoaDonPOJO;
import POJO.HoaDonPOJO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.Choice;
import java.lang.Object;
import java.security.Timestamp;
import java.util.Vector;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HoaDonGUI extends javax.swing.JPanel {
    private int DEFALUT_WIDTH;
    DefaultTableModel modelct=new DefaultTableModel();
    DefaultTableModel model=new DefaultTableModel();
    private HoaDonBUS hdBUS=new HoaDonBUS();
    private ChiTietHoaDonBUS ctBUS=new ChiTietHoaDonBUS();
    private SachBUS sachBUS=new SachBUS();
    private ValidatorBUS vlBUS=new ValidatorBUS();
    private ArrayList<HoaDonPOJO> hd=new ArrayList<>();
    private ArrayList<ChiTietHoaDonPOJO> ct=new ArrayList<>();
    public HoaDonGUI() {
        initComponents();
    }
    public HoaDonGUI(int width){
         initComponents();
         this.setSize(width - 210, 935);
         LoadDB();
         LoadDBCTF();
         Sum();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txMaKH = new javax.swing.JTextField();
        txMaNV = new javax.swing.JTextField();
        txMaGG = new javax.swing.JTextField();
        txGiamGia = new javax.swing.JTextField();
        txThanhTien = new javax.swing.JTextField();
        txTongTien = new javax.swing.JTextField();
        txNgayLap = new javax.swing.JTextField();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHD = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txTongTienHD = new javax.swing.JTextField();
        txSoLuongHD = new javax.swing.JTextField();
        btXuat = new javax.swing.JButton();
        btFHD = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txTimMAHD = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txTimMAKH = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txTimMANV = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txDau = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txCuoi = new javax.swing.JTextField();
        btTim = new javax.swing.JButton();
        txNgayMIN = new com.toedter.calendar.JDateChooser();
        txNgayMAX = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txMaHDCT = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txSoSP = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txTongTienCT = new javax.swing.JTextField();
        btCTHDF = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbChiTietHD = new javax.swing.JTable();
        btSuaCT = new javax.swing.JButton();
        btXoaCT = new javax.swing.JButton();
        txMaHD = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 0, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Mã HĐ:");
        jLabel2.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel2.setMinimumSize(new java.awt.Dimension(62, 15));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mã GG:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Mã NV:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Mã KH:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Tổng tiền:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Ngày lập:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Thành tiền:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Giảm giá:");

        btSua.setBackground(new java.awt.Color(51, 255, 255));
        btSua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btSua.setForeground(new java.awt.Color(255, 255, 255));
        btSua.setText("SỬA");
        btSua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSuaMouseClicked(evt);
            }
        });

        btXoa.setBackground(new java.awt.Color(255, 0, 0));
        btXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btXoa.setForeground(new java.awt.Color(255, 255, 255));
        btXoa.setText("XÓA");
        btXoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXoaMouseClicked(evt);
            }
        });
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        tbHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Mã KH", "Mã NV", "Mã GG", "Ngày lập", "Tổng tiền", "Giảm giá", "Thành tiền"
            }
        ));
        tbHD.setSelectionBackground(new java.awt.Color(0, 0, 255));
        tbHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHD);
        if (tbHD.getColumnModel().getColumnCount() > 0) {
            tbHD.getColumnModel().getColumn(4).setMinWidth(150);
        }

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Số lượng hóa đơn:");
        jLabel12.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel12.setMinimumSize(new java.awt.Dimension(62, 15));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Tổng tiền các hóa đơn:");
        jLabel17.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel17.setMinimumSize(new java.awt.Dimension(62, 15));

        txTongTienHD.setEditable(false);

        txSoLuongHD.setEditable(false);

        btXuat.setBackground(new java.awt.Color(153, 255, 153));
        btXuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btXuat.setForeground(new java.awt.Color(255, 255, 255));
        btXuat.setText("XUẤT");
        btXuat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXuatMouseClicked(evt);
            }
        });

        btFHD.setBackground(new java.awt.Color(255, 204, 0));
        btFHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btFHD.setForeground(new java.awt.Color(255, 255, 255));
        btFHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh_40px.png"))); // NOI18N
        btFHD.setText("LÀM MỚI");
        btFHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btFHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btFHDMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "TÌM KIẾM HÓA ĐƠN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(153, 153, 0))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Mã HĐ:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Mã KH:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Mã NV:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Thời gian từ:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("đến:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Giá tiền từ:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("đến");

        btTim.setBackground(new java.awt.Color(0, 255, 204));
        btTim.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btTim.setForeground(new java.awt.Color(255, 255, 255));
        btTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-2912.png"))); // NOI18N
        btTim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTimMouseClicked(evt);
            }
        });

        txNgayMIN.setDateFormatString("yyyy-MM-dd");

        txNgayMAX.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTimMAHD, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTimMAKH)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTimMANV, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txNgayMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txNgayMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txDau, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btTim, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(txTimMAHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21)
                                .addComponent(txTimMANV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(txTimMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(txNgayMIN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txNgayMAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(txDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)
                                .addComponent(txCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btTim)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "CHI TIẾT HÓA ĐƠN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Mã HĐ");
        jLabel18.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel18.setMinimumSize(new java.awt.Dimension(62, 15));

        txMaHDCT.setEditable(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Tổng số sản phẩm");
        jLabel22.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel22.setMinimumSize(new java.awt.Dimension(62, 15));

        txSoSP.setEditable(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Tổng tiền hóa đơn");
        jLabel23.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel23.setMinimumSize(new java.awt.Dimension(62, 15));

        txTongTienCT.setEditable(false);

        btCTHDF.setBackground(new java.awt.Color(102, 255, 102));
        btCTHDF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btCTHDF.setForeground(new java.awt.Color(255, 255, 255));
        btCTHDF.setText("TẤT CẢ CHI TIẾT HÓA ĐƠN");
        btCTHDF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btCTHDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCTHDFMouseClicked(evt);
            }
        });

        tbChiTietHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Mã sách", "Tên sách", "Đơn giá", "Số lượng", "Giảm giá", "Thành tiền"
            }
        ));
        tbChiTietHD.setSelectionBackground(new java.awt.Color(0, 204, 0));
        jScrollPane2.setViewportView(tbChiTietHD);
        if (tbChiTietHD.getColumnModel().getColumnCount() > 0) {
            tbChiTietHD.getColumnModel().getColumn(2).setMinWidth(150);
        }

        btSuaCT.setBackground(new java.awt.Color(51, 255, 255));
        btSuaCT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btSuaCT.setForeground(new java.awt.Color(255, 255, 255));
        btSuaCT.setText("SỬA");
        btSuaCT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btSuaCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSuaCTMouseClicked(evt);
            }
        });

        btXoaCT.setBackground(new java.awt.Color(255, 0, 0));
        btXoaCT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btXoaCT.setForeground(new java.awt.Color(255, 255, 255));
        btXoaCT.setText("XÓA");
        btXoaCT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btXoaCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXoaCTMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(txMaHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txSoSP, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txTongTienCT, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCTHDF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSuaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txMaHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txSoSP, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txTongTienCT, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btCTHDF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btSuaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btXoaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        txMaHD.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txSoLuongHD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txTongTienHD, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(209, 209, 209))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(56, 56, 56)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel9))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(64, 64, 64)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(btSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btFHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(79, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btFHD, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(txTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(txGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(txThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(txMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSoLuongHD, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txTongTienHD, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDMouseClicked
        Click();
        LoadDBCT();
    }//GEN-LAST:event_tbHDMouseClicked

    private void btXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXoaMouseClicked
        Xoa();
        Sum();
        LoadDBCTF();
    }//GEN-LAST:event_btXoaMouseClicked

    private void btSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSuaMouseClicked
      Sua();
      Sum();
    }//GEN-LAST:event_btSuaMouseClicked

    private void btTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTimMouseClicked
      TimKiem();
      Sum();
    }//GEN-LAST:event_btTimMouseClicked

    private void btXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXuatMouseClicked
        String MaHD=txMaHD.getText();
        String MaKH=txMaKH.getText();
        String MaNV=txMaNV.getText();
        String MaGG=txMaGG.getText();
        String NgayLap=txNgayLap.getText();
        String TongTien=txTongTien.getText();
        String GiamGia=txGiamGia.getText();
        String ThanhTien=txThanhTien.getText();
        HoaDonPOJO hd=new HoaDonPOJO(MaHD,MaKH,MaNV,MaGG,NgayLap,Float.parseFloat(TongTien),Float.parseFloat(GiamGia),Float.parseFloat(ThanhTien));
        ChiTietHoaDonBUS cthd1=new ChiTietHoaDonBUS(1);
        ArrayList<ChiTietHoaDonPOJO> ct1=cthd1.getListHD(txMaHD.getText());
        outBill outbill=new outBill(hd,ct1);
        outbill.print();
        
    }//GEN-LAST:event_btXuatMouseClicked

    private void btFHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btFHDMouseClicked
       LoadDBHDF();
    }//GEN-LAST:event_btFHDMouseClicked

    private void btCTHDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCTHDFMouseClicked
       LoadDBCTF();
    }//GEN-LAST:event_btCTHDFMouseClicked

    private void btSuaCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSuaCTMouseClicked
     int i=tbChiTietHD.getSelectedRow();
       if(i==-1){
           JOptionPane.showMessageDialog(null,"Vui lòng chọn chi tiết hóa đơn muốn sửa");
           return;
       }else{
           try{
            if(sachBUS.getListSach()==null) sachBUS.loadDSSach();
            String masach=tbChiTietHD.getModel().getValueAt(i,1).toString();
            String mahd=tbChiTietHD.getModel().getValueAt(i,0).toString();
            int sl=Integer.parseInt(JOptionPane.showInputDialog(null, "Nhập số lượng sản phẩm :"));
            while(!sachBUS.CheckSL(masach,sl)){
                  sl=Integer.parseInt(JOptionPane.showInputDialog(null, "Nhập số lượng sản phẩm :"));
            }
               String magg = null;
               for(HoaDonPOJO hd2:hd){
                   if(mahd.equals(hd2.getMaHD())){
                       if(hd2.getMaGG()==null)
                           magg="";
                       else
                           magg=hd2.getMaGG();
                   }
               }
               ChiTietChuongTrinhGiamGiaBUS gg=new ChiTietChuongTrinhGiamGiaBUS();
               if(gg.dsChiTiet==null) gg.docDSCTGG(magg);
               ArrayList<ChiTietChuongTrinhGiamGiaPOJO> ctct=new ArrayList<>();
               float giam=0;
               for(ChiTietChuongTrinhGiamGiaPOJO gg1:ctct){
                   if(masach.equals(gg1.getMaSach()))
                       giam=(float)gg1.getPercent();
               }
                              ArrayList<ChiTietHoaDonPOJO> cthd=new ArrayList<>();
               if(ctBUS.getList()==null) hdBUS.List();
               cthd=ctBUS.getList();
               float giamgia1=0;
               float thanhtien1=0;
               for(ChiTietHoaDonPOJO ct2:cthd){
                   if(mahd.equals(ct2.getMaHD()) && masach.equals(ct2.getMaSach())){
                       giamgia1=(float)sl*ct2.getDonGia()*giam/100;
                       thanhtien1=(float)sl*ct2.getDonGia()-giamgia1;
                       ct2.setGiamGia(giamgia1);
                       ct2.setSoLuong(sl);
                       ct2.setThanhTien(thanhtien1);
                       ctBUS.Sua(ct2);
                   }
               }
               
               float tongtien=0;
               float giamgia=0;
               float thanhtien=0;
               for(ChiTietHoaDonPOJO ct1:cthd){
                   if(mahd.equals(ct1.getMaHD())){
                       tongtien=tongtien+(ct1.getDonGia()*ct1.getSoLuong());
                       giamgia=giamgia+ct1.getGiamGia();
                       thanhtien=thanhtien+ct1.getThanhTien();
                   }
               }
               for(HoaDonPOJO hd1:hd){
                   if(hd1.getMaHD().equals(mahd)){
                       hd1.setTongTien(tongtien);
                       hd1.setGiamGia(giamgia);
                       hd1.setThanhTien(thanhtien);
                       if(hd1.getMaGG()==null)
                           hd1.setMaGG("");
                       int g=hdBUS.set(hd1);
                   }
               }
           outModel(model,hd);
           outModelCT(modelct,cthd);
              
            }
           catch(Exception ex){
               
            }
       }
       Sum();
       
    }//GEN-LAST:event_btSuaCTMouseClicked

    private void btXoaCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXoaCTMouseClicked
       int i=tbChiTietHD.getSelectedRow();
       if(i==-1){
           JOptionPane.showMessageDialog(null,"Vui lòng chọn chi tiết hóa đơn muốn xóa");
           return;
       }else{
           int j = JOptionPane.showConfirmDialog(null, "Xác nhận xóa","Alert",JOptionPane.YES_NO_OPTION);
           if(j==0){
               String masach=tbChiTietHD.getModel().getValueAt(i,1).toString();
               String mahd=tbChiTietHD.getModel().getValueAt(i,0).toString();
               ctBUS.XoaMS(masach,mahd);
               modelct.removeRow(i);
               float tongtien=0;
               float giamgia=0;
               float thanhtien=0;
               ArrayList<ChiTietHoaDonPOJO> cthd=new ArrayList<>();
               if(ctBUS.getList()==null) hdBUS.List();
               cthd=ctBUS.getList();
               for(ChiTietHoaDonPOJO ct1:cthd){
                   if(mahd.equals(ct1.getMaHD())){
                       tongtien=tongtien+(ct1.getDonGia()*ct1.getSoLuong());
                       giamgia=giamgia+ct1.getGiamGia();
                       thanhtien=thanhtien+ct1.getThanhTien();
                   }
               }
               for(HoaDonPOJO hd1:hd){
                   if(hd1.getMaHD().equals(mahd)){
                       hd1.setTongTien(tongtien);
                       hd1.setGiamGia(giamgia);
                       hd1.setThanhTien(thanhtien);
                       if(hd1.getMaGG()==null)
                           hd1.setMaGG("");
                       int g=hdBUS.set(hd1);
                   }
               }
               int tong=0;
               for(ChiTietHoaDonPOJO dto:cthd){
               tong=tong+(int)dto.getThanhTien();
               }
               txSoSP.setText(String.valueOf(modelct.getRowCount()));
               txTongTienCT.setText(String.valueOf(tong));
           }
              
       }
       Sum();
       
       outModel(model,hd);
    }//GEN-LAST:event_btXoaCTMouseClicked

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btXoaActionPerformed
/* **************************************Hóa đơn****************************** */
//load DB
    public void LoadDB(){
        HoaDonBUS HDBUS=new HoaDonBUS();
        Vector header=new Vector();
        header.add("Mã HĐ");
        header.add("Mã KH");
        header.add("Mã NV");
        header.add("Mã GG");
        header.add("Ngày lập");
        header.add("Tổng tiền");
        header.add("Giảm giá");
        header.add("Thành tiền");
        if(model.getRowCount()==0){
            model=new DefaultTableModel(header,0);
        }
        if(HDBUS.getList()==null) HDBUS.List();
        hd=HDBUS.getList();
        model.setRowCount(0);
        outModel(model,hd);
    }
    public void LoadDBHDF(){
        HoaDonBUS hd=new HoaDonBUS();
        Vector header=new Vector();
        header.add("Mã HĐ");
        header.add("Mã KH");
        header.add("Mã NV");
        header.add("Mã GG");
        header.add("Ngày lập");
        header.add("Tổng tiền");
        header.add("Giảm giá");
        header.add("Thành tiền");
        if(model.getRowCount()==0)
            model=new DefaultTableModel(header,0);
        if(hd.getList()==null) hd.List();
        ArrayList<HoaDonPOJO> hddto=hd.getList();
        outModel(model,hddto);
    }
    public void outModel(DefaultTableModel model , ArrayList<HoaDonPOJO> hd) // Xuất ra Table từ ArrayList
    {
        Vector row;
        model.setRowCount(0);
        for(HoaDonPOJO h:hd)
        {
            row = new Vector();
            row.add(h.getMaHD());
            row.add(h.getMaKH());
            row.add(h.getMaNV());
            String magg=h.getMaGG();
            if(h.getMaGG()==null){
                magg="";
            }
            row.add(magg);
            row.add(h.getNgayLap());
            row.add(h.getTongTien());
            row.add(h.getGiamGia());
            row.add(h.getThanhTien());
            model.addRow(row);
        }
        tbHD.setModel(model);
    }
//Click lên table
    public void Click(){
        int i=tbHD.getSelectedRow();
        txMaHD.setText(tbHD.getModel().getValueAt(i,0).toString());
        txMaKH.setText(tbHD.getModel().getValueAt(i,1).toString());
        txMaNV.setText(tbHD.getModel().getValueAt(i,2).toString());
        String magg=tbHD.getModel().getValueAt(i,3).toString();
        txMaGG.setText(magg);
        txNgayLap.setText(tbHD.getModel().getValueAt(i,4).toString());
        txTongTien.setText(tbHD.getModel().getValueAt(i,5).toString());
        txGiamGia.setText(tbHD.getModel().getValueAt(i,6).toString());
        txThanhTien.setText(tbHD.getModel().getValueAt(i,7).toString());
    }
//Sửa
    public void Sua(){
                StringBuilder sb =new StringBuilder();
                vlBUS.checkEmpty(txMaKH, sb, "Mã Khác Hàng Còn Trống!");
                vlBUS.checkEmpty(txMaNV, sb, "Mã Nhân Viên Còn Trống!");
                vlBUS.checkEmpty(txNgayLap, sb, "Ngày Lập Còn Trống!");
                vlBUS.checkEmpty(txTongTien, sb, "Tổng Tiền Còn Trống!");
                vlBUS.checkEmpty(txGiamGia, sb, "Giảm Giá Còn Trống!");
                vlBUS.checkEmpty(txThanhTien, sb, "Thành Tiền Còn Trống !");
                if(sb.length()>0){
                    JOptionPane.showMessageDialog(this,sb.toString(), "Thông Báo Lỗi Nhập",JOptionPane.ERROR_MESSAGE);
                    return ;
                }
                String MaHD = txMaHD.getText();
                String MaKH = txMaKH.getText();
                String MaNV = txMaNV.getText();
                String NgayLap=txNgayLap.getText();
                String MaGG=txMaGG.getText();
                float TongTien=Float.parseFloat(txTongTien.getText());
                float GiamGia=Float.parseFloat(txGiamGia.getText());
                float ThanhTien=Float.parseFloat(txThanhTien.getText());
                HoaDonPOJO hd1=new HoaDonPOJO(MaHD,MaKH,MaNV,MaGG,NgayLap,TongTien,GiamGia,ThanhTien);
                int i = hdBUS.set(hd1);
                outModel(model, hdBUS.getList());
                tbHD.setRowSelectionInterval(i, i);
                
    }
//Xóa
    public void Clean(){
        txMaHD.setText("");
        txMaKH.setText("");
        txMaNV.setText("");
        txMaGG.setText("");
        txNgayLap.setText("");
        txTongTien.setText("");
        txGiamGia.setText("");
        txThanhTien.setText("");
    }
    public void Xoa(){
        if(txMaHD.getText().equals("")){
            JOptionPane.showMessageDialog(
                    null, 
                    "Vui lòng chọn hóa đơn", 
                    "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
        ChiTietHoaDonBUS chitiet=new ChiTietHoaDonBUS(1);
        HoaDonBUS hoadon=new HoaDonBUS();
           int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa","Alert",JOptionPane.YES_NO_OPTION);
                if(i == 0)
                {
                    chitiet.Xoa(txMaHD.getText());
                    hoadon.Xoa(txMaHD.getText());
                    Clean();
                    tbHD.clearSelection();
                    outModel(model, hoadon.getList());
                    JOptionPane.showMessageDialog(
                    null, 
                    "Xóa thành công", 
                    "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
                }
        }
    }
/* *******************************Chi tiết hóa đơn***************** */
//Load DB CTHD
        public void LoadDBCT(){
            Vector header=new Vector();
            header.add("Mã HĐ");
            header.add("Mã sách");
            header.add("Tên sách");
            header.add("Số lượng");
            header.add("Đơn giá");
            header.add("Giảm Giá");
            header.add("Thành tiền");
           if(modelct.getRowCount()==0){
            modelct=new DefaultTableModel(header,0);
        }
           txMaHDCT.setText(txMaHD.getText());
           if(ctBUS.getList()==null) ctBUS.List();
           ct=ctBUS.getListHD(txMaHD.getText());
           modelct.setRowCount(0);
           outModelCT(modelct,ct);
        }
        public void LoadDBCTF(){
            ChiTietHoaDonBUS ct123=new ChiTietHoaDonBUS();
             Vector header=new Vector();
            header.add("Mã HĐ");
            header.add("Mã sách");
            header.add("Tên sách");
            header.add("Số lượng");
            header.add("Đơn giá");
            header.add("Giảm Giá");
            header.add("Thành tiền");
           if(modelct.getRowCount()==0){
            modelct=new DefaultTableModel(header,0);
        }
           if(ct123.getList()==null) ct123.List();
           outModelCT(modelct,ct123.getList());
        }
        public void outModelCT(DefaultTableModel model1,ArrayList<ChiTietHoaDonPOJO> ct){
            Vector row;
            int tong=0;
            modelct.setRowCount(0);
            for(ChiTietHoaDonPOJO c:ct){
                row=new Vector();
                row.add(c.getMaHD());
                row.add(c.getMaSach());
                row.add(c.getTenSach());
                row.add(c.getSoLuong());
                row.add(c.getDonGia());
                row.add(c.getGiamGia());
                row.add(c.getThanhTien());
                tong=tong+(int)c.getThanhTien();
                model1.addRow(row);
            }
            txSoSP.setText(String.valueOf(modelct.getRowCount()));
            txTongTienCT.setText(String.valueOf(tong));
            tbChiTietHD.setModel(model1);
        }
        
//Đếm số hóa đơn và tiền
        public void Sum(){
            int Sum=0;
            int j=0;
            int n=model.getRowCount();
            for(int i=0;i<n;i++){
                String b=tbHD.getModel().getValueAt(i,7).toString();
                float a=Float.parseFloat(b);
                j=(int)a;
                Sum=Sum+j;
            }
            txSoLuongHD.setText(String.valueOf(model.getRowCount()));
            txTongTienHD.setText(String.valueOf(Sum));
        }
//Tìm kiếm
        public void TimKiem(){
        
        float max = txCuoi.getText().equals("") ? 9999999 : Float.parseFloat(txCuoi.getText());
        float min = txDau.getText().equals("") ? 0      : Float.parseFloat(txDau.getText());
        SimpleDateFormat a=new SimpleDateFormat("yyyy-MM-dd");
        String tgmin;
        if(txNgayMIN.getCalendar()==null)
            tgmin="";
        else
            tgmin=a.format(txNgayMIN.getDate()).toString();
        System.out.print("aaaaa"+tgmin);
        String tgmax;
       if(txNgayMAX.getCalendar()==null)
           tgmax="";
       else
        tgmax=a.format(txNgayMAX.getDate()).toString();
        hd=hdBUS.TimKiem(tgmin,tgmax,max,min,txTimMAHD.getText(),txTimMAKH.getText(),txTimMANV.getText());
            outModel(model,hd);
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCTHDF;
    private javax.swing.JButton btFHD;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btSuaCT;
    private javax.swing.JButton btTim;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btXoaCT;
    private javax.swing.JButton btXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbChiTietHD;
    private javax.swing.JTable tbHD;
    private javax.swing.JTextField txCuoi;
    private javax.swing.JTextField txDau;
    private javax.swing.JTextField txGiamGia;
    private javax.swing.JTextField txMaGG;
    private javax.swing.JTextField txMaHD;
    private javax.swing.JTextField txMaHDCT;
    private javax.swing.JTextField txMaKH;
    private javax.swing.JTextField txMaNV;
    private javax.swing.JTextField txNgayLap;
    private com.toedter.calendar.JDateChooser txNgayMAX;
    private com.toedter.calendar.JDateChooser txNgayMIN;
    private javax.swing.JTextField txSoLuongHD;
    private javax.swing.JTextField txSoSP;
    private javax.swing.JTextField txThanhTien;
    private javax.swing.JTextField txTimMAHD;
    private javax.swing.JTextField txTimMAKH;
    private javax.swing.JTextField txTimMANV;
    private javax.swing.JTextField txTongTien;
    private javax.swing.JTextField txTongTienCT;
    private javax.swing.JTextField txTongTienHD;
    // End of variables declaration//GEN-END:variables

}

