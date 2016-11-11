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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HistorialActuador getLastHistoricoDispositivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
