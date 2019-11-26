/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.dao_ikan;
import dao.dao_ikanSQL;
import java.util.List;
import java.util.Observable;
import model.CrudState;
import model.m_ikan;


public class c_ikan extends Observable {
    private dao_ikan dao = new dao_ikanSQL();
    private CrudState crudState;
    
    public void setDAO(dao_ikan d){
        dao = d;
    }
    
    public void manipulate(m_ikan i, CrudState c){
        boolean result = false;
        this.crudState = c;
        
        switch (c){
            case INSERT:
                result = dao.insert(i);
                break;
            case UPDATE:
                result = dao.update(i);
                break;
            case DELETE:
                result = dao.delete(i);
                break;
        }
        
        setChanged();
        if (result){
            notifyObservers(i);
        }else{
            notifyObservers();
        }
    }
    
    public CrudState getCrudState(){
        return crudState;
    }
    
    public List<m_ikan> getAllIkan() {
        return dao.getAllIkan();
    }
    public String getJml(){
        return dao.getJml();
    }
}
