/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class m_ikan {
    private String id;
    private m_tahap tahap;
    private String nama_ikan;
    private int ph;
    private int suhu;
    
    public m_ikan(String id,m_tahap tahap ,String nama,int suhu,int ph){
        this.id = id;
        this.suhu = suhu;
        this.nama_ikan = nama;
        this.ph = ph;
        this.tahap = tahap;
    }
    public m_ikan(String id,String nama){
        this.id = id;
        this.nama_ikan = nama;
        
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    public m_tahap getTahap(){
        return this.tahap;
    }
    
    public void setTahap(m_tahap tahap){
        this.tahap = tahap;
    }
    public String getNamaIkan(){
        return nama_ikan;
    }
    public void setNamaIkan(String nama){
        this.nama_ikan = nama;
    }
    
    public int getSuhu(){
        return this.suhu;
    }
    public void setSuhu(int suhu){
        this.suhu = suhu;
    }
    
    
    public int getPh(){
        return this.ph;
    }
    
    public void setPh(int ph){
        this.ph = ph;
    }
    @Override
    public String toString() {
        return this.nama_ikan;
    }
}
