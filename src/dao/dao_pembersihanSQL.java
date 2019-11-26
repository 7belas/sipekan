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
import model.m_pembersihan;



public class dao_pembersihanSQL implements dao_pembersihan {

    @Override
    public boolean insert(m_pembersihan pembersihan) {
       String sql = "INSERT INTO pembersihan values (?, ?)";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            statement.setString(1, pembersihan.getKolam().getId());
            statement.setString(2, pembersihan.getDeskripsi());
            
            
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
    public boolean update(m_pembersihan pembersihan) {
        String sql = "UPDATE pembersihan SET id_kolam=? , deskripsi=? WHERE id_pembersihan=?";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            statement.setString(1, pembersihan.getKolam().getId());
            statement.setString(2, pembersihan.getDeskripsi());
            statement.setString(3, pembersihan.getId());
            
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
    public boolean delete(m_pembersihan pembersihan) {
        String sql = "DELETE FROM pembersihan WHERE id_pembersihan=?";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            statement.setString(1, pembersihan.getId());
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
    public List<m_pembersihan> getAllPembersihan() {
        List<m_pembersihan> kolams = new ArrayList<m_pembersihan>();
        String sql = "SELECT * FROM pembersihan p join kolam k ON p.id_kolam = p.id_kolam";
        try {
            if (koneksi.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    m_pembersihan k = new m_pembersihan(
                            rs.getString(1),
                            new m_kolam(rs.getString(7),rs.getString(8)),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getInt(6)
                            
                    );
                    kolams.add(k);
                }
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(m_pembersihan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kolams;
    }

    @Override
    public m_pembersihan getByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<m_pembersihan> getByDeskripsi(String deskripsi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJml() {
        String jml = null;
        String sql = "SELECT COUNT(*) as jml_pembersihan FROM pembersihan p join kolam k ON p.id_kolam = k.id_kolam";
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
