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
import org.feria.bean.HistorialActuador;

/**
 *
 * @author Alumno
 */
public class HistorialActuadorDAO extends DAOAbstracto implements HistorialDispositivosDAOFactory<HistorialActuador> {

    public HistorialActuadorDAO(Conexion con) {
        super(con);
    }

    @Override
    public List<HistorialActuador> getAllHistorialDispositivo() {
        try {
            int id_historial, fk_actuador, valor_historial = 0;
            Date fecha_historial = null;
            String fk_usuario = null;

            ResultSet rs = con.executeQueryRS("SELECT * FROM historial_actuador");

            List<HistorialActuador> lista = new ArrayList<>();

            while (rs.next()) {
                id_historial = rs.getInt(1);
                fk_actuador = rs.getInt(2);
                fecha_historial = rs.getDate(3);
                valor_historial = rs.getInt(4);
                fk_usuario = rs.getString(5);

                HistorialActuador hActuador = new HistorialActuador(
                        id_historial, fk_actuador, fecha_historial, valor_historial, fk_usuario
                );

                lista.add(hActuador);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(HistorialActuadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<HistorialActuador> getHistorialDispositivoBetween(Date initialDate, Date endDate) {
        try {
            int id_historial, fk_actuador, valor_historial = 0;
            Date fecha_historial = null;
            String fk_usuario = null;

            ResultSet rs = con.executeQueryRS("SELECT * FROM historial_actuador WHERE fecha_historial BETWEEN '" + initialDate + "' AND '" + endDate + "'");

            List<HistorialActuador> lista = new ArrayList<>();

            while (rs.next()) {
                id_historial = rs.getInt(1);
                fk_actuador = rs.getInt(2);
                fecha_historial = rs.getDate(3);
                valor_historial = rs.getInt(4);
                fk_usuario = rs.getString(5);

                HistorialActuador hActuador = new HistorialActuador(
                        id_historial, fk_actuador, fecha_historial, valor_historial, fk_usuario
                );

                lista.add(hActuador);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(HistorialActuadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HistorialActuador getLastHistoricoDispositivo() {
        try {
            int id_historial, fk_actuador, valor_historial = 0;
            Date fecha_historial = null;
            String fk_usuario = null;

            ResultSet rs = con.executeQueryRS("SELECT * FROM historial_actuador ORDER BY id DESC LIMIT 1");

            if (rs.next()) {
                id_historial = rs.getInt(1);
                fk_actuador = rs.getInt(2);
                fecha_historial = rs.getDate(3);
                valor_historial = rs.getInt(4);
                fk_usuario = rs.getString(5);

                HistorialActuador hActuador = new HistorialActuador(
                        id_historial, fk_actuador, fecha_historial, valor_historial, fk_usuario
                );
                return hActuador;
            }

        } catch (SQLException ex) {
            Logger.getLogger(HistorialActuadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void addNewHistorico(HistorialActuador dispositivo) {
        con.execute(String.format("INSERT INTO historial_sensor VALUES (NULL,%d,now(),%d,'%d')",
                 dispositivo.getId_dispositivo(),
                 dispositivo.getValor(),
                 dispositivo.getEmail_id_usuario()));
    }

}
