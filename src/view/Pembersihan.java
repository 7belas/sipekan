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
import controller.c_pembersihan;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import model.CrudState;
import model.m_level;
import model.m_pembersihan;


public class Pembersihan extends javax.swing.JFrame implements Observer {
    
    c_pembersihan pembersihan = new c_pembersihan();
    c_kolam kolam = new c_kolam();
    


    public Pembersihan() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pembersihan.addObserver(this);
        setTabelPembersihan(pembersihan.getAllPembersihan());
        setKolam(kolam.getAllKolam());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void setTabelPembersihan(List<m_pembersihan> listPembersihan) {
        if (listPembersihan == null) {
            JOptionPane.showMessageDialog(this, "Data Kolam gagal diambil dari database", "DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(
                    new String[]{
                        "No",
                        "Id",
                        "Nama Kolam",
                        "Deskripsi",
                        "Waktu"
                    }
            );
            int no = 1;
            for (m_pembersihan k : listPembersihan) {
                Object[] o = new Object[5];
                o[0] = no;
                o[1] = k.getId();
                o[2] = k.getKolam().getId();
                o[3] = k.getDeskripsi();
                
                
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

    public void setKolam(List<m_kolam> listKolam) {
        if (listKolam == null) {
            JOptionPane.showMessageDialog(this, "Data Level gagal diambil dari database", "DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        } else {
            tahap_kolam.setModel(new DefaultComboBoxModel(listKolam.toArray()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        keluar = new keeptoo.KButton();
        menuDashboard = new keeptoo.KButton();
        menuKolam = new keeptoo.KButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tambah_kolam = new keeptoo.KButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_kolam = new javax.swing.JTable();
        ubah_kolam = new keeptoo.KButton();
        hapus = new keeptoo.KButton();
        id_pembersihan = new javax.swing.JTextField();
        deskripsi = new javax.swing.JTextField();
        tahap_kolam = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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
        jPanel1.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 160, -1));

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
        menuKolam.setText("Laporan");
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SIMAPAN@2x.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_fish_16px.png"))); // NOI18N
        jLabel3.setText("Pembersihan");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        tambah_kolam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_add_16px.png"))); // NOI18N
        tambah_kolam.setText("    Tambah ");
        tambah_kolam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tambah_kolam.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tambah_kolam.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        tambah_kolam.setIconTextGap(10);
        tambah_kolam.setkEndColor(new java.awt.Color(0, 255, 102));
        tambah_kolam.setkHoverEndColor(new java.awt.Color(0, 204, 51));
        tambah_kolam.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        tambah_kolam.setkHoverStartColor(new java.awt.Color(0, 204, 102));
        tambah_kolam.setkStartColor(new java.awt.Color(0, 204, 102));
        tambah_kolam.setMargin(new java.awt.Insets(2, 20, 2, 10));
        tambah_kolam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_kolamActionPerformed(evt);
            }
        });
        jPanel2.add(tambah_kolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 150, -1));

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

        ubah_kolam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_pencil_16px.png"))); // NOI18N
        ubah_kolam.setText("    Ubah ");
        ubah_kolam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ubah_kolam.setIconTextGap(10);
        ubah_kolam.setkBackGroundColor(new java.awt.Color(51, 153, 255));
        ubah_kolam.setkEndColor(new java.awt.Color(51, 153, 255));
        ubah_kolam.setkHoverEndColor(new java.awt.Color(153, 204, 255));
        ubah_kolam.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        ubah_kolam.setkHoverStartColor(new java.awt.Color(0, 153, 204));
        ubah_kolam.setkSelectedColor(new java.awt.Color(0, 204, 255));
        ubah_kolam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubah_kolamActionPerformed(evt);
            }
        });
        jPanel2.add(ubah_kolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 140, -1));

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

        id_pembersihan.setEnabled(false);
        jPanel2.add(id_pembersihan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 60, 30));
        jPanel2.add(deskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 250, 30));

        tahap_kolam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(tahap_kolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 160, 30));

        jLabel2.setText("Kolam");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, -1));

        jLabel4.setText("Id Kolam");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel5.setText("Deskripsi");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

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
        id_pembersihan.setText("");
        deskripsi.setText("");

    }
    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        masuk masuk = new masuk();
        masuk.setVisible(true);
        dispose();
    }//GEN-LAST:event_keluarActionPerformed

    private void tambah_kolamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_kolamActionPerformed
        // TODO add your handling code here:

        String id = null;
        String nama = deskripsi.getText();
        m_kolam kolam = (m_kolam) tahap_kolam.getSelectedItem();
        System.out.println(tahap_kolam.getSelectedItem().getClass().getName());
        m_pembersihan k = new m_pembersihan(id, kolam, nama);
        pembersihan.manipulate(k, CrudState.INSERT);
    }//GEN-LAST:event_tambah_kolamActionPerformed

    private void menuDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDashboardActionPerformed
        // TODO add your handling code here:
        Pembenihan dashboard = new Pembenihan();
        dashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuDashboardActionPerformed


    private void ubah_kolamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubah_kolamActionPerformed
        // TODO add your handling code here:
        String id = null;
        String nama = deskripsi.getText();
        m_kolam kolam = (m_kolam) tahap_kolam.getSelectedItem();
        System.out.println(tahap_kolam.getSelectedItem().getClass().getName());
        m_pembersihan k = new m_pembersihan(id, kolam, nama);
        pembersihan.manipulate(k, CrudState.UPDATE);
    }//GEN-LAST:event_ubah_kolamActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        String id = null;
        String nama = deskripsi.getText();
        m_kolam kolam = (m_kolam) tahap_kolam.getSelectedItem();
        System.out.println(tahap_kolam.getSelectedItem().getClass().getName());
        m_pembersihan k = new m_pembersihan(id, kolam, nama);
        pembersihan.manipulate(k, CrudState.DELETE);
    }//GEN-LAST:event_hapusActionPerformed

    private void tabel_kolamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_kolamMouseClicked
        // TODO add your handling code here:
        tambah_kolam.setEnabled(false);
        tambah_kolam.setSelected(true);
        int baris = tabel_kolam.rowAtPoint(evt.getPoint());
        id_pembersihan.setText(tabel_kolam.getModel().getValueAt(baris, 1).toString());
        deskripsi.setText(tabel_kolam.getModel().getValueAt(baris, 2).toString());
        m_level l = new m_level(tabel_kolam.getModel().getValueAt(baris, 7).toString(),tabel_kolam.getModel().getValueAt(baris, 3).toString());
        tahap_kolam.getModel().setSelectedItem(l);
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
            java.util.logging.Logger.getLogger(Pembersihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembersihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembersihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembersihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembersihan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField deskripsi;
    private keeptoo.KButton hapus;
    private javax.swing.JTextField id_pembersihan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private keeptoo.KButton keluar;
    private keeptoo.KButton menuDashboard;
    private keeptoo.KButton menuKolam;
    private javax.swing.JTable tabel_kolam;
    private javax.swing.JComboBox<String> tahap_kolam;
    private keeptoo.KButton tambah_kolam;
    private keeptoo.KButton ubah_kolam;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (o == pembersihan) {
            if (arg == null) {
                JOptionPane.showMessageDialog(this, "Pengguna gagal diperbaharui karena kegagalan koneksi ke database");
            } else {
                m_pembersihan u = (m_pembersihan) arg;
                if (pembersihan.getCrudState() == CrudState.INSERT) {
                    JOptionPane.showMessageDialog(this," Laporan berhasil ditambahkan");
                    resetForm();
                } else if (pembersihan.getCrudState() == CrudState.UPDATE) {
                    JOptionPane.showMessageDialog(this, " Laporan berhasil diperbarui");
                    resetForm();
                }
                setTabelPembersihan(pembersihan.getAllPembersihan());
            }
        }
    }
}
