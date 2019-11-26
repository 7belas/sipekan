/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.dao_pembersihan;
import dao.dao_pembersihanSQL;
import java.util.List;
import java.util.Observable;
import model.CrudState;
import model.m_kolam;
import model.m_pembersihan;


public class c_pembersihan extends Observable {
    private dao_pembersihan dao = new dao_pembersihanSQL();
    private CrudState crudState;
    
    public void setDAO(dao_pembersihan d){
        dao = d;
    }
    
    public void manipulate(m_pembersihan k, CrudState c){
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
    
    public List<m_pembersihan> getAllPembersihan() {
        return dao.getAllPembersihan();
    }
    public String getJml(){
        return dao.getJml();
    }
}
