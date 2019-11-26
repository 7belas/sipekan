/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class m_analisis {
    private String id;
    private String hasil_analisis;
    private String tgl_analisis;
    private m_ikan ikan;
    private m_kolam kolam;
    private m_user user;
    
    public m_analisis(String id, String hasil, String tgl_analisis,m_user user,m_kolam kolam,m_ikan ikan){
        this.id = id;
        this.hasil_analisis= hasil;
        this.tgl_analisis = tgl_analisis;
        this.user = user;
        this.kolam = kolam;
        this.ikan = ikan;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getHasil(){
        return hasil_analisis;
    }
    public void setHasil(String hasil){
        this.hasil_analisis = hasil;
    }
    
    public String getTanggal(){
        return tgl_analisis;
    }
    public void setTanggal(String tgl){
        this.tgl_analisis = tgl;
    }
    
    
    public m_ikan getIkan(){
        return this.ikan;
    }
    public void setIkan(m_ikan ikan){
        this.ikan = ikan;
    }
    
    public m_kolam getKolam(){
        return this.kolam;
    }
    public void setKolam(m_kolam kolam){
        this.kolam = kolam;
    }
    
    public m_user getUser(){
        return this.user;
    }
    public void setUser(m_user user){
        this.user = user;
    }


}
