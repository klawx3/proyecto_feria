/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.model;

import java.util.List;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Actuador getDispositivoById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Actuador getDispositivoBYPin(int pin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
