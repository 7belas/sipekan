/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.m_kolam;
import controller.c_kolam;
import controller.c_tahap;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import model.CrudState;
import model.m_level;
import model.m_tahap;


public class KolamBos extends javax.swing.JFrame implements Observer {

    c_kolam kolam = new c_kolam();
    c_tahap tahap = new c_tahap();

    public KolamBos() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        kolam.addObserver(this);
        setTabelKolam(kolam.getAllKolam());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void setTabelKolam(List<m_kolam> listKolam) {
        if (listKolam == null) {
            JOptionPane.showMessageDialog(this, "Data Kolam gagal diambil dari database", "DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(
                    new String[]{
                        "No",
                        "Id",
                        "Nama Kolam",
                        "Tahap Kolam",
                        "Volume Kolam",
                        "Suhu Kolam",
                        "Ph Kolam"
                    }
            );
            int no = 1;
            for (m_kolam k : listKolam) {
                Object[] o = new Object[9];
                o[0] = no;
                o[1] = k.getId();
                o[2] = k.getNamaKolam();
                o[3] = k.getTahap().getNamaTahap();
                o[4] = k.getVolume();
                o[5] = k.getSuhu();
                o[6] = k.getPh();
                o[7] = k.getTahap().getId();
                tableModel.addRow(o);
                no++;
            }

            tabel_kolam.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tabel_kolam.setModel(tableModel);
            tabel_kolam.getColumnModel().getColumn(0).setMaxWidth(30);
            tabel_kolam.removeColumn(tabel_kolam.getColumnModel().getColumn(1));
//            tabel_kolam.removeColumn(tabel_kolam.getColumnModel().getColumn(7));
            tabel_kolam.getColumnModel().getColumn(2).setMinWidth(100);
            tabel_kolam.getColumnModel().getColumn(3).setMaxWidth(80);
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
        tabel_kolam = new javax.swing.JTable();

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
        menuKolam.setkBackGroundColor(new java.awt.Color(0, 102, 204));
        menuKolam.setkBorderRadius(15);
        menuKolam.setkEndColor(new java.awt.Color(255, 51, 255));
        menuKolam.setkHoverColor(new java.awt.Color(255, 0, 102));
        menuKolam.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        menuKolam.setkHoverStartColor(new java.awt.Color(153, 51, 255));
        menuKolam.setkIndicatorThickness(1);
        menuKolam.setkStartColor(new java.awt.Color(255, 51, 0));
        menuKolam.setOpaque(false);
        jPanel1.add(menuKolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, -1));

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
        jPanel1.add(menuIkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 160, -1));

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
        jPanel1.add(menuAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 160, -1));

        menuTahap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_honeycombs_filled_16px.png"))); // NOI18N
        menuTahap.setText("Tahap Ikan");
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
        jPanel1.add(menuTahap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 160, -1));

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
        jPanel1.add(menuPengguna, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 160, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_fish_16px.png"))); // NOI18N
        jLabel3.setText("Kolam Ikan");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        tabel_kolam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabel_kolam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_kolamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_kolam);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 690, 290));

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
    private void resetForm(){

    }
    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        masuk masuk = new masuk();
        masuk.setVisible(true);
        dispose();
    }//GEN-LAST:event_keluarActionPerformed

    private void menuDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDashboardActionPerformed
        // TODO add your handling code here:
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuDashboardActionPerformed

    private void menuIkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIkanActionPerformed
        // TODO add your handling code here:
        Ikan ikan = new Ikan();
        ikan.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuIkanActionPerformed

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
    }//GEN-LAST:event_menuPenggunaActionPerformed


    private void menuTahapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTahapActionPerformed
        // TODO add your handling code here:

        // TODO add your handling code here:
        Tahap tahap = new Tahap();
        tahap.setVisible(true);
        dispose();

    }//GEN-LAST:event_menuTahapActionPerformed

    private void tabel_kolamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_kolamMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tabel_kolamMouseClicked

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
            java.util.logging.Logger.getLogger(KolamBos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KolamBos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KolamBos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KolamBos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KolamBos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private keeptoo.KButton keluar;
    private keeptoo.KButton menuAnalisis;
    private keeptoo.KButton menuDashboard;
    private keeptoo.KButton menuIkan;
    private keeptoo.KButton menuKolam;
    private keeptoo.KButton menuPengguna;
    private keeptoo.KButton menuTahap;
    private javax.swing.JTable tabel_kolam;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (o == kolam) {
            if (arg == null) {
                JOptionPane.showMessageDialog(this, "Pengguna gagal diperbaharui karena kegagalan koneksi ke database");
            } else {
                m_kolam u = (m_kolam) arg;
                if (kolam.getCrudState() == CrudState.INSERT) {
                    JOptionPane.showMessageDialog(this, u.getNamaKolam() + " berhasil ditambahkan");
                    resetForm();
                } else if (kolam.getCrudState() == CrudState.UPDATE) {
                    JOptionPane.showMessageDialog(this, u.getNamaKolam() + " berhasil diperbarui");
                    resetForm();
                }
                setTabelKolam(kolam.getAllKolam());
            }
        }
    }
}
