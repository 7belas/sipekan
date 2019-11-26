/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.dao_kolam;
import dao.dao_kolamSQL;
import java.util.List;
import java.util.Observable;
import model.CrudState;
import model.m_kolam;


public class c_kolam extends Observable {
    private dao_kolam dao = new dao_kolamSQL();
    private CrudState crudState;
    
    public void setDAO(dao_kolam d){
        dao = d;
    }
    
    public void manipulate(m_kolam k, CrudState c){
        boolean result = false;
        this.crudState = c;
        
        switch (c){
            case INSERT:
                result = dao.insert(k);
                break;
            case UPDATE:
                result = dao.update(k);
                break;
            case DELETE:
                result = dao.delete(k);
                break;
        }
        
        setChanged();
        if (result){
            notifyObservers(k);
        }else{
            notifyObservers();
        }
    }
    
    public CrudState getCrudState(){
        return crudState;
    }
    
    public List<m_kolam> getAllKolam() {
        return dao.getAllKolam();
    }
    public String getJml(){
        return dao.getJml();
    }
}
