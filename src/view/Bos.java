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
import controller.c_ikan;
import controller.c_analisis;
import controller.c_level;
import controller.c_user;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import model.CrudState;
import model.m_analisis;
import model.m_level;
import model.m_tahap;
import model.m_ikan;
import model.m_kolam;
import model.m_user;
import model.user_session;

import model.user_session;

public class Bos extends javax.swing.JFrame implements Observer {

    c_kolam kolam = new c_kolam();
    c_tahap tahap = new c_tahap();
    c_ikan ikan = new c_ikan();
    c_analisis analyzer = new c_analisis();
    c_level level = new c_level();
    c_user user = new c_user();
    
    
    
    public Bos() {
        initComponents();
        jmlKlm1.setText(kolam.getJml());
        jmlIkan1.setText(ikan.getJml());
        totalAnalisis1.setText(analyzer.getJml());
        namaSapaan1.setText(user_session.getNama());
        setTabelKolam(kolam.getAllKolam());
        setTabelIkan(ikan.getAllIkan());
        setTabelTahap(tahap.getAllTahap());
        setTabelAnalisis(analyzer.getAllAnalisis());
        setTabelPengguna(user.getAllUser());
        setLevel(level.getAllLevel());
    }
    
    @Override
    public void update(Observable o, Object arg) {
    if (o == user) {
            if (arg == null) {
                JOptionPane.showMessageDialog(this, "Pengguna gagal diperbaharui karena kegagalan koneksi ke database");
            } else {
                m_user a = (m_user) arg;
                if (user.getCrudState() == CrudState.INSERT) {
                    JOptionPane.showMessageDialog(this, a.getNama()+"berhasil ditambahkan");
                }
                setTabelAnalisis(analyzer.getAllAnalisis());
            }
        }    
    }
    
    private void setTabelPengguna(List<m_user> listUser) {
        if (listUser == null) {
            JOptionPane.showMessageDialog(this, "Data Pengguna gagal diambil dari database", "DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(
                    new String[]{
                        "Id",
                        "Nama Lengkap",
                        "Username",
                        "Id Level",
                        "Level"
                    }
            );
            int no = 1;
            for (m_user u : listUser) {
                Object[] o = new Object[5];
                o[0] = u.getId();
                o[1] = u.getNama();
                o[2] = u.getUsername().toUpperCase();
                o[3] = u.getLevel().getId();
                o[4] = u.getLevel().getLevel();
                tableModel.addRow(o);

            }

            tabel_pengguna.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tabel_pengguna.setModel(tableModel);
            tabel_pengguna.getColumnModel().getColumn(0).setMaxWidth(30);
            tabel_pengguna.getColumnModel().getColumn(1).setMinWidth(100);
            tabel_pengguna.getColumnModel().getColumn(2).setMaxWidth(50);
            tabel_pengguna.removeColumn(tabel_pengguna.getColumnModel().getColumn(3));
        }
    }

    public void setLevel(List<m_level> listLevel) {
        if (listLevel == null) {
            JOptionPane.showMessageDialog(this, "Data Level gagal diambil dari database", "DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        } else {
            level_user.setModel(new DefaultComboBoxModel(listLevel.toArray()));
        }
    }

    
    
    
 
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
                        "Nama Ikan",
                        "Volume Kolam",
                        "Suhu Kolam",
                        "Ph Kolam"
                    }
            );
            int no = 1;
            for (m_kolam k : listKolam) {
                Object[] o = new Object[10];
                o[0] = no;
                o[1] = k.getId();
                o[2] = k.getNamaKolam();
                o[3] = k.getIkan().getNamaIkan();
                o[4] = k.getTahap().getNamaTahap();
                o[5] = k.getVolume();
                o[6] = k.getSuhu();
                o[7] = k.getPh();
                o[8] = k.getTahap().getId();
                o[9] = k.getIkan().getId();
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
        
        private void setTabelAnalisis(List<m_analisis> listAnalisis){
        if (listAnalisis == null) {
            JOptionPane.showMessageDialog(this, "Data Hasil Analisis gagal diambil dari database", "DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(
                    new String[]{
                        "No",
                        "Id",
                        "Hasil Analisis",
                        "Tanggal Analisis",
                        "Penganalisis",
                        "Nama Kolam",
                        "Nama Ikan"
                    }
            );
            int no = 1;
            for (m_analisis k : listAnalisis) {
                Object[] o = new Object[7];
                o[0] = no;
                o[1] = k.getId();
                o[2] = k.getHasil();
                o[3] = k.getTanggal();
                o[4] = k.getUser().getNama();
                o[5] = k.getKolam().getNamaKolam();
                o[6] = k.getIkan().getNamaIkan();
                tableModel.addRow(o);
                no++;
            }

            tabel_analisis.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tabel_analisis.setModel(tableModel);
            tabel_analisis.getColumnModel().getColumn(0).setMaxWidth(30);
            tabel_analisis.removeColumn(tabel_analisis.getColumnModel().getColumn(1));
            tabel_analisis.getColumnModel().getColumn(2).setMinWidth(100);
            tabel_analisis.getColumnModel().getColumn(3).setMaxWidth(80);
        }
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
        kButton1 = new keeptoo.KButton();
        menuDashboard = new keeptoo.KButton();
        menuKolam = new keeptoo.KButton();
        menuIkan = new keeptoo.KButton();
        jLabel1 = new javax.swing.JLabel();
        menuAnalisis = new keeptoo.KButton();
        menuTahap = new keeptoo.KButton();
        menuPengguna = new keeptoo.KButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        dashboardBosPanel = new javax.swing.JPanel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        jmlKlm1 = new javax.swing.JLabel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        jLabel7 = new javax.swing.JLabel();
        totalAnalisis1 = new javax.swing.JLabel();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        jLabel9 = new javax.swing.JLabel();
        jmlIkan1 = new javax.swing.JLabel();
        namaSapaan1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        kolamBosPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_kolam = new javax.swing.JTable();
        ikanBosPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_ikan = new javax.swing.JTable();
        tahapBosPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_tahap = new javax.swing.JTable();
        analisisBosPanel = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabel_analisis = new javax.swing.JTable();
        penggunaBosPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabel_pengguna = new javax.swing.JTable();
        tambah_pengguna = new keeptoo.KButton();
        ubah_pengguna = new keeptoo.KButton();
        Id_field = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        level_user = new javax.swing.JComboBox<>();
        nama_label = new javax.swing.JLabel();
        nama_label1 = new javax.swing.JLabel();
        nama_label2 = new javax.swing.JLabel();
        nama_label3 = new javax.swing.JLabel();
        ubah_password = new javax.swing.JCheckBox();
        nama_lengkap = new javax.swing.JTextField();
        nama_label4 = new javax.swing.JLabel();

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
        menuIkan.setText("Role Ikan");
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
        menuTahap.setkAllowGradient(false);
        menuTahap.setkBackGroundColor(new java.awt.Color(0, 102, 204));
        menuTahap.setkEndColor(new java.awt.Color(0, 204, 204));
        menuTahap.setkHoverColor(new java.awt.Color(255, 0, 102));
        menuTahap.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        menuTahap.setkStartColor(new java.awt.Color(204, 255, 0));
        menuTahap.setMargin(new java.awt.Insets(2, 16, 2, 14));
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

        jSeparator2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jPanel3.setLayout(new java.awt.CardLayout());

        dashboardBosPanel.setBackground(new java.awt.Color(255, 255, 255));
        dashboardBosPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jumlah Kolam (Buah)");
        kGradientPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jmlKlm1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jmlKlm1.setForeground(new java.awt.Color(255, 255, 255));
        jmlKlm1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlKlm1.setText("10");
        jmlKlm1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kGradientPanel4.add(jmlKlm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 120, -1));

        dashboardBosPanel.add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 220, 90));

        kGradientPanel5.setkEndColor(new java.awt.Color(255, 102, 102));
        kGradientPanel5.setkStartColor(new java.awt.Color(0, 204, 204));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total Analisis");

        totalAnalisis1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        totalAnalisis1.setForeground(new java.awt.Color(255, 255, 255));
        totalAnalisis1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalAnalisis1.setText("100");

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel5Layout.createSequentialGroup()
                        .addComponent(totalAnalisis1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(73, 73, 73))))
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalAnalisis1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        dashboardBosPanel.add(kGradientPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 220, 90));

        kGradientPanel6.setkBorderRadius(15);
        kGradientPanel6.setkEndColor(new java.awt.Color(255, 153, 0));
        kGradientPanel6.setkGradientFocus(400);
        kGradientPanel6.setkStartColor(new java.awt.Color(255, 102, 204));
        kGradientPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Jumlah Ikan");
        kGradientPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jmlIkan1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jmlIkan1.setForeground(new java.awt.Color(255, 255, 255));
        jmlIkan1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlIkan1.setText("10");
        kGradientPanel6.add(jmlIkan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 143, -1));

        dashboardBosPanel.add(kGradientPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 220, 90));

        namaSapaan1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        namaSapaan1.setText("Guys");
        dashboardBosPanel.add(namaSapaan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Hai ,");
        dashboardBosPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jPanel3.add(dashboardBosPanel, "card2");

        kolamBosPanel.setBackground(new java.awt.Color(255, 255, 255));
        kolamBosPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_fish_16px.png"))); // NOI18N
        jLabel3.setText("Kolam Ikan");
        kolamBosPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

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

        kolamBosPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 690, 290));

        jPanel3.add(kolamBosPanel, "card3");

        ikanBosPanel.setBackground(new java.awt.Color(255, 255, 255));
        ikanBosPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_fish_16px.png"))); // NOI18N
        jLabel14.setText("Ikan");
        ikanBosPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

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

        ikanBosPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 700, 290));

        jPanel3.add(ikanBosPanel, "card4");

        tahapBosPanel.setBackground(new java.awt.Color(255, 255, 255));
        tahapBosPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Tahap Budidaya");
        tahapBosPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

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
        jScrollPane3.setViewportView(tabel_tahap);

        tahapBosPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 690, 300));

        jPanel3.add(tahapBosPanel, "card5");

        analisisBosPanel.setBackground(new java.awt.Color(255, 255, 255));
        analisisBosPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Hasil Analisis");
        analisisBosPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        tabel_analisis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tabel_analisis);

        analisisBosPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 660, 280));

        jPanel3.add(analisisBosPanel, "card6");

        penggunaBosPanel.setBackground(new java.awt.Color(255, 255, 255));
        penggunaBosPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Daftar Pengguna");
        penggunaBosPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        tabel_pengguna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabel_pengguna.setGridColor(new java.awt.Color(51, 153, 255));
        tabel_pengguna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_penggunaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabel_pengguna);

        penggunaBosPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 680, 300));

        tambah_pengguna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_add_16px.png"))); // NOI18N
        tambah_pengguna.setText("    Tambah Pengguna");
        tambah_pengguna.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tambah_pengguna.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tambah_pengguna.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        tambah_pengguna.setIconTextGap(10);
        tambah_pengguna.setkEndColor(new java.awt.Color(0, 255, 102));
        tambah_pengguna.setkHoverEndColor(new java.awt.Color(0, 204, 51));
        tambah_pengguna.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        tambah_pengguna.setkHoverStartColor(new java.awt.Color(0, 204, 102));
        tambah_pengguna.setkSelectedColor(new java.awt.Color(0, 102, 102));
        tambah_pengguna.setkStartColor(new java.awt.Color(0, 204, 102));
        tambah_pengguna.setMargin(new java.awt.Insets(2, 20, 2, 10));
        tambah_pengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_penggunaActionPerformed(evt);
            }
        });
        penggunaBosPanel.add(tambah_pengguna, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 180, -1));

        ubah_pengguna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_pencil_16px.png"))); // NOI18N
        ubah_pengguna.setText("    Ubah Pengguna");
        ubah_pengguna.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ubah_pengguna.setIconTextGap(10);
        ubah_pengguna.setkBackGroundColor(new java.awt.Color(51, 153, 255));
        ubah_pengguna.setkEndColor(new java.awt.Color(51, 153, 255));
        ubah_pengguna.setkHoverEndColor(new java.awt.Color(153, 204, 255));
        ubah_pengguna.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        ubah_pengguna.setkHoverStartColor(new java.awt.Color(0, 153, 204));
        ubah_pengguna.setkSelectedColor(new java.awt.Color(0, 204, 255));
        ubah_pengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubah_penggunaActionPerformed(evt);
            }
        });
        penggunaBosPanel.add(ubah_pengguna, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 160, -1));

        Id_field.setToolTipText("Nama Lengkap");
        Id_field.setEnabled(false);
        penggunaBosPanel.add(Id_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 60, 30));

        username.setToolTipText("Nama Pengguna");
        penggunaBosPanel.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 160, 30));

        pass.setText("jPasswordField1");
        pass.setEnabled(false);
        penggunaBosPanel.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 130, 30));

        penggunaBosPanel.add(level_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 90, 30));

        nama_label.setText("Level Pengguna");
        penggunaBosPanel.add(nama_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, -1, -1));

        nama_label1.setText("ID");
        penggunaBosPanel.add(nama_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        nama_label2.setText("Nama Pengguna");
        penggunaBosPanel.add(nama_label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        nama_label3.setText("Kata Sandi");
        penggunaBosPanel.add(nama_label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        ubah_password.setText("Ubah Password");
        ubah_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubah_passwordActionPerformed(evt);
            }
        });
        penggunaBosPanel.add(ubah_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, -1, -1));

        nama_lengkap.setToolTipText("Nama Lengkap");
        penggunaBosPanel.add(nama_lengkap, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 180, 30));

        nama_label4.setText("Nama Lengkap");
        penggunaBosPanel.add(nama_label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jPanel3.add(penggunaBosPanel, "card7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(784, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 770, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 200, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(486, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        masuk masuk = new masuk();
        masuk.setVisible(true);
        dispose();
    }//GEN-LAST:event_kButton1ActionPerformed

    private void menuKolamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKolamActionPerformed
        // TODO add your handling code here:
        dashboardBosPanel.setVisible(false);
        kolamBosPanel.setVisible(true);
        ikanBosPanel.setVisible(false);
        tahapBosPanel.setVisible(false);
        analisisBosPanel.setVisible(false);
        penggunaBosPanel.setVisible(false);
    }//GEN-LAST:event_menuKolamActionPerformed

    private void menuIkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIkanActionPerformed
        // TODO add your handling code here:
        dashboardBosPanel.setVisible(false);
        kolamBosPanel.setVisible(false);
        ikanBosPanel.setVisible(true);
        tahapBosPanel.setVisible(false);
        analisisBosPanel.setVisible(false);
        penggunaBosPanel.setVisible(false);
    }//GEN-LAST:event_menuIkanActionPerformed

    private void menuAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAnalisisActionPerformed
        // TODO add your handling code here:
        dashboardBosPanel.setVisible(false);
        kolamBosPanel.setVisible(false);
        ikanBosPanel.setVisible(false);
        tahapBosPanel.setVisible(false);
        analisisBosPanel.setVisible(true);
        penggunaBosPanel.setVisible(false);
    }//GEN-LAST:event_menuAnalisisActionPerformed

    private void menuTahapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTahapActionPerformed
        // TODO add your handling code here:
        dashboardBosPanel.setVisible(false);
        kolamBosPanel.setVisible(false);
        ikanBosPanel.setVisible(false);
        tahapBosPanel.setVisible(true);
        analisisBosPanel.setVisible(false);
        penggunaBosPanel.setVisible(false);
    }//GEN-LAST:event_menuTahapActionPerformed

    private void menuPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPenggunaActionPerformed
        // TODO add your handling code here:
        dashboardBosPanel.setVisible(false);
        kolamBosPanel.setVisible(false);
        ikanBosPanel.setVisible(false);
        tahapBosPanel.setVisible(false);
        analisisBosPanel.setVisible(false);
        penggunaBosPanel.setVisible(true);
    }//GEN-LAST:event_menuPenggunaActionPerformed

    private void menuDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDashboardActionPerformed
        // TODO add your handling code here:
        dashboardBosPanel.setVisible(true);
        kolamBosPanel.setVisible(false);
        ikanBosPanel.setVisible(false);
        tahapBosPanel.setVisible(false);
        analisisBosPanel.setVisible(false);
        penggunaBosPanel.setVisible(false);
    }//GEN-LAST:event_menuDashboardActionPerformed

    private void tabel_kolamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_kolamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabel_kolamMouseClicked

    private void tabel_ikanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_ikanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabel_ikanMouseClicked

    private void tabel_tahapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_tahapMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tabel_tahapMouseClicked

    private void tabel_penggunaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_penggunaMouseClicked
        tambah_pengguna.setEnabled(false);
        tambah_pengguna.setSelected(true);
        int baris = tabel_pengguna.rowAtPoint(evt.getPoint());
        List<m_user> listUser = user.getUserByID(tabel_pengguna.getModel().getValueAt(baris, 0).toString());
        for (m_user u : listUser) {
            Id_field.setText(u.getId());
            nama_lengkap.setText(u.getNama());
            username.setText(u.getUsername());
            pass.setText(u.getPassword());
            level_user.getModel().setSelectedItem(u.getLevel().getLevel());
            username.setEnabled(false);

        }

    }//GEN-LAST:event_tabel_penggunaMouseClicked

    private void tambah_penggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_penggunaActionPerformed
        // TODO add your handling code here:
        String id_user = null;
        String nama_peng = username.getText();
        String nama = nama_lengkap.getText();
        String pwd = pass.getText();
        m_level lvl = (m_level) level_user.getSelectedItem();
        m_user u = new m_user(id_user, nama_peng, nama, lvl, pwd);
        user.manipulate(u,CrudState.INSERT);
    }//GEN-LAST:event_tambah_penggunaActionPerformed

    private void ubah_penggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubah_penggunaActionPerformed
        tambah_pengguna.setEnabled(true);
        ubah_pengguna.setSelected(false);
        String id_user = Id_field.getText();
        String nama_peng = username.getText();
        String nama = nama_lengkap.getText();
        String pwd = pass.getText();
        m_level lvl = (m_level) level_user.getSelectedItem();
        m_user u = new m_user(id_user, nama_peng, nama, lvl, pwd);
        user.manipulate(u,CrudState.UPDATE);

    }//GEN-LAST:event_ubah_penggunaActionPerformed

    private void ubah_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubah_passwordActionPerformed
        // TODO add your handling code here:
        if(ubah_password.isSelected()){
            pass.setEnabled(true);
        }else{
            pass.setEnabled(false);
        }

    }//GEN-LAST:event_ubah_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(Bos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Id_field;
    private javax.swing.JPanel analisisBosPanel;
    private javax.swing.JPanel dashboardBosPanel;
    private javax.swing.JPanel ikanBosPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jmlIkan1;
    private javax.swing.JLabel jmlKlm1;
    private keeptoo.KButton kButton1;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private javax.swing.JPanel kolamBosPanel;
    private javax.swing.JComboBox<String> level_user;
    private keeptoo.KButton menuAnalisis;
    private keeptoo.KButton menuDashboard;
    private keeptoo.KButton menuIkan;
    private keeptoo.KButton menuKolam;
    private keeptoo.KButton menuPengguna;
    private keeptoo.KButton menuTahap;
    private javax.swing.JLabel namaSapaan1;
    private javax.swing.JLabel nama_label;
    private javax.swing.JLabel nama_label1;
    private javax.swing.JLabel nama_label2;
    private javax.swing.JLabel nama_label3;
    private javax.swing.JLabel nama_label4;
    private javax.swing.JTextField nama_lengkap;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPanel penggunaBosPanel;
    private javax.swing.JTable tabel_analisis;
    private javax.swing.JTable tabel_ikan;
    private javax.swing.JTable tabel_kolam;
    private javax.swing.JTable tabel_pengguna;
    private javax.swing.JTable tabel_tahap;
    private javax.swing.JPanel tahapBosPanel;
    private keeptoo.KButton tambah_pengguna;
    private javax.swing.JLabel totalAnalisis1;
    private javax.swing.JCheckBox ubah_password;
    private keeptoo.KButton ubah_pengguna;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
