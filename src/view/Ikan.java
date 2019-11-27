/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.c_ikan;
import controller.c_tahap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CrudState;
import model.m_ikan;
import model.m_tahap;


public class Ikan extends javax.swing.JFrame implements Observer {

    c_ikan ikan = new c_ikan();
    c_tahap thp = new c_tahap();

    public Ikan() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ikan.addObserver(this);
        setTabelIkan(ikan.getAllIkan());
        setTahap(thp.getAllTahap());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kButton1 = new keeptoo.KButton();
        menuDashboard = new keeptoo.KButton();
        menuKolam = new keeptoo.KButton();
        kButton4 = new keeptoo.KButton();
        jLabel1 = new javax.swing.JLabel();
        menuAnalisis = new keeptoo.KButton();
        menuTahap = new keeptoo.KButton();
        menuPengguna = new keeptoo.KButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tambah_ikan = new keeptoo.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_ikan = new javax.swing.JTable();
        ubah_ikan = new keeptoo.KButton();
        hapus = new keeptoo.KButton();
        jLabel4 = new javax.swing.JLabel();
        id_ikan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nama_ikan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        suhu_ikan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ph_ikan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tahap_ikan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard Pengguna");
        setBackground(new java.awt.Color(255, 0, 204));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_logout_rounded_up_16px.png"))); // NOI18N
        kButton1.setText("Keluar");
        kButton1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        kButton1.setIconTextGap(15);
        kButton1.setkEndColor(new java.awt.Color(255, 0, 0));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkStartColor(new java.awt.Color(255, 0, 153));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 160, -1));

        menuDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_home_16px_4.png"))); // NOI18N
        menuDashboard.setText("Dashboard");
        menuDashboard.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        menuDashboard.setIconTextGap(15);
        menuDashboard.setkAllowGradient(false);
        menuDashboard.setkBackGroundColor(new java.awt.Color(0, 102, 204));
        menuDashboard.setkEndColor(new java.awt.Color(255, 51, 255));
        menuDashboard.setkHoverColor(new java.awt.Color(255, 0, 102));
        menuDashboard.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        menuDashboard.setkStartColor(new java.awt.Color(255, 51, 0));
        menuDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDashboardActionPerformed(evt);
            }
        });
        jPanel1.add(menuDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 160, 40));

        menuKolam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_aquarius_16px_1.png"))); // NOI18N
        menuKolam.setText("Variasi Kolam");
        menuKolam.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        menuKolam.setIconTextGap(15);
        menuKolam.setkAllowGradient(false);
        menuKolam.setkBackGroundColor(new java.awt.Color(0, 102, 204));
        menuKolam.setkBorderRadius(15);
        menuKolam.setkEndColor(new java.awt.Color(255, 51, 255));
        menuKolam.setkHoverColor(new java.awt.Color(255, 0, 102));
        menuKolam.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        menuKolam.setkHoverStartColor(new java.awt.Color(153, 51, 255));
        menuKolam.setkIndicatorThickness(1);
        menuKolam.setkStartColor(new java.awt.Color(255, 51, 0));
        menuKolam.setOpaque(false);
        menuKolam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKolamActionPerformed(evt);
            }
        });
        jPanel1.add(menuKolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, -1));

        kButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_fish_16px_1.png"))); // NOI18N
        kButton4.setText("Jenis Ikan");
        kButton4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        kButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        kButton4.setIconTextGap(15);
        kButton4.setkBackGroundColor(new java.awt.Color(0, 102, 204));
        kButton4.setkEndColor(new java.awt.Color(255, 51, 255));
        kButton4.setkHoverColor(new java.awt.Color(255, 0, 102));
        kButton4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton4.setkStartColor(new java.awt.Color(255, 51, 0));
        jPanel1.add(kButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 160, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SIMAPAN@2x.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

        menuAnalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_overtime_16px.png"))); // NOI18N
        menuAnalisis.setText("Analisis");
        menuAnalisis.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        menuAnalisis.setIconTextGap(15);
        menuAnalisis.setkAllowGradient(false);
        menuAnalisis.setkBackGroundColor(new java.awt.Color(0, 102, 204));
        menuAnalisis.setkEndColor(new java.awt.Color(0, 204, 204));
        menuAnalisis.setkHoverColor(new java.awt.Color(255, 0, 102));
        menuAnalisis.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        menuAnalisis.setkStartColor(new java.awt.Color(204, 255, 0));
        menuAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAnalisisActionPerformed(evt);
            }
        });
        jPanel1.add(menuAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 160, -1));

        menuTahap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_honeycombs_filled_16px.png"))); // NOI18N
        menuTahap.setText("Tahapan Ikan");
        menuTahap.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        menuTahap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuTahap.setIconTextGap(15);
        menuTahap.setkAllowGradient(false);
        menuTahap.setkBackGroundColor(new java.awt.Color(0, 102, 204));
        menuTahap.setkEndColor(new java.awt.Color(0, 204, 204));
        menuTahap.setkHoverColor(new java.awt.Color(255, 0, 102));
        menuTahap.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        menuTahap.setkStartColor(new java.awt.Color(204, 255, 0));
        menuTahap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTahapActionPerformed(evt);
            }
        });
        jPanel1.add(menuTahap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 160, -1));

        menuPengguna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_user_filled_16px.png"))); // NOI18N
        menuPengguna.setText("Pengguna");
        menuPengguna.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        menuPengguna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuPengguna.setIconTextGap(12);
        menuPengguna.setkAllowGradient(false);
        menuPengguna.setkBackGroundColor(new java.awt.Color(0, 102, 204));
        menuPengguna.setkEndColor(new java.awt.Color(0, 204, 204));
        menuPengguna.setkHoverColor(new java.awt.Color(255, 0, 102));
        menuPengguna.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        menuPengguna.setkStartColor(new java.awt.Color(204, 255, 0));
        menuPengguna.setMargin(new java.awt.Insets(2, 16, 2, 14));
        menuPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPenggunaActionPerformed(evt);
            }
        });
        jPanel1.add(menuPengguna, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 160, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_fish_16px.png"))); // NOI18N
        jLabel3.setText("Ikan");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        tambah_ikan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_add_16px.png"))); // NOI18N
        tambah_ikan.setText("      Tambah Ikan");
        tambah_ikan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tambah_ikan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tambah_ikan.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        tambah_ikan.setIconTextGap(15);
        tambah_ikan.setkBackGroundColor(new java.awt.Color(102, 153, 255));
        tambah_ikan.setkEndColor(new java.awt.Color(0, 255, 102));
        tambah_ikan.setkHoverEndColor(new java.awt.Color(0, 204, 51));
        tambah_ikan.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        tambah_ikan.setkHoverStartColor(new java.awt.Color(0, 204, 102));
        tambah_ikan.setkSelectedColor(new java.awt.Color(51, 102, 255));
        tambah_ikan.setkStartColor(new java.awt.Color(0, 204, 102));
        tambah_ikan.setMargin(new java.awt.Insets(2, 20, 2, 10));
        tambah_ikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_ikanActionPerformed(evt);
            }
        });
        jPanel2.add(tambah_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 140, -1));

        tabel_ikan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabel_ikan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabel_ikan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_ikanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_ikan);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 700, 290));

        ubah_ikan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_pencil_16px.png"))); // NOI18N
        ubah_ikan.setText("      Ubah Ikan");
        ubah_ikan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ubah_ikan.setIconTextGap(15);
        ubah_ikan.setkBackGroundColor(new java.awt.Color(51, 153, 255));
        ubah_ikan.setkEndColor(new java.awt.Color(51, 153, 255));
        ubah_ikan.setkHoverEndColor(new java.awt.Color(153, 204, 255));
        ubah_ikan.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        ubah_ikan.setkHoverStartColor(new java.awt.Color(0, 153, 204));
        ubah_ikan.setkSelectedColor(new java.awt.Color(0, 204, 255));
        ubah_ikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubah_ikanActionPerformed(evt);
            }
        });
        jPanel2.add(ubah_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 130, -1));

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_delete_16px.png"))); // NOI18N
        hapus.setText("     Hapus");
        hapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hapus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hapus.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        hapus.setIconTextGap(10);
        hapus.setkEndColor(new java.awt.Color(255, 51, 153));
        hapus.setkHoverEndColor(new java.awt.Color(255, 0, 0));
        hapus.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        hapus.setkHoverStartColor(new java.awt.Color(255, 0, 51));
        hapus.setkStartColor(new java.awt.Color(255, 0, 51));
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        jPanel2.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 90, -1));

        jLabel4.setText("Id Ikan");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        id_ikan.setEnabled(false);
        jPanel2.add(id_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 60, 30));

        jLabel5.setText("Nama Ikan");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));
        jPanel2.add(nama_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 300, 30));

        jLabel7.setText("Suhu");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));
        jPanel2.add(suhu_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 40, 30));

        jLabel8.setText("Ph");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));
        jPanel2.add(ph_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 40, 30));

        jLabel2.setText("Tahap Ikan");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, -1));

        tahap_ikan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(tahap_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 160, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 770, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void setTabelIkan(List<m_ikan> listIkan) {
        if (listIkan == null) {
            JOptionPane.showMessageDialog(this, "Data Ikan gagal diambil dari database", "DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(
                    new String[]{
                        "No",
                        "Id",
                        "Nama Ikan",
                        "Tahap Ikan",
                        "Ph Ikan",
                        "Suhu Ikan"
                    }
            );
            int no = 1;
            for (m_ikan k : listIkan) {
                Object[] o = new Object[7];
                o[0] = no;
                o[1] = k.getId();
                o[2] = k.getNamaIkan();
                o[3] = k.getTahap().getNamaTahap();
                o[4] = k.getPh();
                o[5] = k.getSuhu();
                tableModel.addRow(o);
                no++;
            }

            tabel_ikan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tabel_ikan.setModel(tableModel);
            tabel_ikan.getColumnModel().getColumn(0).setMaxWidth(30);
            tabel_ikan.removeColumn(tabel_ikan.getColumnModel().getColumn(1));
            tabel_ikan.getColumnModel().getColumn(2).setMinWidth(100);
            tabel_ikan.getColumnModel().getColumn(3).setMaxWidth(80);
        }
    }

    public void setTahap(List<m_tahap> listTahap) {
        if (listTahap == null) {
            JOptionPane.showMessageDialog(this, "Data Level gagal diambil dari database", "DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        } else {
            tahap_ikan.setModel(new DefaultComboBoxModel(listTahap.toArray()));
        }
    }

    public void close_frame() {
        this.dispose();
    }
    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        masuk masuk = new masuk();
        masuk.setVisible(true);
        dispose();
    }//GEN-LAST:event_kButton1ActionPerformed

    private void tambah_ikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_ikanActionPerformed
        // TODO add your handling code here:
        String id = null;
        String nama = nama_ikan.getText();
        int suhu = Integer.parseInt(suhu_ikan.getText());
        int ph = Integer.parseInt(ph_ikan.getText());
        m_tahap tahap = (m_tahap) tahap_ikan.getSelectedItem();
        System.out.println(tahap_ikan.getSelectedItem().getClass().getName());
        m_ikan k = new m_ikan(id, tahap, nama, suhu, ph);
        ikan.manipulate(k, CrudState.INSERT);

    }//GEN-LAST:event_tambah_ikanActionPerformed

    private void menuDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDashboardActionPerformed
        // TODO add your handling code here:
        Pembenihan dashboard = new Pembenihan();
        dashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuDashboardActionPerformed

    private void menuKolamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKolamActionPerformed
        // TODO add your handling code here:
        Kolam kolam = new Kolam();
        kolam.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuKolamActionPerformed

    private void menuAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAnalisisActionPerformed
        // TODO add your handling code here:
        Analisis analisis = new Analisis();
        analisis.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuAnalisisActionPerformed

    private void menuPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPenggunaActionPerformed
        // TODO add your handling code here:
        Pengguna user = new Pengguna();
        user.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuPenggunaActionPerformed

    private void menuTahapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTahapActionPerformed
        // TODO add your handling code here:
        Tahap tahap = new Tahap();
        tahap.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuTahapActionPerformed
    private void resetForm() {
        id_ikan.setText("");
        nama_ikan.setText("");
        suhu_ikan.setText("");
        ph_ikan.setText("");
    }
    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        String id = id_ikan.getText();
        String nama = nama_ikan.getText();
        
        m_ikan k = new m_ikan(id, nama);
        
        ikan.manipulate(k, CrudState.DELETE);

    }//GEN-LAST:event_hapusActionPerformed

    private void tabel_ikanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_ikanMouseClicked
        // TODO add your handling code here:
        tambah_ikan.setEnabled(false);
        tambah_ikan.setSelected(true);
        int baris = tabel_ikan.rowAtPoint(evt.getPoint());
        id_ikan.setText(tabel_ikan.getModel().getValueAt(baris, 1).toString());
        nama_ikan.setText(tabel_ikan.getModel().getValueAt(baris, 2).toString());
        suhu_ikan.setText(tabel_ikan.getModel().getValueAt(baris, 5).toString());
        ph_ikan.setText(tabel_ikan.getModel().getValueAt(baris, 4).toString());
        tahap_ikan.getModel().setSelectedItem(tabel_ikan.getModel().getValueAt(baris, 3).toString());
    }//GEN-LAST:event_tabel_ikanMouseClicked

    private void ubah_ikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubah_ikanActionPerformed
        // TODO add your handling code here:
        String id = id_ikan.getText();
        String nama = nama_ikan.getText();
        int suhu = Integer.parseInt(suhu_ikan.getText());
        int ph = Integer.parseInt(ph_ikan.getText());
        m_tahap tahap = (m_tahap) tahap_ikan.getSelectedItem();
        System.out.println(tahap_ikan.getSelectedItem().getClass().getName());
        m_ikan k = new m_ikan(id, tahap, nama, suhu, ph);
        ikan.manipulate(k, CrudState.UPDATE);
    }//GEN-LAST:event_ubah_ikanActionPerformed

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
            java.util.logging.Logger.getLogger(Ikan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ikan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ikan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ikan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ikan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton hapus;
    private javax.swing.JTextField id_ikan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KButton kButton1;
    private keeptoo.KButton kButton4;
    private keeptoo.KButton menuAnalisis;
    private keeptoo.KButton menuDashboard;
    private keeptoo.KButton menuKolam;
    private keeptoo.KButton menuPengguna;
    private keeptoo.KButton menuTahap;
    private javax.swing.JTextField nama_ikan;
    private javax.swing.JTextField ph_ikan;
    private javax.swing.JTextField suhu_ikan;
    private javax.swing.JTable tabel_ikan;
    private javax.swing.JComboBox<String> tahap_ikan;
    private keeptoo.KButton tambah_ikan;
    private keeptoo.KButton ubah_ikan;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (o == ikan) {
            if (arg == null) {
                JOptionPane.showMessageDialog(this, "Pengguna gagal diperbaharui karena kegagalan koneksi ke database");
            } else {
                m_ikan u = (m_ikan) arg;
                if (ikan.getCrudState() == CrudState.INSERT) {
                    JOptionPane.showMessageDialog(this, u.getNamaIkan() + " berhasil ditambahkan");
                    resetForm();
                } else if (ikan.getCrudState() == CrudState.UPDATE) {
                    JOptionPane.showMessageDialog(this, u.getNamaIkan() + " berhasil diperbarui");
                    resetForm();
                } else if (ikan.getCrudState() == CrudState.DELETE) {
                    JOptionPane.showMessageDialog(this, u.getNamaIkan() + " berhasil dihapus");
                    resetForm();
                }
                setTabelIkan(ikan.getAllIkan());
            }
        }
    }
}
