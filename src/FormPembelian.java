
import static java.awt.SystemColor.info;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author windows x
 */
public class FormPembelian extends javax.swing.JFrame {
 private String kategori,merk,warna,ukuran,jumlah;
 private DefaultTableModel model;
 private static com.mysql.jdbc.Connection koneksi;

 
    ArrayList<Data> listData = new ArrayList<Data>();
    DefaultTableModel tabelModel;
    /**
     * Creates new form FormPembelian
     */
    public FormPembelian() {
        initComponents();
             kosong();
         tabelModel = new DefaultTableModel();
        this.tbBeli.setModel(tabelModel);
        tabelModel.addColumn("Kategori");
       tabelModel.addColumn("Merk");
       tabelModel.addColumn("Warna");
        tabelModel.addColumn("Ukuran");
//          tabelModel.addColumn("Harga");
            tabelModel.addColumn("Jumlah");
       
        tampilData();
        
        
         model = new DefaultTableModel();
        this.tb_barang.setModel(model);
        model.addColumn("ID");
        model.addColumn("Kategori");
        model.addColumn("Merk");
        model.addColumn("Warna");
        model.addColumn("Ukuran");
        model.addColumn("Harga");
        ambil_data_tabel();

    }
    
     private void ambil_data_tabel() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            buka_koneksi();
            Statement s = koneksi.createStatement();
            String sql = "Select * from tb_produk";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Object[] o = new Object[6];
                o[0] = r.getString("id");
                o[1] = r.getString("kategori");
                o[2] = r.getString("merk");
                o[3] = r.getString("warna");
                o[4] = r.getString("ukuran");
                o[5] = r.getString("harga");
               
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Terjadi kesalahan " + e.getMessage());
        }
    }
 
     public void tampilData(){
       tabelModel.getDataVector().removeAllElements();
       tabelModel.fireTableDataChanged();
       
       try {
            buka_koneksi();
            Statement s = koneksi.createStatement();
            String sql = "Select * from tb_pembelian";
            ResultSet r = s.executeQuery(sql);
            String[] kolom = {"kategori","merk","warna","ukuran","jumlah"};
        Object[][] objData = new Object[listData.size()][5]; // 3 merupakan jumlah kolom
         
        int i = 0;
        for(Data n : listData){
            String[] arrData = {n.getKategori(), n.getMerk(), n.getWarna(), n.getUkuran(), n.getJumlah()};
            objData[i] = arrData;
            i++;
        }
         
        tabelModel = new DefaultTableModel(objData,kolom){
            //membuat tabel tidak bisa diedit saat diklik
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
         
        tbBeli.setModel(tabelModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Terjadi kesalahan " + e.getMessage());
        }
        
    }
     
    public void isiData(Object selectedItem, String kategori, String merk, String ukuran, String jumlah){
        Data ed = new Data(kategori,merk,warna,ukuran,jumlah);
        listData.add(ed);
    }
     
    private void resetInputan(){
        txt_kategori.setText("");
        txt_merk.setText("");
        txt_warna.setText("");
        txt_ukuran.setText("");
//        txt_harga.setText("");
        txt_jumlah.setText("");
       
    }
    
    
//  public void cek(){
//        try {
//            buka_koneksi();
//            Statement s = koneksi.createStatement();
//            String sql = "Select * from tb_produk where username = '"+txUser.getText()+"' and password = '"+txPass.getText()+"'";
//            ResultSet r = s.executeQuery(sql);
////            st = kon.createStatement();
////            String sql = "SELECT * FROM user where username = '"+txUser.getText()+"' and password = '"+txPass.getText()+"'";
////            rs = st.executeQuery(sql);
//         
//            if(r.next()){
//                if(r.getString("level").equals("admin")){
//                    Produk fa = new Produk();
//                    fa.show();
//                    this.dispose();
//                }else if(r.getString("level").equals("user")){
//                    supplier fu = new supplier();
//                    fu.show();
//                    this.dispose();
//                }
//            }else{
//                JOptionPane.showMessageDialog(null, "Maaf password atau username anda salah");
//                txUser.setText("");
//                txPass.setText("");
//                txUser.requestFocus();
//            }
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
      private static void buka_koneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/tokoku";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                System.out.println("Error membuat koneksi");
            }
        }
    }

       private void kosong() {
        txt_kategori.setText(null);
        txt_merk.setText(null);
        txt_warna.setText(null);
        txt_ukuran.setText(null);
//        txt_harga.setText(null);
        txt_jumlah.setText(null);

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
        lbl_kategori = new javax.swing.JLabel();
        lbl_merk = new javax.swing.JLabel();
        lbl_warna = new javax.swing.JLabel();
        lbl_ukuran = new javax.swing.JLabel();
        txt_merk = new javax.swing.JTextField();
        txt_warna = new javax.swing.JTextField();
        txt_ukuran = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBeli = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        txt_bayar = new javax.swing.JTextField();
        txt_kembali = new javax.swing.JTextField();
        lbl_jumlah = new javax.swing.JLabel();
        txt_jumlah = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txt_kategori = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_barang = new javax.swing.JTable();
        txt_cari = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 200, 150));

        lbl_kategori.setText("Kategori");

        lbl_merk.setText("Merk");

        lbl_warna.setText("Warna");

        lbl_ukuran.setText("Ukuran");

        txt_merk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_merkActionPerformed(evt);
            }
        });

        txt_warna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_warnaActionPerformed(evt);
            }
        });

        tbBeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane2.setViewportView(tbBeli);

        jButton2.setText("Beli");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Total");

        jLabel9.setText("Bayar");

        jLabel10.setText("Kembali");

        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        txt_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kembaliActionPerformed(evt);
            }
        });

        lbl_jumlah.setText("Jumlah");

        txt_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahActionPerformed(evt);
            }
        });

        jButton1.setText("Hitung");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("kembali");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 200, 150));

        tb_barang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb_barang);

        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });

        jButton4.setText("Cari");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(50, 150, 150));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("DAFTAR SEPATU");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(50, 150, 150));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("TRANSAKSI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(309, 309, 309))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)
                                .addGap(30, 30, 30)
                                .addComponent(jButton1)
                                .addGap(205, 205, 205)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_kembali)
                                    .addComponent(txt_bayar)
                                    .addComponent(txt_total)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_kategori)
                                            .addComponent(txt_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(lbl_merk))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(txt_merk, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(116, 116, 116)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_warna, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(37, 37, 37)
                                                        .addComponent(lbl_warna)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(56, 56, 56)
                                                        .addComponent(txt_ukuran, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lbl_ukuran)
                                                        .addGap(22, 22, 22))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jButton3)
                                                        .addGap(60, 60, 60))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(lbl_jumlah)
                                                            .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(69, 69, 69)))
                                                .addGap(6, 6, 6)))))
                                .addGap(0, 44, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_kategori)
                    .addComponent(lbl_merk)
                    .addComponent(lbl_warna)
                    .addComponent(lbl_ukuran)
                    .addComponent(lbl_jumlah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_merk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_warna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ukuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_warnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_warnaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_warnaActionPerformed

    private void txt_merkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_merkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_merkActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kembaliActionPerformed

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    try {
            String sql = "INSERT INTO tb_pembelian (kategori,merk,warna,ukuran,jumlah) VALUES" +"('"+txt_kategori.getText()+"','"+txt_merk.getText()+"','"+txt_warna.getText()+"','"+txt_ukuran.getText()+"','"+txt_jumlah.getText()+"')";;
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
     //int Harga=Integer.parseInt(harga.getText());
     //int Jumlah=Integer.parseInt(jumlah.getText());
     //int Total=Harga*Jumlah;
     //total.setText(" "+Total);
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new supplier().show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txt_cariActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel tabelTampil1 = new DefaultTableModel();
    tabelTampil1.addColumn("ID");
    tabelTampil1.addColumn("Kategori ");
    tabelTampil1.addColumn("Merk ");
    tabelTampil1.addColumn("Warna");
    tabelTampil1.addColumn("Ukuran ");
//    tabelTampil1.addColumn("Harga ");
        try{
             buka_koneksi();
            Statement s = koneksi.createStatement();
            String sql = "Select * from tb_produk where id like '%" + txt_cari.getText() + "%'" +
            "or kategori like '%" + txt_cari.getText() + "%'"+
            "or merk like '%"+ txt_cari.getText()+ "%'"+
            "or warna like '%"+ txt_cari.getText()+ "%'"+
             "or ukuran like '%"+ txt_cari.getText()+ "%'";;
//            "or harga like '%"+ txt_cari.getText()+ "%'";;
             ResultSet r = s.executeQuery(sql);
             
            while (r.next()) {
            tabelTampil1.addRow(new Object[]{
            r.getString(1),
            r.getString(2),
            r.getString(3),
            r.getString(4),
            r.getString(5),
            });
            }
            tb_barang.setModel(tabelTampil1);

                }catch (Exception e){
            }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        tampilData();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(FormPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_jumlah;
    private javax.swing.JLabel lbl_kategori;
    private javax.swing.JLabel lbl_merk;
    private javax.swing.JLabel lbl_ukuran;
    private javax.swing.JLabel lbl_warna;
    private javax.swing.JTable tbBeli;
    private javax.swing.JTable tb_barang;
    private javax.swing.JTextField txt_bayar;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_kategori;
    private javax.swing.JTextField txt_kembali;
    private javax.swing.JTextField txt_merk;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_ukuran;
    private javax.swing.JTextField txt_warna;
    // End of variables declaration//GEN-END:variables
}
