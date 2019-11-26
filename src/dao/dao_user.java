/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.m_user;


public interface dao_user {
    public boolean insert(m_user user);
    
    public boolean update(m_user user);
    
    public boolean delete(m_user user);
    
    public boolean cek_username(String username);
    
    public List<m_user> getAllUser();
    
    public List<m_user> getByID(String id);
    
    public String getByUsernamePassword(String username,String password);
}