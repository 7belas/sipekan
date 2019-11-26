/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class m_kolam {

    private String id;
    private m_tahap tahap;
    private String nama_kolam;
    private int volume_kolam;
    private int suhu;
    private int ph;

    public m_kolam(String id, m_tahap tahap, String nama, int volume,int suhu,int ph) {
        this.id = id;
        this.tahap = tahap;
        this.nama_kolam = nama;
        this.volume_kolam = volume;
        this.suhu = suhu;
        this.ph = ph;
    }
    
    public m_kolam(String id,String nama) {
        this.id = id;
        this.nama_kolam = nama;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public int getSuhu() {
        return this.suhu;
    }

    public void setSuhu(int suhu) {
        this.suhu = suhu;
    }
    
    public m_tahap getTahap() {
        return this.tahap;
    }

    public void setTahap(m_tahap tahap) {
        this.tahap = tahap;
    }

    public String getNamaKolam() {
        return nama_kolam;
    }

    public void setNamaKolam(String nama) {
        this.nama_kolam = nama;
    }

    public int getVolume() {
        return this.volume_kolam;
    }

    public void setVolume(int volume) {
        this.volume_kolam = volume;
    }

    public int getPh() {
        return this.ph;
    }

    public void setPh(int ph) {
        this.ph = ph;
    }
    
    
    @Override
    public String toString() {
        return this.nama_kolam;
    }
}
