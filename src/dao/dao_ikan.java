/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.m_ikan;


public interface dao_ikan {
    public boolean insert(m_ikan ikan);
    
    public boolean update(m_ikan ikan);
    
    public boolean delete(m_ikan ikan);
    
    public List<m_ikan> getAllIkan();
    
    public m_ikan getByID(String id);
    
    public List<m_ikan> getByName(String name);
    public String getJml();
}
