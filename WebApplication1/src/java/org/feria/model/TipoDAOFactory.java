/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.model;

import org.feria.bean.Tipo;

/**
 *
 * @author Alumno
 */
public interface TipoDAOFactory {
    Tipo getTipoLikeDescripcion(String descripcion);
    Tipo getTipoById(int id);
    
}
