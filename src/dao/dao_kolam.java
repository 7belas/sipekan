/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.m_kolam;


public interface dao_kolam {
    public boolean insert(m_kolam kolam);
    
    public boolean update(m_kolam kolam);
    
    public boolean delete(m_kolam kolam);
    
    public List<m_kolam> getAllKolam();
    
    public m_kolam getByID(String id);
    
    public List<m_kolam> getByName(String name);
    
    public String getJml();
}
