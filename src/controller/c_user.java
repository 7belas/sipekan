/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.dao_user;
import dao.dao_userSQL;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import model.CrudState;
import model.m_user;


public class c_user extends Observable {

    private dao_user dao = new dao_userSQL();
    private CrudState crudState;

    public void setDAO(dao_user d) {
        dao = d;
    }

    public void manipulate(m_user u, CrudState c) {
        boolean result = false;
        this.crudState = c;
        
        boolean status = dao.cek_username(u.getUsername());
        System.out.println(status);
        if (status == true && this.crudState == CrudState.INSERT) {
            result = false;
        } else {
            switch (c) {
                case INSERT:
                    result = dao.insert(u);
                    break;
                case UPDATE:
                    result = dao.update(u);
                    System.out.println(result);
                    break;
                case DELETE:
                    result = dao.delete(u);
                    break;
            }
        }

        setChanged();
        if (result) {
            notifyObservers(u);
        } else if (result == false) {
            notifyObservers();
        }
    }

    public CrudState getCrudState() {
        return crudState;
    }

    public String cek_login(String username, String password) {
        return dao.getByUsernamePassword(username, password);

    }

    public List<m_user> getAllUser() {
        return dao.getAllUser();
    }
    public List<m_user> getUserByID(String id) {
        return dao.getByID(id);
    }
}
