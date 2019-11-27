/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.m_kolam;
import model.m_level;
import model.m_tahap;
import model.m_ikan;


public class dao_kolamSQL implements dao_kolam {

    @Override
    public boolean insert(m_kolam kolam) {
       String sql = "INSERT INTO kolam values (null, ?, ?, ?, ?,?,?)";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            statement.setString(1, kolam.getIkan().getId());
            statement.setString(2, kolam.getTahap().getId());
            statement.setString(3, kolam.getNamaKolam());
            statement.setInt(4, kolam.getVolume());
            statement.setInt(5, kolam.getSuhu());
            statement.setInt(6, kolam.getPh());
            
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(m_kolam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(m_kolam kolam) {
        String sql = "UPDATE kolam SET id_ikan = ? , id_tahap_kolam=? , nama_kolam=?, volume_kolam=?, suhu_kolam=?, ph_kolam=? WHERE id_kolam=?";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            statement.setString(1, kolam.getIkan().getId());
            statement.setString(2, kolam.getTahap().getId());
            statement.setString(3, kolam.getNamaKolam());
            statement.setInt(4, kolam.getVolume());
            statement.setInt(5, kolam.getSuhu());
            statement.setInt(6, kolam.getPh());
            statement.setString(7, kolam.getId());
            
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(m_kolam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(m_kolam kolam) {
        String sql = "DELETE FROM kolam WHERE id_kolam=?";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            statement.setString(1, kolam.getId());
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(m_kolam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<m_kolam> getAllKolam() {
        List<m_kolam> kolams = new ArrayList<m_kolam>();
        String sql = "SELECT * FROM kolam JOIN tahap ON kolam.id_tahap_kolam = tahap.id_tahap JOIN ikan ON kolam.id_ikan = ikan.id_ikan";
        try {
            if (koneksi.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    m_kolam k = new m_kolam(
                            rs.getString(1),
                            new m_ikan (rs.getString(8),rs.getString(9)),
                            new m_tahap(rs.getString(10),rs.getString(12)),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6),
                            rs.getInt(7)
                            
                    );
                    kolams.add(k);
                }
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(m_kolam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kolams;
    }

    @Override
    public m_kolam getByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<m_kolam> getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJml() {
        String jml = null;
        String sql = "SELECT COUNT(*) as jml_kolam FROM kolam k join tahap t ON k.id_tahap_kolam = t.id_tahap";
        try {
            if (koneksi.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    jml = rs.getString(1);
                }
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(m_kolam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jml;
    }
    
}
