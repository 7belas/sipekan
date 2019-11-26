/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.m_pembersihan;


public interface dao_pembersihan {
    public boolean insert(m_pembersihan pembersihan);
    
    public boolean update(m_pembersihan pembersihan);
    
    public boolean delete(m_pembersihan pembersihan);
    
    public List<m_pembersihan> getAllPembersihan();
    
    public m_pembersihan getByID(String id);
    
    public List<m_pembersihan> getByDeskripsi(String Deskripsi);
    
    public String getJml();
}
