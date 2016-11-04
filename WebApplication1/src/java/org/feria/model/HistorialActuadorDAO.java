/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.model;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import org.feria.bd.Conexion;

/**
 *
 * @author Alumno
 */
public class HistorialActuadorDAO extends DAOAbstracto implements HistorialDispositivosDAOFactory<HistorialActuadorDAO> {

    public HistorialActuadorDAO(Conexion con) {
        super(con);
    }

    @Override
    public List<HistorialActuadorDAO> getAllHistorialDispositivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistorialActuadorDAO> getHistorialDispositivoBetween(Date initialDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HistorialActuadorDAO getLastHistoricoDispositivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
