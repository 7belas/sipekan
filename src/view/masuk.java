/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.c_user;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import keeptoo.KButton;
import model.user_session;

public class masuk extends javax.swing.JFrame {

    c_user masuk = new c_user();

    public masuk() {
        initComponents();
    }

    public KButton getBtnMasuk() {
        return btnMasuk;
    }

    public void AksiMasuk(ActionListener ae) {
        btnMasuk.addActionListener(ae);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        sandi = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnMasuk = new keeptoo.KButton();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi SIMAPAN (Sistem Manajemen Perikanan)");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/gambar/icons8-fish-100.png")));
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(650, 510));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 0, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 510));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setBackground(new java.awt.Color(255, 102, 204));
        kGradientPanel1.setkBorderRadius(20);
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sandi.setBackground(new Color(0,0,0,65));
        sandi.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        sandi.setForeground(new java.awt.Color(255, 255, 255));
        sandi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        sandi.setCaretColor(new java.awt.Color(255, 255, 255));
        sandi.setOpaque(false);
        kGradientPanel1.add(sandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 230, 30));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nama Pengguna");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Kata Sandi");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        btnMasuk.setBackground(new java.awt.Color(51, 102, 255));
        btnMasuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_logout_rounded_up_16px.png"))); // NOI18N
        btnMasuk.setText("       Masuk Sekarang");
        btnMasuk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMasuk.setIconTextGap(15);
        btnMasuk.setkBorderRadius(15);
        btnMasuk.setkHoverEndColor(new java.awt.Color(0, 255, 51));
        btnMasuk.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnMasuk.setkHoverStartColor(new java.awt.Color(0, 204, 51));
        btnMasuk.setkSelectedColor(new java.awt.Color(0, 204, 255));
        btnMasuk.setkStartColor(new java.awt.Color(0, 153, 255));
        btnMasuk.setOpaque(false);
        btnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 170, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SIMAPAN@2x.png"))); // NOI18N
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        username.setBackground(new Color(0,0,0,65));
        username.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        username.setCaretColor(new java.awt.Color(255, 255, 255));
        username.setOpaque(false);
        kGradientPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 230, 30));

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 400, 340));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukActionPerformed
        // TODO add your handling code here:
        String nama_pengguna = username.getText();
        String pass = sandi.getText();

        String status = masuk.cek_login(nama_pengguna, pass);
        user_session us = new user_session();
        System.out.println(us.getNama());
        
        if(status == "berhasil"){
            if(Integer.parseInt(us.getLevel().getId())==1){
                Dashboard dash = new Dashboard();
                dash.setVisible(true);
                this.dispose();
            }else{
                DashboardUser dash = new DashboardUser();
                dash.setVisible(true);
                this.dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Maaf password atau username anda salah");
            username.setText("");
            sandi.setText("");
            username.requestFocus();
        }
//        if (!status.equals("salah")) {
//            if (status.equals("admin")) {
//                Dashboard dash = new Dashboard();
//                dash.setVisible(true);
//                dispose();
//            } else if (status.equals("user")) {
//                DashboardUser dash = new DashboardUser();
//                dash.setVisible(true);
//                dispose();
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Maaf password atau username anda salah");
//            username.setText("");
//            sandi.setText("");
//            username.requestFocus();
//        }
    }//GEN-LAST:event_btnMasukActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new masuk().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton btnMasuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JPasswordField sandi;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
