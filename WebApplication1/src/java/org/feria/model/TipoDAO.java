/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.model;

import org.feria.bd.Conexion;
import org.feria.bean.Tipo;

/**
 *
 * @author Alumno
 */
public class TipoDAO extends DAOAbstracto implements TipoDAOFactory {

    public TipoDAO(Conexion con) {
        super(con);
    }

    @Override
    public Tipo getTipoLikeDescripcion(String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tipo getTipoById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
