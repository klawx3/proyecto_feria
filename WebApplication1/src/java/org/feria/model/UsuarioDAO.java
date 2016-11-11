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
        try {
            ResultSet rs = con.executeQueryRS("SELECT * FROM usuario");
            List<Usuario> lista = new ArrayList<>();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setEmail(rs.getString(1));
                usu.setEncrypted_password(rs.getString(2));

                lista.add(usu);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(SensorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Usuario getUsuarioByEmail(String email) {
        try {
            ResultSet rs = con.executeQueryRS("SELECT * FROM usuario WHERE email_usuario = " + email);
            if (rs.next()) {
                Usuario usu = new Usuario();
                usu.setEmail(rs.getString(1));
                usu.setEncrypted_password(rs.getString(2));
                return usu;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SensorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean isUsuarioValid(String email, String password) {
        int valido = 0;
        ResultSet rs = con.executeQueryRS("select count (*) from usuario "
                + "where email_usuario= '"+email+"' and password_usuario = '"+password+"'");
        try {
            if(rs.next()){
                valido = rs.getInt(1);
            }   
            if(valido >= 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
