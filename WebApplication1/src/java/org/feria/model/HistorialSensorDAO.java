/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.model;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class HistorialSensorDAO implements HistorialDispositivosDAOFactory<HistorialSensorDAO>{
    
    private final Connection con;
    
    public HistorialSensorDAO(Connection con){
        this.con = con;
    }

    @Override
    public List<HistorialSensorDAO> getAllHistorialDispositivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistorialSensorDAO> getHistorialDispositivoBetween(Date initialDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HistorialSensorDAO getLastHistoricoDispositivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
