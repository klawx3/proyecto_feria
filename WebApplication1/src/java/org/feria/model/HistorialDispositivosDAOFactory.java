/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.feria.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Alumno
 */
public interface HistorialDispositivosDAOFactory<E> {
    List<E> getAllHistorialDispositivo();
    List<E> getHistorialDispositivoBetween(Date initialDate,Date endDate);
}
