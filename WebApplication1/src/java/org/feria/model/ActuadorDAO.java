/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.feria.bd.Conexion;
import org.feria.bean.Actuador;

/**
 *
 * @author Alumno
 */
public class ActuadorDAO  extends DAOAbstracto implements DispositivosDAOFactory<Actuador> {

    public ActuadorDAO(Conexion con) {
        super(con);
    }

    @Override
    public List<Actuador> getListaDispositivos() {
        try {
            ResultSet rs = con.executeQueryRS("SELECT * FROM actuador");
            List<Actuador> lista = new ArrayList<>();
            while (rs.next()) {
                Actuador act = new Actuador();
                act.setId(rs.getInt(1));
                act.setPin(rs.getInt(2));
                act.setNombre(rs.getString(3));
                act.setId_tipo(rs.getInt(4));
                act.setDescripcion(rs.getString(5));
                lista.add(act);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(SensorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Actuador getDispositivoById(int id) {
        try {
            ResultSet rs = con.executeQueryRS("SELECT * FROM acutuador WHERE id_actuador = " + id);
            if (rs.next()) {
                Actuador act = new Actuador();
                act.setId(rs.getInt(1));
                act.setPin(rs.getInt(2));
                act.setNombre(rs.getString(3));
                act.setId_tipo(rs.getInt(4));
                act.setDescripcion(rs.getString(5));
                return act;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SensorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }

    @Override
    public Actuador getDispositivoBYPin(int pin) {
        try {
            ResultSet rs = con.executeQueryRS("SELECT * FROM acutuador WHERE pin_actuador = " + pin);
            if (rs.next()) {
                Actuador act = new Actuador();
                act.setId(rs.getInt(1));
                act.setPin(rs.getInt(2));
                act.setNombre(rs.getString(3));
                act.setId_tipo(rs.getInt(4));
                act.setDescripcion(rs.getString(5));
                return act;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SensorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }



    
}
