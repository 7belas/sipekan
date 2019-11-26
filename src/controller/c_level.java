/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.dao_level;
import dao.dao_levelSQL;
import java.util.List;
import model.CrudState;
import model.m_level;
import model.m_user;


public class c_level {
    private dao_level dao = new dao_levelSQL();
    private CrudState crudState;
    public List<m_level> getAllLevel() {
        return dao.getAllLevel();
    }
}
