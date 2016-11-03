/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.model;

import java.util.List;
import org.feria.bean.Usuario;

/**
 *
 * @author Alumno
 */
public interface UsuarioDAOFactory {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioByEmail(String email);
    boolean isUsuarioValid(String email,String password);
}
