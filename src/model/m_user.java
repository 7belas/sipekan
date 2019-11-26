/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class m_user {
    private String id;
    private String username;
    private String nama_lengkap;
    private m_level level;
    private String password;
    
    public m_user(String id,String username,String nama,m_level level){
        this.id = id;
        this.username= username;
        this.nama_lengkap = nama;
        this.level = level;
    }
    public m_user(String id,String usrname,String nama,m_level level,String password){
        this.id = id;
        this.username= usrname;
        this.nama_lengkap = nama;
        this.level = level;
        this.password = password;
    }
    public m_user(String id,String username,String nama){
        this.id = id;
        this.username= username;
        this.nama_lengkap = nama;
    }

    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String usrname){
        this.username = usrname;
    }
    public String getNama(){
        return this.nama_lengkap;
    }
    public void setNama(String nama){
        this.nama_lengkap = nama;
    }
    
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String pass){
        this.password = pass;
    }
    public m_level getLevel(){
        return this.level;
    }
    public void setLevel(m_level level){
        this.level = level;
    }
}
