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
import model.m_tahap;

public class dao_tahapIkanSQL implements dao_tahapIkan {

    @Override
    public boolean insert(m_tahap t) {
        String sql = "INSERT INTO tahap values (null,?)";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            statement.setString(1, t.getNamaTahap());

            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(m_tahap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(m_tahap t) {
        String sql = "UPDATE tahap SET nama_tahap=? WHERE id_tahap=?";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            statement.setString(1, t.getNamaTahap());
            statement.setString(2, t.getId());

            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(m_tahap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(m_tahap t) {
        String sql = "DELETE FROM tahap WHERE id_tahap=?";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            statement.setString(1, t.getId());

            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(m_tahap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<m_tahap> getAllTahap() {
        List<m_tahap> tahaps = new ArrayList<m_tahap>();
        String sql = "SELECT * FROM tahap";
        try {
            if (koneksi.getConnection() == null) {
                return null;
            } else {
                PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    m_tahap k = new m_tahap(
                            rs.getString(1),
                            rs.getString(2)
                    );
                    tahaps.add(k);
                }
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(m_tahap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tahaps;
    }

    @Override
    public m_tahap getByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<m_tahap> getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
