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
import model.user_session;


public class dao_userSQL implements dao_user {

    @Override
    public boolean insert(m_user u) {
        String sql = "INSERT INTO user values (null, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);

            statement.setString(1, u.getNama());
            statement.setString(2, u.getUsername());
            statement.setString(3, u.getPassword());
            statement.setString(4, u.getLevel().getId());

            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(m_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(m_user u) {
        String sql = "UPDATE user SET nama_lengkap=? , password=? , id_level=?  WHERE id_user=?";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);

            statement.setString(1, u.getNama());
            statement.setString(2, u.getPassword());
            statement.setString(3, u.getLevel().getId());
            statement.setString(4, u.getId());

            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (Exception ex) {
            Logger.getLogger(m_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(m_user user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<m_user> getAllUser() {
        List<m_user> users = new ArrayList<m_user>();
        String sql = "SELECT * FROM user u JOIN level_user lu on u.id_level=lu.id_level";
        try {
            if (koneksi.getConnection() == null) {
                return null;
            } else {
                PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    m_user u = new m_user(
                            rs.getString(1),
                            rs.getString(3),
                            rs.getString(2),
                            new m_level(rs.getString(6), rs.getString(7))
                    );
                    users.add(u);
                }
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(m_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public List<m_user> getByID(String id) {
        List<m_user> users = new ArrayList<m_user>();
        String sql = "SELECT * FROM user u JOIN level_user lu on u.id_level=lu.id_level WHERE id_user=?";
        try {
            if (koneksi.getConnection() == null) {
                return null;
            } else {
                PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
                statement.setString(1, id);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    m_user u = new m_user(
                            rs.getString(1),
                            rs.getString(3),
                            rs.getString(2),
                            new m_level(rs.getString(6), rs.getString(7)),
                            rs.getString(4)
                    );
                    users.add(u);
                }
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(m_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public boolean cek_username(String username) {
        boolean status = true;
        String sql = "SELECT * FROM user WHERE username=?";
        try {
            PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            int jml_row = 0;
            while (rs.next()) {
                jml_row += 1;
            }
            if (jml_row > 0) {
                status = true;
            } else {
                status = false;
            }
            statement.close();

        } catch (Exception ex) {
            Logger.getLogger(m_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    @Override
    public String getByUsernamePassword(String username, String password) {
        String status = null;
        String u_uid = null, u_nama = null, u_username = null, u_pass = null;
        m_level lvl = null;
        String sql = "SELECT * FROM user u JOIN level_user lu on u.id_level=lu.id_level WHERE username=? AND password=?";
        try {
            if (koneksi.getConnection() == null) {
                return null;
            } else {
                PreparedStatement statement = koneksi.getConnection().prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    u_uid = rs.getString(1);
                    u_nama = rs.getString(2);
                    u_username = rs.getString(3);
                    u_pass = rs.getString(4);
                    lvl = new m_level(rs.getString(5), rs.getString(6));

                }
                rs.last();
                if (rs.getRow() == 1) {
                    user_session.setId(u_uid);
                    user_session.setNama(u_nama);
                    user_session.setLevel(lvl);
                    user_session.setPassword(u_pass);
                    user_session.setUsername(username);
                    status = "berhasil";
                } else {
                    status = "gagal";
                }

                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(m_user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

}
