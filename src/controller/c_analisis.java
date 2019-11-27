/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.dao_analisis;
import dao.dao_analisisSQL;
import java.util.List;
import java.util.Observable;
import model.CrudState;
import model.m_analisis;
import model.m_ikan;
import model.m_kolam;


public class c_analisis extends Observable {
  private dao_analisis dao = new dao_analisisSQL();
    private CrudState crudState;
    
    public void setDAO(dao_analisis d){
        dao = d;
    }
    
    public void manipulate(m_analisis a, CrudState c){
        boolean result = false;
        this.crudState = c;
        
        switch (c){
            case INSERT:
                result = dao.insert(a);
                break;
        }
        
        setChanged();
        if (result){
            notifyObservers(a);
        }else{
            notifyObservers();
        }
    }
    
    public CrudState getCrudState(){
        return crudState;
    }
    
    public List<m_analisis> getAllAnalisis() {
        return dao.getAllAnalisis();
    }
    
    public String hasil_analisis(m_ikan i, m_kolam k){
        String hasil = "";
        
            
        if(k.getPh() > i.getPh()+2 ){
            hasil += "pH kolam lebih besar dari pH role ikan,tambahkan larutan basa ";
        } 
        if(k.getPh() < i.getPh()+2 ){
            hasil += "pH kolam lebih kecil dari pH role ikan,tambahkan larutan asam";
        }
        if(k.getSuhu() > i.getSuhu()+5){
            hasil += "Suhu kolam lebih besar dari suhu role ikan,atur suhu hingga pas";
        }
        if(k.getSuhu() < i.getSuhu()+5){
            hasil += "Suhu kolam lebih kecil dari suhu role Ikan,atur suhu hingga pas";
        }
         else{
            hasil += "Kolam ikan dalam kondisi baik";
        }
        return hasil;
    
        
    }
    public String getJml(){
        return dao.getJml();
    }
}
