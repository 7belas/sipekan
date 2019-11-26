/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class m_level {

    private String id_level;
    private String nama_level;

    public m_level(String id, String nama_level) {
        this.id_level = id;
        this.nama_level = nama_level;
    }
    public String getId() {
        return id_level;
    }
    
    public void setId(String id){
        this.id_level = id;
    }
    public String getLevel() {
        return nama_level;
    }
    
    public void setLevel(String nama_level){
        this.nama_level = nama_level;
    }
    @Override
    public String toString() {
        return this.nama_level;
    }
}
