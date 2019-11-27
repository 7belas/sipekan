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

public class Pembenihan extends javax.swing.JFrame implements Observer {

    c_kolam kolam = new c_kolam();
    c_tahap tahap = new c_tahap();
    c_ikan ikan = new c_ikan();
    c_analisis analyzer = new c_analisis();
    c_level level = new c_level();
    c_user user = new c_user();
    
    
    
    public Pembenihan() {
        initComponents();
        jmlKlm1.setText(kolam.getJml());
        jmlIkan1.setText(ikan.getJml());
        totalAnalisis1.setText(analyzer.getJml());
        namaSapaan1.setText(user_session.getNama());
        setTabelKolam(kolam.getAllKolam());
        setTabelIkan(ikan.getAllIkan());
        setTabelTahap(tahap.getAllTahap());
        setTabelAnalisis(analyzer.getAllAnalisis());
        setTahap(tahap.getAllTahap());
        setIkan(ikan.getAllIkan());
        setKolam(kolam.getAllKolam());
        kolam.addObserver(this);
        tahap.addObserver(this);
        ikan.addObserver(this);
        analyzer.addObserver(this);
    }
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
                } else if (kolam.getCrudState() == CrudState.DELETE) {
                    JOptionPane.showMessageDialog(this, u.getNamaKolam() + " berhasil dihapus");
                    resetForm();
                setTabelKolam(kolam.getAllKolam());
            }
        }
        }
        
        else if (o == ikan) {
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
        
        else if (o == tahap) {
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
        
        else if (o == analyzer) {
            if (arg == null) {
                JOptionPane.showMessageDialog(this, "Pengguna gagal diperbaharui karena kegagalan koneksi ke database");
            } else {
                m_analisis a = (m_analisis) arg;
                if (analyzer.getCrudState() == CrudState.INSERT) {
                    JOptionPane.showMessageDialog(this, "Hasil Analisis "+ a.getHasil() + " berhasil ditambahkan");
                }
                setTabelAnalisis(analyzer.getAllAnalisis());
            }
        }
        
    }
     private void resetForm(){
        id_kolam.setText("");
        nama_kolam.setText("");
        volume_kolam.setText("");
        suhu_kolam.setText("");
        ph_kolam.setText("");
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
    
    public void setTahap(List<m_tahap> listTahap) {
        if (listTahap == null) {
            JOptionPane.showMessageDialog(this, "Data Level gagal diambil dari database", "DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        } else {
            tahap_kolam.setModel(new DefaultComboBoxModel(listTahap.toArray()));
            tahap_ikan.setModel(new DefaultComboBoxModel(listTahap.toArray()));
        }
    }
        public void setIkan(List<m_ikan> listIkan) {
        if (listIkan == null) {
            JOptionPane.showMessageDialog(this, "Data Level gagal diambil dari database", "DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        } else {
            jenis_ikan.setModel(new DefaultComboBoxModel(listIkan.toArray()));
            jenis_ikan1.setModel(new DefaultComboBoxModel(listIkan.toArray()));
        }
    }
        
        public void setKolam(List<m_kolam> listKolam) {
        if (listKolam == null) {
            JOptionPane.showMessageDialog(this, "Data Level gagal diambil dari database", "DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        } else {
            pilih_kolam.setModel(new DefaultComboBoxModel(listKolam.toArray()));
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
        dashboardPanel = new javax.swing.JPanel();
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
        kolamPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tambah_kolam = new keeptoo.KButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_kolam = new javax.swing.JTable();
        ubah_kolam = new keeptoo.KButton();
        hapus = new keeptoo.KButton();
        id_kolam = new javax.swing.JTextField();
        nama_kolam = new javax.swing.JTextField();
        volume_kolam = new javax.swing.JTextField();
        suhu_kolam = new javax.swing.JTextField();
        ph_kolam = new javax.swing.JTextField();
        tahap_kolam = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jenis_ikan = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        ikanPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        tambah_ikan = new keeptoo.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_ikan = new javax.swing.JTable();
        ubah_ikan = new keeptoo.KButton();
        hapus1 = new keeptoo.KButton();
        jLabel15 = new javax.swing.JLabel();
        id_ikan = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        nama_ikan = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        suhu_ikan = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        ph_ikan = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tahap_ikan = new javax.swing.JComboBox<>();
        tahapPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_tahap = new javax.swing.JTable();
        tambah_tahap = new keeptoo.KButton();
        ubah_tahap = new keeptoo.KButton();
        hapus2 = new keeptoo.KButton();
        id_tahap = new javax.swing.JTextField();
        nama_tahap = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        analisisPanel = new javax.swing.JPanel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        pilih_kolam = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jenis_ikan1 = new javax.swing.JComboBox<>();
        btnAnalisis = new keeptoo.KButton();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabel_analisis = new javax.swing.JTable();

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

        dashboardPanel.setBackground(new java.awt.Color(255, 255, 255));
        dashboardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        dashboardPanel.add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 220, 90));

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

        dashboardPanel.add(kGradientPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 220, 90));

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

        dashboardPanel.add(kGradientPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 220, 90));

        namaSapaan1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        namaSapaan1.setText("Guys");
        dashboardPanel.add(namaSapaan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Hai ,");
        dashboardPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jPanel3.add(dashboardPanel, "card2");

        kolamPanel.setBackground(new java.awt.Color(255, 255, 255));
        kolamPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_fish_16px.png"))); // NOI18N
        jLabel3.setText("Kolam Ikan");
        kolamPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        tambah_kolam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_add_16px.png"))); // NOI18N
        tambah_kolam.setText("    Tambah Kolam");
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
        kolamPanel.add(tambah_kolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 150, -1));

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

        kolamPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 690, 290));

        ubah_kolam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_pencil_16px.png"))); // NOI18N
        ubah_kolam.setText("    Ubah Kolam");
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
        kolamPanel.add(ubah_kolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 140, -1));

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
        kolamPanel.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 90, -1));

        id_kolam.setEnabled(false);
        kolamPanel.add(id_kolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 60, 30));
        kolamPanel.add(nama_kolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 180, 30));

        volume_kolam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volume_kolamActionPerformed(evt);
            }
        });
        kolamPanel.add(volume_kolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 40, 30));
        kolamPanel.add(suhu_kolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 40, 30));
        kolamPanel.add(ph_kolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 40, 30));

        tahap_kolam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        kolamPanel.add(tahap_kolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 120, 30));

        jLabel2.setText("Tahap Kolam");
        kolamPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, -1));

        jLabel4.setText("Id Kolam");
        kolamPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel6.setText("Nama Kolam");
        kolamPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel8.setText("Volume");
        kolamPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        jLabel11.setText("Suhu");
        kolamPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        jLabel12.setText("Ph");
        kolamPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        jenis_ikan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        kolamPanel.add(jenis_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 120, 30));

        jLabel13.setText("Nama Ikan");
        kolamPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        jPanel3.add(kolamPanel, "card3");

        ikanPanel.setBackground(new java.awt.Color(255, 255, 255));
        ikanPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_fish_16px.png"))); // NOI18N
        jLabel14.setText("Ikan");
        ikanPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

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
        ikanPanel.add(tambah_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 140, -1));

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

        ikanPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 700, 290));

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
        ikanPanel.add(ubah_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 130, -1));

        hapus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_delete_16px.png"))); // NOI18N
        hapus1.setText("     Hapus");
        hapus1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hapus1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hapus1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        hapus1.setIconTextGap(10);
        hapus1.setkEndColor(new java.awt.Color(255, 51, 153));
        hapus1.setkHoverEndColor(new java.awt.Color(255, 0, 0));
        hapus1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        hapus1.setkHoverStartColor(new java.awt.Color(255, 0, 51));
        hapus1.setkStartColor(new java.awt.Color(255, 0, 51));
        hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus1ActionPerformed(evt);
            }
        });
        ikanPanel.add(hapus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 90, -1));

        jLabel15.setText("Id Ikan");
        ikanPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        id_ikan.setEnabled(false);
        ikanPanel.add(id_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 60, 30));

        jLabel16.setText("Nama Ikan");
        ikanPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));
        ikanPanel.add(nama_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 300, 30));

        jLabel17.setText("Suhu");
        ikanPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));
        ikanPanel.add(suhu_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 40, 30));

        jLabel18.setText("Ph");
        ikanPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));
        ikanPanel.add(ph_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 40, 30));

        jLabel19.setText("Tahap Ikan");
        ikanPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, -1));

        tahap_ikan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ikanPanel.add(tahap_ikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 160, 30));

        jPanel3.add(ikanPanel, "card4");

        tahapPanel.setBackground(new java.awt.Color(255, 255, 255));
        tahapPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Tahap Budidaya");
        tahapPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

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

        tahapPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 690, 300));

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
        tahapPanel.add(tambah_tahap, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 150, -1));

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
        tahapPanel.add(ubah_tahap, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 140, -1));

        hapus2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_delete_16px.png"))); // NOI18N
        hapus2.setText("     Hapus");
        hapus2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hapus2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hapus2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        hapus2.setIconTextGap(10);
        hapus2.setkEndColor(new java.awt.Color(255, 51, 153));
        hapus2.setkHoverEndColor(new java.awt.Color(255, 0, 0));
        hapus2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        hapus2.setkHoverStartColor(new java.awt.Color(255, 0, 51));
        hapus2.setkStartColor(new java.awt.Color(255, 0, 51));
        hapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus2ActionPerformed(evt);
            }
        });
        tahapPanel.add(hapus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 90, -1));

        id_tahap.setEnabled(false);
        id_tahap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_tahapActionPerformed(evt);
            }
        });
        tahapPanel.add(id_tahap, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 50, 30));

        nama_tahap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_tahapActionPerformed(evt);
            }
        });
        tahapPanel.add(nama_tahap, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 180, 30));

        jLabel21.setText("Nama Tahap");
        tahapPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, -1, -1));

        jLabel22.setText("Id Tahap");
        tahapPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        jPanel3.add(tahapPanel, "card5");

        analisisPanel.setBackground(new java.awt.Color(255, 255, 255));
        analisisPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel3.setkBorderRadius(15);
        kGradientPanel3.setkEndColor(new java.awt.Color(255, 153, 0));
        kGradientPanel3.setkGradientFocus(400);
        kGradientPanel3.setkStartColor(new java.awt.Color(255, 102, 204));
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel3.add(pilih_kolam, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 160, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Jenis Ikan");
        kGradientPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Pilih Kolam");
        kGradientPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jenis_ikan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Ikan" }));
        kGradientPanel3.add(jenis_ikan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 160, -1));

        btnAnalisis.setText("Analisis");
        btnAnalisis.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisisActionPerformed(evt);
            }
        });
        kGradientPanel3.add(btnAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 110, -1));

        analisisPanel.add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 660, 180));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Analisis Kolam");
        analisisPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        tabel_analisis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tabel_analisis);

        analisisPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 660, 280));

        jPanel3.add(analisisPanel, "card6");

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
        dashboardPanel.setVisible(false);
        kolamPanel.setVisible(true);
        ikanPanel.setVisible(false);
        tahapPanel.setVisible(false);
        analisisPanel.setVisible(false);
    }//GEN-LAST:event_menuKolamActionPerformed

    private void menuIkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIkanActionPerformed
        // TODO add your handling code here:
        dashboardPanel.setVisible(false);
        kolamPanel.setVisible(false);
        ikanPanel.setVisible(true);
        tahapPanel.setVisible(false);
        analisisPanel.setVisible(false);
    }//GEN-LAST:event_menuIkanActionPerformed

    private void menuAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAnalisisActionPerformed
        // TODO add your handling code here:
        dashboardPanel.setVisible(false);
        kolamPanel.setVisible(false);
        ikanPanel.setVisible(false);
        tahapPanel.setVisible(false);
        analisisPanel.setVisible(true);
    }//GEN-LAST:event_menuAnalisisActionPerformed

    private void menuTahapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTahapActionPerformed
        // TODO add your handling code here:
        dashboardPanel.setVisible(false);
        kolamPanel.setVisible(false);
        ikanPanel.setVisible(false);
        tahapPanel.setVisible(true);
        analisisPanel.setVisible(false);
    }//GEN-LAST:event_menuTahapActionPerformed

    private void menuPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPenggunaActionPerformed
        // TODO add your handling code here:
        Pengguna user = new Pengguna();
        user.setVisible(true);
    }//GEN-LAST:event_menuPenggunaActionPerformed

    private void menuDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDashboardActionPerformed
        // TODO add your handling code here:
        dashboardPanel.setVisible(true);
        kolamPanel.setVisible(false);
        ikanPanel.setVisible(false);
        tahapPanel.setVisible(false);
        analisisPanel.setVisible(false);
    }//GEN-LAST:event_menuDashboardActionPerformed

    private void tambah_kolamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_kolamActionPerformed
        // TODO add your handling code here:

        String id = null;
        String nama = nama_kolam.getText();
        int volume = Integer.parseInt(volume_kolam.getText());
        int suhu = Integer.parseInt(suhu_kolam.getText());
        int ph = Integer.parseInt(ph_kolam.getText());
        m_ikan ikan = (m_ikan) jenis_ikan.getSelectedItem();
        m_tahap tahap = (m_tahap) tahap_kolam.getSelectedItem();
        System.out.println(tahap_kolam.getSelectedItem().getClass().getName());
        System.out.println(jenis_ikan.getSelectedItem().getClass().getName());
        m_kolam k = new m_kolam(id, ikan, tahap, nama, volume, suhu, ph);
        kolam.manipulate(k, CrudState.INSERT);
    }//GEN-LAST:event_tambah_kolamActionPerformed

    private void tabel_kolamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_kolamMouseClicked
        // TODO add your handling code here:
        tambah_kolam.setEnabled(false);
        tambah_kolam.setSelected(true);
        int baris = tabel_kolam.rowAtPoint(evt.getPoint());
        id_kolam.setText(tabel_kolam.getModel().getValueAt(baris, 1).toString());
        nama_kolam.setText(tabel_kolam.getModel().getValueAt(baris, 2).toString());
        volume_kolam.setText(tabel_kolam.getModel().getValueAt(baris, 5).toString());
        suhu_kolam.setText(tabel_kolam.getModel().getValueAt(baris, 6).toString());
        ph_kolam.setText(tabel_kolam.getModel().getValueAt(baris, 7).toString());
        m_level l = new m_level(tabel_kolam.getModel().getValueAt(baris, 3).toString(),tabel_kolam.getModel().getValueAt(baris, 3).toString());
        m_ikan i = new m_ikan(tabel_kolam.getModel().getValueAt(baris, 4).toString(),tabel_kolam.getModel().getValueAt(baris, 4).toString());
        tahap_kolam.getModel().setSelectedItem(l);
        jenis_ikan.getModel().setSelectedItem(i);
    }//GEN-LAST:event_tabel_kolamMouseClicked

    private void ubah_kolamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubah_kolamActionPerformed
        // TODO add your handling code here:
        String id = id_kolam.getText();
        String nama = nama_kolam.getText();
        int volume = Integer.parseInt(volume_kolam.getText());
        int suhu = Integer.parseInt(suhu_kolam.getText());
        int ph = Integer.parseInt(ph_kolam.getText());
        m_ikan ikan = (m_ikan) jenis_ikan.getSelectedItem();
        m_tahap tahap = (m_tahap) tahap_kolam.getSelectedItem();
        System.out.println(tahap_kolam.getSelectedItem().getClass().getName());
        System.out.println(jenis_ikan.getSelectedItem().getClass().getName());
        m_kolam k = new m_kolam(id, ikan,tahap, nama, volume, suhu, ph);
        kolam.manipulate(k, CrudState.UPDATE);
    }//GEN-LAST:event_ubah_kolamActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        String id = id_kolam.getText();
        String nama = nama_kolam.getText();
        m_kolam k = new m_kolam(id, nama);
        kolam.manipulate(k, CrudState.DELETE);
    }//GEN-LAST:event_hapusActionPerformed

    private void volume_kolamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volume_kolamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_volume_kolamActionPerformed

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

    private void hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus1ActionPerformed
        // TODO add your handling code here:
        String id = id_ikan.getText();
        String nama = nama_ikan.getText();

        m_ikan k = new m_ikan(id, nama);

        ikan.manipulate(k, CrudState.DELETE);
    }//GEN-LAST:event_hapus1ActionPerformed

    private void tabel_tahapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_tahapMouseClicked
        // TODO add your handling code here:
        tambah_tahap.setEnabled(false);
        tambah_tahap.setSelected(true);
        int baris = tabel_tahap.rowAtPoint(evt.getPoint());
        id_tahap.setText(tabel_tahap.getModel().getValueAt(baris, 1).toString());
        nama_tahap.setText(tabel_tahap.getModel().getValueAt(baris, 2).toString());

    }//GEN-LAST:event_tabel_tahapMouseClicked

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

    private void hapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus2ActionPerformed
        // TODO add your handling code here:
        String idTahap = id_tahap.getText();
        String namaTahap = nama_tahap.getText();

        m_tahap thp = new m_tahap(idTahap,namaTahap);
        tahap.manipulate(thp, CrudState.DELETE);
        tambah_tahap.setEnabled(true);
        tambah_tahap.setSelected(false);
    }//GEN-LAST:event_hapus2ActionPerformed

    private void id_tahapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_tahapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_tahapActionPerformed

    private void nama_tahapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_tahapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_tahapActionPerformed

    private void btnAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisActionPerformed
        // TODO add your handling code here:
        m_ikan ikn = (m_ikan) jenis_ikan.getSelectedItem();
        m_kolam klm = (m_kolam) pilih_kolam.getSelectedItem();
        String hasil = analyzer.hasil_analisis(ikn, klm);
        m_user usr = new m_user(user_session.getId(),user_session.getNama(),user_session.getUsername(),user_session.getLevel(),user_session.getPassword());
        m_analisis an = new m_analisis(null,hasil,null,usr,klm,ikn);
        analyzer.manipulate(an, CrudState.INSERT);
    }//GEN-LAST:event_btnAnalisisActionPerformed

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
            java.util.logging.Logger.getLogger(Pembenihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembenihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembenihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembenihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembenihan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel analisisPanel;
    private keeptoo.KButton btnAnalisis;
    private javax.swing.JPanel dashboardPanel;
    private keeptoo.KButton hapus;
    private keeptoo.KButton hapus1;
    private keeptoo.KButton hapus2;
    private javax.swing.JTextField id_ikan;
    private javax.swing.JTextField id_kolam;
    private javax.swing.JTextField id_tahap;
    private javax.swing.JPanel ikanPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> jenis_ikan;
    private javax.swing.JComboBox<String> jenis_ikan1;
    private javax.swing.JLabel jmlIkan1;
    private javax.swing.JLabel jmlKlm1;
    private keeptoo.KButton kButton1;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private javax.swing.JPanel kolamPanel;
    private keeptoo.KButton menuAnalisis;
    private keeptoo.KButton menuDashboard;
    private keeptoo.KButton menuIkan;
    private keeptoo.KButton menuKolam;
    private keeptoo.KButton menuPengguna;
    private keeptoo.KButton menuTahap;
    private javax.swing.JLabel namaSapaan1;
    private javax.swing.JTextField nama_ikan;
    private javax.swing.JTextField nama_kolam;
    private javax.swing.JTextField nama_tahap;
    private javax.swing.JTextField ph_ikan;
    private javax.swing.JTextField ph_kolam;
    private javax.swing.JComboBox<String> pilih_kolam;
    private javax.swing.JTextField suhu_ikan;
    private javax.swing.JTextField suhu_kolam;
    private javax.swing.JTable tabel_analisis;
    private javax.swing.JTable tabel_ikan;
    private javax.swing.JTable tabel_kolam;
    private javax.swing.JTable tabel_tahap;
    private javax.swing.JPanel tahapPanel;
    private javax.swing.JComboBox<String> tahap_ikan;
    private javax.swing.JComboBox<String> tahap_kolam;
    private keeptoo.KButton tambah_ikan;
    private keeptoo.KButton tambah_kolam;
    private keeptoo.KButton tambah_tahap;
    private javax.swing.JLabel totalAnalisis1;
    private keeptoo.KButton ubah_ikan;
    private keeptoo.KButton ubah_kolam;
    private keeptoo.KButton ubah_tahap;
    private javax.swing.JTextField volume_kolam;
    // End of variables declaration//GEN-END:variables
}
