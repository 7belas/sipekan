/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.m_tahap;

public interface dao_tahapIkan {
    public boolean insert(m_tahap tahap);
    
    public boolean update(m_tahap tahap);
    
    public boolean delete(m_tahap tahap);
    
    public List<m_tahap> getAllTahap();
    
    public m_tahap getByID(String id);
    
    public List<m_tahap> getByName(String name);
}
