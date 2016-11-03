/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.model;

import java.util.List;
import org.feria.bd.Conexion;
import org.feria.bean.Usuario;

/**
 *
 * @author Alumno
 */
public class UsuarioDAO extends DAOAbstracto implements UsuarioDAOFactory{

    public UsuarioDAO(Conexion con) {
        super(con);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getUsuarioByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isUsuarioValid(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
