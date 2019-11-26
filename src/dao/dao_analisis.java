/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.m_analisis;


public interface dao_analisis {
    public boolean insert(m_analisis analisis);
    
    public List<m_analisis> getAllAnalisis();
    
    public m_analisis getByID(String id);
    
    public List<m_analisis> getByName(String name);
    public String getJml();
}
