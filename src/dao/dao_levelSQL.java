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
import model.m_level;
import model.m_user;


public class dao_levelSQL implements dao_level {

    @Override
    public List<m_level> getAllLevel() {
        List<m_level> levels = new ArrayList<m_level>();
        String sql = "SELECT * FROM level_user";
        try {
            if (koneksi.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    m_level l = new m_level(
                            rs.getString(1),
                            rs.getString(2)     
                    );
                    levels.add(l);
                }
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(m_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return levels;
    }
    
}
