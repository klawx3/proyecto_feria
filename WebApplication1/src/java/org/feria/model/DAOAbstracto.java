/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.model;

import org.feria.bd.Conexion;

/**
 *
 * @author Alumno
 */
public abstract class DAOAbstracto {
    protected Conexion con;
    
    public DAOAbstracto(Conexion con){
        this.con = con;
    }
    
}
