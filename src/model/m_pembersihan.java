/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class m_pembersihan {

    private String id;
    private m_kolam kolam;
    private String deskripsi;

    public m_pembersihan(String id, m_kolam kolam, String deskripsi) {
        this.id = id;
        this.kolam = kolam;
        this.deskripsi = deskripsi;
        
    }
    
    public m_pembersihan(String id) {
        this.id = id;
    }

    public m_pembersihan(String string, m_kolam m_kolam, String string0, int aInt, int aInt0, int aInt1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    
    public m_kolam getKolam() {
        return this.kolam;
    }

    public void setKolam(m_kolam kolam) {
        this.kolam = kolam;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    
    @Override
    public String toString() {
        return this.deskripsi;
    }
}
