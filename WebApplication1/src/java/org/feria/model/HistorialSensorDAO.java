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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.feria.bd.Conexion;
import org.feria.bean.HistorialSensor;

/**
 *
 * @author Alumno
 */
public class HistorialSensorDAO extends DAOAbstracto implements HistorialDispositivosDAOFactory<HistorialSensor> {

    public HistorialSensorDAO(Conexion con) {
        super(con);
    }

    @Override
    public List<HistorialSensor> getAllHistorialDispositivo() {
        try {
            int id_historial, fk_sensor, valor_historial = 0;
            Date fecha_historial = null;

            ResultSet rs = con.executeQueryRS("SELECT * FROM historial_sensor");

            List<HistorialSensor> lista = new ArrayList<>();

            while (rs.next()) {
                id_historial = rs.getInt(1);
                fk_sensor = rs.getInt(2);
                fecha_historial = rs.getDate(3);
                valor_historial = rs.getInt(4);

                HistorialSensor hSensor = new HistorialSensor(
                        id_historial, fk_sensor, fecha_historial, valor_historial
                );

                lista.add(hSensor);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(HistorialActuadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<HistorialSensor> getHistorialDispositivoBetween(Date initialDate, Date endDate) {
        try {
            int id_historial, fk_sensor, valor_historial = 0;
            Date fecha_historial = null;

            ResultSet rs = con.executeQueryRS("SELECT * FROM historial_sensor WHERE fecha_historial BETWEEN '"+initialDate+"' AND '"+endDate+"'");

            List<HistorialSensor> lista = new ArrayList<>();

            while (rs.next()) {
                id_historial = rs.getInt(1);
                fk_sensor = rs.getInt(2);
                fecha_historial = rs.getDate(3);
                valor_historial = rs.getInt(4);

                HistorialSensor hSensor = new HistorialSensor(
                        id_historial, fk_sensor, fecha_historial, valor_historial
                );

                lista.add(hSensor);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(HistorialActuadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HistorialSensor getLastHistoricoDispositivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
