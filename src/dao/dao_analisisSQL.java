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
import model.m_analisis;
import model.m_ikan;
import model.m_kolam;
import model.m_user;
import model.user_session;


public class dao_analisisSQL implements dao_analisis {

    @Override
    public boolean insert(m_analisis a) {
        String sql = "INSERT INTO hasil_analisis values (null, ?, null, ?, ?, ?)";
        try {
            
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            statement.setString(1, a.getHasil());
            statement.setString(2, a.getUser().getId());
            statement.setString(3, a.getKolam().getId());
            statement.setString(4, a.getIkan().getId());

            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(m_analisis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<m_analisis> getAllAnalisis() {
        List<m_analisis> analisiss = new ArrayList<m_analisis>();
        int id_level = Integer.parseInt(user_session.getLevel().getId());
        String id_user = user_session.getId();
        System.out.println(id_level);
        String sql = "SELECT * FROM hasil_analisis a JOIN user u on a.id_user = u.id_user JOIN kolam k on a.id_kolam = k.id_kolam JOIN ikan i on a.id_ikan = i.id_ikan";
        
        try {
            if (koneksi.getConnection() == null) {
                return null;
            } else {
                PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
                if(id_level == 2){
                    statement.setString(1, id_user);
                }
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    m_analisis k = new m_analisis(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            new m_user(rs.getString(7), rs.getString(8), rs.getString(9)),
                            new m_kolam(rs.getString(12), rs.getString(15)),
                            new m_ikan(rs.getString(19), rs.getString(21))
                    );
                    analisiss.add(k);
                }
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(m_analisis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return analisiss;
    }

    @Override
    public m_analisis getByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<m_analisis> getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String getJml() {
        String jml = null;
        String sql = "SELECT COUNT(*) as jml FROM hasil_analisis";
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
