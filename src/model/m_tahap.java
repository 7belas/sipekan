/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class m_tahap {
    private String id;
    private String nama_tahap;
    
    public m_tahap(String id,String nama_tahap){
        this.id = id;
        this.nama_tahap = nama_tahap;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getNamaTahap(){
        return this.nama_tahap;
    }
    
    public void setNamaTahap(String nama_tahap){
        this.nama_tahap = nama_tahap;
    }
    @Override
    public String toString() {
        return this.nama_tahap;
    }
}
