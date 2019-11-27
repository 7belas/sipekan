/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.c_tahap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CrudState;
import model.m_tahap;


public class Tahap extends javax.swing.JFrame implements Observer{

    c_tahap tahap = new c_tahap();

    public Tahap() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tahap.addObserver(this);
        setTabelTahap(tahap.getAllTahap());
    }

    private void setTabelTahap(List<m_tahap> listTahap) {
        if (listTahap == null) {
            JOptionPane.showMessageDialog(this, "Data Tahap gagal diambil dari database", "DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(
                    new String[]{
                        "No",
                        "Id",
                        "Nama Tahap"
                    }
            );
            int no = 1;
            for (m_tahap k : listTahap) {
                Object[] o = new Object[3];
                o[0] = no;
                o[1] = k.getId();
                o[2] = k.getNamaTahap();
                no++;
                tableModel.addRow(o);

            }

            tabel_tahap.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tabel_tahap.setModel(tableModel);
            tabel_tahap.getColumnModel().getColumn(0).setMaxWidth(30);
            tabel_tahap.removeColumn(tabel_tahap.getColumnModel().getColumn(1));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        keluar = new keeptoo.KButton();
        menuDashboard = new keeptoo.KButton();
        menuKolam = new keeptoo.KButton();
        menuIkan = new keeptoo.KButton();
        jLabel1 = new javax.swing.JLabel();
        menuAnalisis = new keeptoo.KButton();
        menuTahap = new keeptoo.KButton();
        menuPengguna = new keeptoo.KButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_tahap = new javax.swing.JTable();
        tambah_tahap = new keeptoo.KButton();
        ubah_tahap = new keeptoo.KButton();
        hapus = new keeptoo.KButton();
        id_tahap = new javax.swing.JTextField();
        nama_tahap = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard Pengguna");
        setBackground(new java.awt.Color(255, 0, 204));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_logout_rounded_up_16px.png"))); // NOI18N
        keluar.setText("Keluar");
        keluar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        keluar.setIconTextGap(15);
        keluar.setkEndColor(new java.awt.Color(255, 0, 0));
        keluar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        keluar.setkStartColor(new java.awt.Color(255, 0, 153));
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        jPanel1.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 160, -1));

        menuDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_home_16px_4.png"))); // NOI18N
        menuDashboard.setText("Dashboard");
        menuDashboard.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        menuDashboard.setIconTextGap(15);
        menuDashboard.setkAllowGradient(false);
        menuDashboard.setkBackGroundColor(new java.awt.Color(0, 102, 204));
        menuDashboard.setkEndColor(new java.awt.Color(255, 51, 255));
        menuDashboard.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        menuDashboard.setkStartColor(new java.awt.Color(255, 51, 0));
        menuDashboard.setMargin(new java.awt.Insets(2, 16, 2, 14));
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
        menuKolam.setkEndColor(new java.awt.Color(0, 204, 204));
        menuKolam.setkHoverColor(new java.awt.Color(255, 0, 102));
        menuKolam.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        menuKolam.setkHoverStartColor(new java.awt.Color(153, 51, 255));
        menuKolam.setkIndicatorThickness(1);
        menuKolam.setkStartColor(new java.awt.Color(204, 255, 0));
        menuKolam.setMargin(new java.awt.Insets(2, 16, 2, 14));
        menuKolam.setOpaque(false);
        menuKolam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKolamActionPerformed(evt);
            }
        });
        jPanel1.add(menuKolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, -1));

        menuIkan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_fish_16px_1.png"))); // NOI18N
        menuIkan.setText("Jenis Ikan");
        menuIkan.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        menuIkan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menuIkan.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        menuIkan.setIconTextGap(15);
        menuIkan.setkAllowGradient(false);
        menuIkan.setkBackGroundColor(new java.awt.Color(0, 102, 204));
        menuIkan.setkEndColor(new java.awt.Color(0, 204, 204));
        menuIkan.setkHoverColor(new java.awt.Color(255, 0, 102));
        menuIkan.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        menuIkan.setkStartColor(new java.awt.Color(204, 255, 0));
        menuIkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIkanActionPerformed(evt);
            }
        });
        jPanel1.add(menuIkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 160, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SIMAPAN@2x.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

        menuAnalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_overtime_16px.png"))); // NOI18N
        menuAnalisis.setText("Analisis Ikan");
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
        menuTahap.setText("Tahap Ikan");
        menuTahap.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        menuTahap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuTahap.setIconTextGap(15);
        menuTahap.setkBackGroundColor(new java.awt.Color(0, 102, 204));
        menuTahap.setkEndColor(new java.awt.Color(255, 51, 255));
        menuTahap.setkHoverColor(new java.awt.Color(255, 0, 102));
        menuTahap.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        menuTahap.setkStartColor(new java.awt.Color(255, 51, 0));
        menuTahap.setMargin(new java.awt.Insets(2, 16, 2, 14));
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
        jLabel3.setText("Tahap Budidaya");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        tabel_tahap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabel_tahap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_tahapMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_tahap);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 690, 300));

        tambah_tahap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_add_16px.png"))); // NOI18N
        tambah_tahap.setText("    Tambah Tahap");
        tambah_tahap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tambah_tahap.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tambah_tahap.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        tambah_tahap.setIconTextGap(10);
        tambah_tahap.setkEndColor(new java.awt.Color(0, 255, 102));
        tambah_tahap.setkHoverEndColor(new java.awt.Color(0, 204, 51));
        tambah_tahap.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        tambah_tahap.setkHoverStartColor(new java.awt.Color(0, 204, 102));
        tambah_tahap.setkStartColor(new java.awt.Color(0, 204, 102));
        tambah_tahap.setMargin(new java.awt.Insets(2, 20, 2, 10));
        tambah_tahap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_tahapActionPerformed(evt);
            }
        });
        jPanel2.add(tambah_tahap, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 150, -1));

        ubah_tahap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_pencil_16px.png"))); // NOI18N
        ubah_tahap.setText("    Ubah Tahap");
        ubah_tahap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ubah_tahap.setIconTextGap(10);
        ubah_tahap.setkBackGroundColor(new java.awt.Color(51, 153, 255));
        ubah_tahap.setkEndColor(new java.awt.Color(51, 153, 255));
        ubah_tahap.setkHoverEndColor(new java.awt.Color(153, 204, 255));
        ubah_tahap.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        ubah_tahap.setkHoverStartColor(new java.awt.Color(0, 153, 204));
        ubah_tahap.setkSelectedColor(new java.awt.Color(0, 204, 255));
        ubah_tahap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubah_tahapActionPerformed(evt);
            }
        });
        jPanel2.add(ubah_tahap, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 140, -1));

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

        id_tahap.setEnabled(false);
        id_tahap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_tahapActionPerformed(evt);
            }
        });
        jPanel2.add(id_tahap, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 50, 30));

        nama_tahap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_tahapActionPerformed(evt);
            }
        });
        jPanel2.add(nama_tahap, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 180, 30));

        jLabel2.setText("Nama Tahap");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, -1, -1));

        jLabel4.setText("Id Tahap");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        jSeparator2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
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
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void resetForm(){
        id_tahap.setText("");
        nama_tahap.setText("");
    }
    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        masuk masuk = new masuk();
        masuk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_keluarActionPerformed

    private void menuKolamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKolamActionPerformed
        // TODO add your handling code here:
        Tahap kolam = new Tahap();
        kolam.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuKolamActionPerformed

    private void menuIkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIkanActionPerformed
        // TODO add your handling code here:
        Ikan ikan = new Ikan();
        ikan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuIkanActionPerformed

    private void menuAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAnalisisActionPerformed
        // TODO add your handling code here:
        Analisis t = new Analisis();
        t.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuAnalisisActionPerformed

    private void menuPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPenggunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuPenggunaActionPerformed

    private void menuDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDashboardActionPerformed
        // TODO add your handling code here:
        Pembenihan dashboard = new Pembenihan();
        dashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuDashboardActionPerformed

    private void tambah_tahapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_tahapActionPerformed
        // TODO add your handling code here:
        String idTahap = null;
        String namaTahap = nama_tahap.getText();
        
        m_tahap thp = new m_tahap(idTahap,namaTahap);
        tahap.manipulate(thp, CrudState.INSERT);
        tambah_tahap.setEnabled(true);
        tambah_tahap.setSelected(false);
        
    }//GEN-LAST:event_tambah_tahapActionPerformed

    private void ubah_tahapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubah_tahapActionPerformed
        String idTahap = id_tahap.getText();
        String namaTahap = nama_tahap.getText();
        
        m_tahap thp = new m_tahap(idTahap,namaTahap);
        tahap.manipulate(thp, CrudState.UPDATE);
        tambah_tahap.setEnabled(true);
        tambah_tahap.setSelected(false);

    }//GEN-LAST:event_ubah_tahapActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        String idTahap = id_tahap.getText();
        String namaTahap = nama_tahap.getText();
        
        m_tahap thp = new m_tahap(idTahap,namaTahap);
        tahap.manipulate(thp, CrudState.DELETE);
        tambah_tahap.setEnabled(true);
        tambah_tahap.setSelected(false);
    }//GEN-LAST:event_hapusActionPerformed

    private void id_tahapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_tahapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_tahapActionPerformed

    private void nama_tahapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_tahapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_tahapActionPerformed

    private void tabel_tahapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_tahapMouseClicked
        // TODO add your handling code here:
        tambah_tahap.setEnabled(false);
        tambah_tahap.setSelected(true);
        int baris = tabel_tahap.rowAtPoint(evt.getPoint());
        id_tahap.setText(tabel_tahap.getModel().getValueAt(baris, 1).toString());
        nama_tahap.setText(tabel_tahap.getModel().getValueAt(baris, 2).toString());
        
    }//GEN-LAST:event_tabel_tahapMouseClicked
    @Override
    public void update(Observable o, Object arg) {
    if (o == tahap) {
            if (arg == null) {
                JOptionPane.showMessageDialog(this, "Pengguna gagal diperbaharui karena kegagalan koneksi ke database");
            } else {
                m_tahap t = (m_tahap) arg;
                if (tahap.getCrudState() == CrudState.INSERT) {
                    JOptionPane.showMessageDialog(this, t.getNamaTahap() + " berhasil ditambahkan");
                    resetForm();
                }else if (tahap.getCrudState() == CrudState.UPDATE){
                    JOptionPane.showMessageDialog(this, t.getNamaTahap() + " berhasil diperbarui");
                    resetForm();
                }
                setTabelTahap(tahap.getAllTahap());
            }
        }   
    }
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
            java.util.logging.Logger.getLogger(Tahap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tahap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tahap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tahap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tahap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton hapus;
    private javax.swing.JTextField id_tahap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private keeptoo.KButton keluar;
    private keeptoo.KButton menuAnalisis;
    private keeptoo.KButton menuDashboard;
    private keeptoo.KButton menuIkan;
    private keeptoo.KButton menuKolam;
    private keeptoo.KButton menuPengguna;
    private keeptoo.KButton menuTahap;
    private javax.swing.JTextField nama_tahap;
    private javax.swing.JTable tabel_tahap;
    private keeptoo.KButton tambah_tahap;
    private keeptoo.KButton ubah_tahap;
    // End of variables declaration//GEN-END:variables

    
}
