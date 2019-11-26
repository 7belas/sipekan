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
import model.m_ikan;
import model.m_tahap;


public class dao_ikanSQL implements dao_ikan {

    @Override
    public boolean insert(m_ikan ikan) {
        String sql = "INSERT INTO ikan values (null, ?, ?, ?,?)";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            statement.setString(1, ikan.getTahap().getId());
            statement.setString(2, ikan.getNamaIkan());
            statement.setInt(3, ikan.getPh());
            statement.setInt(4, ikan.getSuhu());
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(m_ikan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(m_ikan ikan) {
        String sql = "UPDATE ikan SET id_tahap_ikan=? , nama_ikan=?, ph_ikan=?,suhu_ikan=? WHERE id_ikan=?";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            statement.setString(1, ikan.getTahap().getId());
            statement.setString(2, ikan.getNamaIkan());
            statement.setInt(3, ikan.getPh());
            statement.setInt(4, ikan.getSuhu());
            statement.setString(5, ikan.getId());
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(m_ikan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(m_ikan ikan) {
    String sql = "DELETE FROM ikan WHERE id_ikan=?";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            statement.setString(1, ikan.getId());
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(m_ikan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;    
    }

    @Override
    public List<m_ikan> getAllIkan() {
        List<m_ikan> ikans = new ArrayList<m_ikan>();
        String sql = "SELECT * FROM ikan i join tahap t ON i.id_tahap_ikan = t.id_tahap";
        try {
            if (koneksi.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    m_ikan k = new m_ikan(
                            rs.getString(1),
                            new m_tahap(rs.getString(6),rs.getString(7)),
                            rs.getString(3),
                            rs.getInt(5),
                            rs.getInt(4)
                            
                    );
                    ikans.add(k);
                }
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(m_ikan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ikans;
    }

    @Override
    public m_ikan getByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<m_ikan> getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getJml() {
        String jml = null;
        String sql = "SELECT COUNT(*) as jml FROM ikan";
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
            Logger.getLogger(m_ikan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jml;
    }
    
}
