/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class user_session {
   private static String id;
    private static String username;
    private static String nama_lengkap;
    private static m_level level;
    private static String password;

    public static String getId(){
        return id;
    }
    public static void setId(String id){
        user_session.id = id;
    }
    public static String getUsername(){
        return username;
    }
    public static void setUsername(String usrname){
        user_session.username = usrname;
    }
    public static String getNama(){
        return nama_lengkap;
    }
    public static void setNama(String nama){
        user_session.nama_lengkap = nama;
    }
    
    public static String getPassword(){
        return password;
    }
    public static void setPassword(String pass){
        user_session.password = pass;
    }
    public static m_level getLevel(){
        return user_session.level;
    }
    public static void setLevel(m_level level){
        user_session.level = level;
    } 
}
