/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.feria.bd.Conexion;
import org.feria.bean.Sensor;

/**
 *
 * @author Alumno
 */
public class SensorDAO extends DAOAbstracto implements DispositivosDAOFactory<Sensor>{

    public SensorDAO(Conexion con) {
        super(con);
    }
    
    @Override
    public List<Sensor> getListaDispositivos() {
        try {
            ResultSet rs = con.executeQueryRS("SELECT * FROM sensor");
            List<Sensor> lista = new ArrayList<>();
            while (rs.next()) {
                Sensor sen = new Sensor();
                sen.setId(rs.getInt(1));
                sen.setPin(rs.getInt(2));
                sen.setNombre(rs.getString(3));
                sen.setIdtipo(rs.getInt(4));
                sen.setDescripcion(rs.getString(5));
                lista.add(sen);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(SensorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Sensor getDispositivoById(int id) {
        try {
            ResultSet rs = con.executeQueryRS("SELECT * FROM sensor WHERE id_sensor = " + id);
            if (rs.next()) {
                Sensor sen = new Sensor();
                sen.setId(rs.getInt(1));
                sen.setPin(rs.getInt(2));
                sen.setNombre(rs.getString(3));
                sen.setIdtipo(rs.getInt(4));
                sen.setDescripcion(rs.getString(5));
                return sen;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SensorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Sensor getDispositivoBYPin(int pin) {
        try {
            ResultSet rs = con.executeQueryRS("SELECT * FROM sensor WHERE pin_sensor = " + pin);
            if (rs.next()) {
                Sensor sen = new Sensor();
                sen.setId(rs.getInt(1));
                sen.setPin(rs.getInt(2));
                sen.setNombre(rs.getString(3));
                sen.setIdtipo(rs.getInt(4));
                sen.setDescripcion(rs.getString(5));
                return sen;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SensorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
