/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.dao_tahapIkan;
import dao.dao_tahapIkanSQL;
import java.util.List;
import java.util.Observable;
import model.CrudState;
import model.m_tahap;


public class c_tahap extends Observable {
  private dao_tahapIkan dao = new dao_tahapIkanSQL();
    private CrudState crudState;
    
    public void setDAO(dao_tahapIkan d){
        dao = d;
    }
    
    public void manipulate(m_tahap t, CrudState c){
        boolean result = false;
        this.crudState = c;
        
        switch (c){
            case INSERT:
                result = dao.insert(t);
                break;
            case UPDATE:
                result = dao.update(t);
                break;
            case DELETE:
                result = dao.delete(t);
                break;
        }
        
        setChanged();
        if (result){
            notifyObservers(t);
        }else{
            notifyObservers();
        }
    }
    
    public CrudState getCrudState(){
        return crudState;
    }
    
    public List<m_tahap> getAllTahap() {
        return dao.getAllTahap();
    }  
}
